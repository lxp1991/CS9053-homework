package edu.nyu.cs9053.homework10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * User: blangel
 * Date: 11/16/14
 * Time: 3:50 PM
 */
public class ThreadedFilesWordCounter extends AbstractConcurrencyFactorProvider implements FilesWordCounter {

	public class MyRunner implements Runnable {
		
		private final String word;
		
		private final Callback callback;
		
		private final List<Integer> fileIDList;
		
		public MyRunner(String word, Callback callback, List<Integer> fileIDList) {
			this.word = word;
			this.callback = callback;
			this.fileIDList = fileIDList;
		}
		
		@Override
		public void run() {
			while(isRunning && !fileIDList.isEmpty()) {
				int fileID = fileIDList.get(0);
				String fileName =fileMap.get(fileID);
				fileIDList.remove(0);
				String content = files.get(fileName);
				Pattern pattern = Pattern.compile(word);
				Matcher matcher = pattern.matcher(content);
				while (matcher.find()) {
					countWord.incrementAndGet();
					callback.counted(fileName, countWord.get());
				}	
			}
		}
	}
	
    /**
     * @param filesNum
     * @param threadNum
     * @return Inner List<Integer> denotes the index that one thread is responsible for, outer List denotes how many thread
     *         For example there are 4 threads and 9 files, it will generate: [[0,1],[2,3],[4,5],[6,7,8,9]]
     */
    private static List<List<Integer>> assignTask(int filesNum, int threadNum) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	int fileID = 0;
    	int chunks = filesNum / threadNum;
    	int remainder = filesNum % threadNum;
    	for (int i = 0; i < threadNum; i++) {
    		List<Integer> cur = new ArrayList<Integer>();
    		for (int j = 0; j < chunks; j++) {
        		cur.add(fileID++);
        	}    		
    		res.add(new ArrayList<Integer>(cur));
    	}
    	while (remainder > 0) {
    		res.get(res.size() - 1).add(fileID++);
    		remainder--;
    	}
    	
    	return res; 	
    }
	
	private boolean isRunning;
	
	private AtomicLong countWord;
	
	private final int concurrencyFactor;
	
	private Map<Integer, String> fileMap;
	
	List<List<Integer>> taskAssignment;
	
	private Map<String, String> files;
	
	private MyRunner[] myRunners;
	
	private Thread[] myThreads;
	
    public ThreadedFilesWordCounter(int concurrencyFactor) {
        super(concurrencyFactor);
        this.isRunning = true;
        this.concurrencyFactor = concurrencyFactor;
        this.fileMap = new HashMap<Integer, String>(5, 1.0f);
        myRunners = new MyRunner[concurrencyFactor];
        myThreads = new Thread[concurrencyFactor];
        countWord = new AtomicLong();
    }

    @Override public void count(Map<String, String> files, String word, Callback callback) {
    	if (concurrencyFactor > files.size()) {
    		throw new IllegalArgumentException("Error! The thread number should be less than files number");
    		//Because at least one file per thread
    	}
    	int fileID = 0;
    	for (Map.Entry<String, String> entry : files.entrySet()) {
    		fileMap.put(fileID++, entry.getKey());
    	}    
    	this.taskAssignment = assignTask(files.size(), concurrencyFactor);
    	this.files = files;
    	try {
    		for (int i = 0; i < taskAssignment.size(); i++) {
    			myRunners[i] = new MyRunner(word, callback, taskAssignment.get(i));
    			myThreads[i] = new Thread(myRunners[i]);
    			myThreads[i].start();
    		}
    	} catch (RuntimeException re) {
    		Thread.currentThread().interrupt();
    	}
    }
    
    @Override public void stop() {
        isRunning = false;
    }
}
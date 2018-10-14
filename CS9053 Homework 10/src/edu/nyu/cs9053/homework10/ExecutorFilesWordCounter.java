package edu.nyu.cs9053.homework10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: blangel
 * Date: 11/16/14
 * Time: 3:50 PM
 */
public class ExecutorFilesWordCounter extends AbstractConcurrencyFactorProvider implements FilesWordCounter {
	
	public class MyThread implements Callable<Long> {
				
		private final String word;
		
		private final Callback callback; 
		
		private final List<Integer> fileIDList;
		
		public MyThread(String word, Callback callback, List<Integer> fileIDList) {
			this.word = word;
			this.callback = callback;
			this.fileIDList = fileIDList;
		}
		
		@Override
		public Long call() throws Exception {
			while (!fileIDList.isEmpty()) {
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
			return countWord.get();	
		}
	}
	
    /**
     * @param filesNum
     * @param threadNum
     * @return Inner List<Integer> denotes the file ID that one thread is responsible for, outer List denotes how many thread
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

	private ExecutorService executor;
	
	private AtomicLong countWord;
	
	private Map<Integer, String> fileMap;
	
	List<List<Integer>> taskAssignment;
	
	private Map<String, String> files;
	
	private final int concurrencyFactor;
	
    public ExecutorFilesWordCounter(int concurrencyFactor) {
        super(concurrencyFactor);
        this.executor = Executors.newFixedThreadPool(concurrencyFactor);
        this.concurrencyFactor = concurrencyFactor;
        this.countWord = new AtomicLong();
        this.fileMap = new HashMap<Integer, String>();
    }

    @Override public void count(Map<String, String> files, String word, Callback callback) {
        // TODO - implement this class using calls to an ExecutorService; with one call per {@linkplain concurrencyFactor}.
        // HINT - do not create the ExecutorService object in this method
    	int fileID = 0;
    	for (Map.Entry<String, String> entry : files.entrySet()) {
    		fileMap.put(fileID++, entry.getKey());
    	}    
    	this.taskAssignment = assignTask(files.size(), concurrencyFactor);
    	this.files = files;
    	// TODO - implement this class using Thread objects; one Thread per {@link #concurrencyFactor} with each Thread handling at most one file at one time
        // HINT - do not create the ExecutorService object in this method
    	try {
    		for (int i = 0; i < taskAssignment.size(); i++) {
    			executor.submit(new MyThread(word, callback, taskAssignment.get(i)));
    		}
    	} catch (RuntimeException re) {
    		//Thread.currentThread().interrupt();
    		stop();
    	}
    }

    @Override public void stop() {
        executor.shutdown();
    }

}
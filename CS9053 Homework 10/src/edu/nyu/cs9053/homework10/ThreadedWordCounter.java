package edu.nyu.cs9053.homework10;

import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: blangel
 * Date: 11/16/14
 * Time: 3:16 PM
 */
public class ThreadedWordCounter extends AbstractConcurrencyFactorProvider implements WordCounter {
	
	public class MyRunner implements Runnable {
		
		private final String content; 
		
		private final String word;
		
		private final Callback callback;
		
		public MyRunner(String content, String word, Callback callback) {
			this.content = content;
			this.word = word;
			this.callback = callback;
		}
		
		@Override
		public void run() {
			while(isRunning) {
				Pattern pattern = Pattern.compile(word);
				Matcher matcher = pattern.matcher(content);
				while (matcher.find()) {
					countWord.incrementAndGet();
					callback.counted(countWord.get());
				}	
			}
		}
	}
	
    //reference: http://www.coderanch.com/t/479953/java/java/Split-String-Based-String-Length
    public static String[] splitByLength(String s, int chunkSize) {  	
        int arraySize = (int) Math.ceil((double) s.length() / chunkSize);
        String[] returnArray = new String[arraySize];    
        int index = 0;
        
        for(int i = 0; i < s.length(); i = i+chunkSize) {
            if(s.length() - i < chunkSize) {
                returnArray[index++] = s.substring(i);
            } 
            else {
                returnArray[index++] = s.substring(i, i+chunkSize);
            }
        }
        return returnArray;
    }
	
	private AtomicLong countWord;
	
	private Runnable[] myRunners;
	
	private Thread[] myThreads;
	
	private String[] splitedString;
	
	private volatile boolean isRunning = true; 
	
	public ThreadedWordCounter(int concurrencyFactor) {
        super(concurrencyFactor);
        myRunners = new MyRunner[concurrencyFactor];
        myThreads = new Thread[concurrencyFactor];
        countWord = new AtomicLong();
    }

    @Override public void count(String fileContents, String word, Callback callback) {
        // TODO - implement this class using Thread objects; one Thread per {@link #concurrencyFactor}
        // HINT - break up {@linkplain fileContents} and distribute the work across the threads
        // HINT - do not create the Thread objects in this method
    	splitedString = splitByLength(fileContents, myRunners.length);
    	try {
    		for (int i = 0; i < myRunners.length; i++) {
        		myRunners[i] = new MyRunner(splitedString[i], word, callback);
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
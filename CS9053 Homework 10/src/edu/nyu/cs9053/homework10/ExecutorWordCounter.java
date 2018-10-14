package edu.nyu.cs9053.homework10;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: blangel
 * Date: 11/16/14
 * Time: 3:33 PM
 */
public class ExecutorWordCounter extends AbstractConcurrencyFactorProvider implements WordCounter {
	
	public class MyThread implements Callable<Long> {
		
		private final String content; 
		
		private final String word;
		
		private final Callback callback; 
		
		public MyThread(String content, String word, Callback callback) {
			this.content = content;
			this.word = word;
			this.callback = callback;
		}
		
		@Override
		public Long call() throws Exception {
			Pattern pattern = Pattern.compile(word);
			Matcher matcher = pattern.matcher(content);
			while (matcher.find()) {
				countWord.incrementAndGet();
				callback.counted(countWord.get());
			}
			return countWord.get();
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
    
	private final ExecutorService executor;
	
	private String[] splitedString;
	
	private AtomicLong countWord;
	
	private final int concurrencyFactor;

    public ExecutorWordCounter(int concurrencyFactor) {
        super(concurrencyFactor);
        this.concurrencyFactor = concurrencyFactor;
        executor = Executors.newFixedThreadPool(concurrencyFactor);
        countWord = new AtomicLong();
    }

    @Override public void count(String fileContents, String word, Callback callback) {
        // TODO - implement this class using calls to an ExecutorService; one call per {@link #concurrencyFactor}
        // HINT - break up {@linkplain fileContents} and distribute the work across the calls
        // HINT - do not create the ExecutorService object in this method
    	
    	try {
			splitedString = splitByLength(fileContents, concurrencyFactor);
			for (int i = 0; i < concurrencyFactor; i++) {
				executor.submit(new MyThread(splitedString[i], word, callback));
				callback.counted(countWord.get());
			}
		} catch (RuntimeException e) {
			stop();
		}
    }

    @Override public void stop() {
        executor.shutdown();
    }
    
    
}
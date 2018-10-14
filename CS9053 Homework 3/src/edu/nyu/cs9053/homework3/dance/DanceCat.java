package edu.nyu.cs9053.homework3.dance;

import java.util.Random;

public class DanceCat {
	private final String name;
	
	private final DanceMove[] danceMoves;
	
	private static final int DEFAULT_MOVES = 18;
	
	private static final String DEFAULT_NAME = "Java learner";
	
    private static final Random RANDOM = new Random();
    
    private static final int MAX_COMPUTER_LEVEL = 100;
	
	//Check if a string is blank or null
    private static boolean isNullOrBlank(String s)
    {
    	return s == null || s.trim().equals("");
    }
	
    private static String[] convertStringToStringArray(final String stringToSplit) {
		if (isNullOrBlank(stringToSplit))
			throw new IllegalArgumentException();
		String[] parsedMoves = new String[DEFAULT_MOVES];
		final int length = stringToSplit.length();
		if (length <= DEFAULT_MOVES) {
			//pad with empty string if not enough string 
			for (int i = 0; i < length; i++) {
				parsedMoves[i] = String.valueOf(stringToSplit.charAt(i));	
			}
			for (int i = length; i < 18; i++) {
				parsedMoves[i] = "";
			}
		} else {
			for (int i = 0; i < DEFAULT_MOVES; i++) {
				parsedMoves[i] = String.valueOf(stringToSplit.charAt(i));
			}
		}
		return parsedMoves;	
	}
    
	private static DanceMove[] generateObjectsWithStringArrayPairs(final String[] moves, final String[] idealMoves) {
		if (moves == null || idealMoves == null || moves.length != idealMoves.length)
			throw new IllegalArgumentException();
		DanceMove[] danceMoves = new DanceMove[DEFAULT_MOVES];
		for (int i = 0; i < DEFAULT_MOVES; i++) {
			danceMoves[i] = new DanceMove(moves[i], idealMoves[i]);
		}
		return danceMoves;
	}
	
	//Generate the random int number between 0 - 100(max computer level)
	public static int getComputerLevel() {
		return RANDOM.nextInt(MAX_COMPUTER_LEVEL + 1);
	}
	
	public DanceCat(final String unparsedMoves, final String[] idealMoves) {
		this(convertStringToStringArray(unparsedMoves), idealMoves);
	}
	
	public DanceCat(final String[] moves, final String[] idealMoves) {
		this(generateObjectsWithStringArrayPairs(moves, idealMoves));
	}
	
	public DanceCat(final DanceMove[] danceMoves) {
		this(DEFAULT_NAME, danceMoves);
	}
	
	public DanceCat(final String name, final DanceMove[] danceMoves) {
		this.name = name;
		this.danceMoves = danceMoves;
	}
	
	public String getName() {
		return name;
	}

	public DanceMove[] getDanceMoves() {
		return danceMoves;
	}

	public int getNumberOfCorrectMoves() {
		int count = 0;
		for (int i = 0; i < DEFAULT_MOVES; i++) {
			if (this.danceMoves[i].correctMove())
				count++;
		}
		return count;
	}
}

package utils;

import java.util.Random;
import java.util.ArrayList;

public class ArrayListUtils {
	static Random rand = new Random();
	
	public static ArrayList<String> addToRandomPosition(String packet, ArrayList<String> list){
		int index = rand.nextInt(list.size() + 1);
		list.add(index, packet);
		return list;
	}
	
	/*
	 * Subsets part of an ArrayList<String>, because for some reason Eclipse is refusing to work with generics,
	 * and I don't particularly care to waste time implementing my own version.
	 */
	public static ArrayList<String> subset(ArrayList<String> list, int left, int right){
		ArrayList<String> nl = new ArrayList<String>();
		for(int i = left; i < right; i ++){
			try{
				nl.add(list.get(i));
			} catch(Exception e){
				
			}
		}
		
		return nl;
	}
}

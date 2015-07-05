package Utils;

import java.util.Random;
import java.util.ArrayList;

public class ArrayListUtils {
	static Random rand = new Random();
	
	public static ArrayList<String> addToRandomPosition(String packet, ArrayList<String> list){
		int index = rand.nextInt(list.size() + 1);
		list.add(index, packet);
		return list;
	}
}

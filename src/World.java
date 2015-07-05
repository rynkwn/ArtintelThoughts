import java.util.ArrayList;
import java.util.Random;

public class World {
	private int length;
	private int height;
	private Square[][] grid;
	private ArrayList<Organism> life;
	
	public World(int x, int y){
		length = x;
		height = y;
		grid = new Square[x][y];
		life = new ArrayList<Organism>();
	}
	
	/*
	 * Seeds num organisms in the given world.
	 */
	public World(int x, int y, int num){
		length = x;
		height = y;
		grid = new Square[x][y];
		life = new ArrayList<Organism>();
		seed(num);
	}
	
	/*
	 * Seeds a set num of randomized 1N organisms to the life list.
	 */
	public void seed(int num){
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		Random rand = new Random();
		
		int randH = rand.nextInt(height);
		int randL = rand.nextInt(length);
		int alphaIndex = rand.nextInt(alpha.length());
		String dnaChunk = alpha.charAt(alphaIndex) + "";
		
		for(int i = 0; i < num; i ++){
			Organism org = new Organism(100, randL, randH);
			org.addPacket(dnaChunk);
			life.add(org);
			
			randH = rand.nextInt(height);
			randL = rand.nextInt(length);
			alphaIndex = rand.nextInt(alpha.length());
			dnaChunk = alpha.charAt(alphaIndex) + "";
		}
	}
	
	/*
	 * Iterates through each organism in the life list and lets them take an action.
	 */
	public void day(){
		for(Organism o : life){
			takeAction(o);
		}
	}
	
	public void takeAction(Organism org){
		String instr = org.iterateBrain(); 
		int x = org.X();
		int y = org.Y();
		
		switch(instr){
		case "a":
			break;
		case "u":
			if(y > 0)
				org.setY(y - 1);
			break;
		case "r":
			if(x < length - 1)
				org.setX(x + 1);
			break;
		case "l":
			if(x > 0)
				org.setX(x - 1);
			break;
		case "d":
			if(y < height - 1)
				org.setY(y + 1);
			break;
		default:			
		}
	}
	
	public String peerGlobal(){
		int[][] map = new int[length][height];
		for(Organism o : life){
			int x = o.X();
			int y = o.Y();
			map[x][y] = 1;
		}
		
		String output = "";
		for(int i = 0; i < height; i ++){
			for(int j = 0; j < length; j ++){
				if(map[i][j] == 0){
					output += "[ ]";
				} else{
					output += "[O]";
				}
				
				if(j == length - 1)
					output += "\n";
			}
		}
		return output;
	}
}
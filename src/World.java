import java.util.ArrayList;

public class World {
	private int length;
	private int width;
	private Square[][] grid;
	private ArrayList<Organism> life;
	
	public World(int x, int y){
		length = x;
		width = y;
		grid = new Square[x][y];
		life = new ArrayList<Organism>();
	}
	
	
}
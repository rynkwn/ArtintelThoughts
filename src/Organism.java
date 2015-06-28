
public class Organism {
	private double biomass;
	private Pos pos;
	
	public Organism(double b, int x, int y){
		biomass = b;
		pos = new Pos(x, y);
	}
	
	public int X(){
		return pos.X();
	}
	
	public int Y(){
		return pos.Y();
	}
}

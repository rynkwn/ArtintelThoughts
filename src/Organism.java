import java.util.ArrayList;

public class Organism {
	private double biomass;
	private Pos pos;
	private ArrayList<String> dna;
	private ArrayList<String> brain;
	private int pointer;
	
	/*
	public Organism (double b, int x, int y, String sub){
		biomass = b;
		pos = new Pos(x, y);
		dna = new ArrayList<String>();
	}
	*/
	
	public Organism(double b, int x, int y){
		biomass = b;
		pos = new Pos(x, y);
		dna = new ArrayList<String>();
		pointer = 0;
	}
	
	public void addPacket(String s){
		brain.add(s);
	}
	
	public void addAcid(String s){
		dna.add(s);
	}
	
	public String readPointer(){
		return brain.get(pointer);
	}
	
	public String iterateBrain(){
		String packet = readPointer();
		incrementPointer();
		if(pointer >= brain.size())
			resetPointer();
		return packet;
	}
	
	public void incrementPointer(){
		pointer ++;
	}
	
	public void resetPointer(){
		pointer = 0;
	}
	
	public void setX(int x){
		pos.setX(x);
	}
	
	public void setY(int y){
		pos.setY(y);
	}
	
	public void addBio(double add){
		biomass += add;
	}
	
	public void subBio(double sub){
		biomass -= sub;
	}
	
	public int X(){
		return pos.X();
	}
	
	public int Y(){
		return pos.Y();
	}
	
	public double biomass(){
		return biomass;
	}
	
	public String dna(){
		String output = "";
		for(String packet : dna)
			output += packet;
		return output;
	}
	
	public String brain(){
		String output = "";
		for(String packet : brain)
			output += packet;
		return output;
	}
}

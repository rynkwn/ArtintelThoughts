package base;
import java.util.ArrayList;
import java.util.Random;

import utils.ArrayListUtils;

public class Organism {
	private double biomass;
	private Pos pos;
	private ArrayList<String> dna;
	private ArrayList<String> brain;
	private int pointer;
	private Memory pastSelf;
	
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
		brain = new ArrayList<String>();
		pointer = 0;
	}
	
	public void remember(){
		pastSelf = new Memory(this);
	}
	
	/*
	 * Was the goal reached?
	 */
	public void consider(){
		if(goalCheck(pastSelf)){ // Goal Failure
			rethink();
		}
	}
	
	/*
	 * Modify instruction set.
	 */
	public void rethink(){
		brain = ArrayListUtils.addToRandomPosition(getRandomDNA(), brain);
		// Right now, let's cap the brain size to 10 instruction pieces
		if(brain.size() > 10)
			brain = ArrayListUtils.subset(brain, 0, 10);
	}
	
	public void addPacket(String s){
		brain.add(s);
	}
	
	public void addAcid(String s){
		dna.add(s);
	}
	
	public String readPointer(){
		if(brain.size() == 0)
			return "";
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

	public Pos pos(){
		return pos;
	}
	
	public ArrayList<String> getBrain(){
		return brain;
	}
	
	public ArrayList<String> getDNA(){
		return dna;
	}
	
	public String getRandomDNA(){
		Random rand = new Random();
		int index = rand.nextInt(dna.size());
		return dna.get(index);
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
	
	public boolean goalCheck(Memory m){
		return this.X() == m.pos.X() && this.Y() == m.pos.Y(); 
	}
}

package utils;

import java.util.ArrayList;

import base.Organism;
import base.Pos;

public class PosMap {
	private ArrayList<ArrayList<Organism>> hashPos;
	private int x;
	private int y;

	public PosMap(int x, int y, ArrayList<Organism> list){
		hashPos = new ArrayList<ArrayList<Organism>>();
		this.x = x;
		this.y = y;
		fill();
	}
	
	public void fill(){
		while(hashPos.size() < x * y){
			hashPos.add(new ArrayList<Organism>());
		}
	}
	
	public int hash(Pos pos){
		return pos.X() + (x * pos.Y());
	}
	
	public void createHash(ArrayList<Organism> list){
		for(Organism o : list){
			Pos pos = o.pos();
			int index = hash(pos);
			hashPos.get(index).add(o);
		}
	}
	
	public ArrayList<Organism> get(Pos p){
		int index = hash(p);
		return hashPos.get(index);
	}
	
	
}

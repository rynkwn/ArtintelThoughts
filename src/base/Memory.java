package base;
import java.util.ArrayList;


public class Memory {
	public double biomass;
	public Pos pos;
	public ArrayList<String> dna;
	public ArrayList<String> brain;
	
	public Memory(Organism o){
		biomass = o.biomass();
		pos = new Pos(o.X(), o.Y());
		dna = o.getDNA();
		brain = o.getBrain();
	}
}

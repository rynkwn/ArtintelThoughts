package base;
import java.util.Scanner;


public class Main {

	public static void main(String [] args){
		System.out.println("----INSTRUCTIONS----");
		System.out.println("Press any key to run one step");
		System.out.println();
		System.out.println("Press 'r', enter, and then an integer n");
		System.out.println("to run n+1 continuous steps.");
		
		int length = 30;
		int height = 30;
		//Bitzy Code
		Organism bitzy = new Organism(100, length/2, height/2);
		bitzy.addAcid("u");
		bitzy.addAcid("r");
		bitzy.addAcid("d");
		bitzy.addAcid("l");
		
		World world = new World(length, height, 0);
		world.addLife(bitzy);
		Scanner scan = new Scanner(System.in);
		Thread thread = new Thread();
		String input = scan.nextLine();
		
		while(!input.equals("q")){
		    System.out.println(world.peerGlobal());
		    input = scan.nextLine();
		    
		    if(input.equals("r")){ //Running n+1 iterations.
			    int iterations = scan.nextInt();
			    for(int z = 0; z < iterations; z++){
			    	world.day();
			    	System.out.println(world.peerGlobal());
			    	try{
			    		thread.sleep(150);
			    	}catch(Exception e){}
			    }
		    } else if(input.equals("a")){ //Reading all organism details.
		    	System.out.println(world.lifeDetails());
		    }
		    world.day();
		}
	}
}

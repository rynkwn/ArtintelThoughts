import java.util.Scanner;


public class Main {

	public static void main(String [] args){
		System.out.println("----INSTRUCTIONS----");
		System.out.println("Press any key to run one step");
		System.out.println();
		System.out.println("Press 'r', enter, and then an integer n");
		System.out.println("to run n+1 continuous steps.");
		
		World world = new World(30, 30, 60);
		Scanner scan = new Scanner(System.in);
		Thread thread = new Thread();
		String input = scan.nextLine();
		
		while(!input.equals("q")){
		    System.out.println(world.peerGlobal());
		    input = scan.nextLine();
		    if(input.equals("r")){
			    int iterations = scan.nextInt();
			    for(int z = 0; z < iterations; z++){
			    	world.day();
			    	System.out.println(world.peerGlobal());
			    	try{
			    		thread.sleep(150);
			    	}catch(Exception e){}
			    }
		    }
		    world.day();
		}
	}
}

package base;

public class Pos {
	private int x;
	private int y;
	
	public Pos(int a, int b){
		x = a;
		y = b;
	}
	
	public void setX(int a){
		x = a;
	}
	
	public void setY(int b){
		y = b;
	}
	
	public int X(){
		return x;
	}
	
	public int Y(){
		return y;
	}
	
	public Pos up(){
		return new Pos(x, y-1);
	}
	
	public Pos down(){
		return new Pos(x, y+1);
	}
	
	public Pos left(){
		return new Pos(x-1, y);
	}
	
	public Pos right(){
		return new Pos(x+1, y);
	}
}

package base;
public class Square{
	private double biomassGround;
	private double biomassAir;
	
	public Square(double a, double b){
		biomassGround = a;
		biomassAir = b;
	}
	
	public void addAir(double add){
		biomassAir += add;
	}
	
	public void addGround(double add){
		biomassGround += add;
	}
	
	public boolean decAir(double dec){
		if(dec <= biomassAir){
			biomassAir -= dec;
			return true;
		}
		return false;
	}
	
	public boolean decGround(double dec){
		if(dec <= biomassGround){
			biomassGround -= dec;
			return true;
		}
		return false;
	}
	
	public double biomassGround(){
		return biomassGround;
	}
	
	public double biomassAir(){
		return biomassAir;
	}
}

package prokins;

public class Pig {
	private int health = 1920;
	private Point location = new Point(1920/2,1080/2);
	public void Pig(){
		
	}
	public Point getLocation(){
		return location;
	}
	
	public void incrementHealth(){
		health--;
	}
	
	
	public void eatBacon(){
		if(health<1280){
			health+=640;
		}
		else{
			health = 1920;
		}
	}
	
	
	public void fall(){
		if(flight > 4){
			flight = 4;
			gravity = 1;
		}
		if(location.y >=200){
			gravity = 0;
		}
		location = new Point(location.y+gravity,location.x);
		gravity*=1.3;
		
	}
	
	
	public void flap(){
		gravity = 0;
		location = new Point(location.y-flight, location.x);
		flight*=1.03;
		//fly up half the screen
		//fly up for 1/2 a second
	}
	
	
	public void moveRight(){
		location = new Point(location.y, location.x+1);
	}
}

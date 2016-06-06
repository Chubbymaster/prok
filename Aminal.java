package prokins;

import java.util.Random;

public class Aminal{
	private boolean right = false;
	private String type;
	private double speed;
	private Polygon hitbox;
	private Point p;
	
	public void Animal(String animalType, boolean direction){
		type = animalType;
		right = direction;
		Random randy = new Random();
		speed = randy.nextDouble()*100;
		Point[] boxP = {new Point(0,0), new Point(100,0), new Point(100,90), new Point(0,90)};
		p = new Point(randy.nextInt(1720)+101,980);
		hitbox = new Polygon(boxP,p,0);
	}
	
	public void turn(){
		if(right){
			right = false;
		}
		else{
			right = true;
		}
	}
	
	public double getSpeed(){
		return speed;
	}
	
	public String getType(){
		return type;
	}
	
	public boolean getDirection(){
		return right;
	}
}

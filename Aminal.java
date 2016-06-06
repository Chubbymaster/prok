package prokins;

import java.util.Random;

public class Aminal{
	private boolean right = false;
	private String type;
	private double speed;
	
	
	public void Animal(String animalType, boolean direction){
		type = animalType;
		right = direction;
		Random randy = new Random();
		speed = randy.nextDouble()*100;
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

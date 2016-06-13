package porkins.game;

import javafx.scene.image.Image;

public class HorseSprite extends Sprite{
	int left, right;
	int imgNum;
	int counter;
	boolean one; 
	
	public HorseSprite(Image img, double xPos, double yPos, double w, double h, double xVelocity, double yVelocity){
		super(img, xPos, yPos, w, h, xVelocity, yVelocity);
		left = 0;
		right = 1820;
		imgNum = 1;
		counter = 25;
		one = true;
	}
	
	public void setLeft(int n){
		left = n;
	}
	
	public void setRight(int n){
		right = n;
	}
	
	public void move(double xVelocity){
		x += xVelocity;
		if(x<left || x>right)
			xVel = -xVel;
		counter--;
	}
	
	public void changeImg(Image img){
		image = img;
	}

}

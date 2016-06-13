package porkins.game;

import javafx.scene.image.Image;

public class PigSprite extends Sprite {
	final int top = 0;
	final int bottom = 880;
	final int left = 0;
	final int right = 1820;
	int health = 1820;
	int counter = 15;
	int counter2 = 15;
	boolean intersect;
	boolean intersect2;
	double origXVel, origYVel;
	
	public PigSprite(Image image, double xPos, double yPos, double w, double h,
			double xVelocity, double yVelocity) {
		super(image, xPos, yPos, w, h, xVelocity, yVelocity);
		intersect= false;
		intersect2 = false;
		origXVel = xVel;
		origYVel = yVel;
	}
	
	public void move(double xChange, double yChange){
		x += xChange;
		y += yChange;
		if(x < left){
			xVel = 0;
			x = left;
		}
		if(x > right){
			xVel = 0;
			x = right;
		}
		if(y < top){
			yVel = 0;
			y = top;
		}
		if(y>bottom){
			yVel = 0;
			y = bottom;
		}
			
	}
	
	
	public void decrHealth(){
		health-=.25;
		if(health<0)
			health = 0;
	}

}

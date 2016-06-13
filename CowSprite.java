
package porkins.game;

import javafx.scene.image.Image;

public class CowSprite extends Sprite{
	int left, right;
	int imgNum;
	
	public CowSprite(Image img, double xPos, double yPos, double w, double h, double xVelocity, double yVelocity){
		super(img, xPos, yPos, w, h, xVelocity, yVelocity);
		left = 0;
		right = 1820;
		imgNum = 1;
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
	}
	
	public void changeImg(){
		if(imgNum==1)
			imgNum = 2;
		else
			imgNum = 1;
	}
}

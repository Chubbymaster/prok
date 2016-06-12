package porkins.game;

import javafx.scene.image.Image;

public class SheepSprite extends HorseSprite{
	int left, right;
	double top, bottom;
	int imgNum;

	public SheepSprite(Image img, double xPos, double yPos, double w, double h,
			double xVelocity, double yVelocity) {
		super(img, xPos, yPos, w, h, xVelocity, yVelocity);
		left = 0;
		right = 1820;
		top = yPos - 50;
		bottom = yPos;
	}
	
	public void setTop(double d){
		top = d;
	}
	
	public void setBottom(double d){
		bottom = d;
	}
	public void move(double xVelocity, double yVelocity){
		x += xVelocity;
		y += yVelocity;
		if(x<left || x>right)
			xVel = -xVel;
		if(y>bottom || y<top)
			yVel = -yVel;
	}

}

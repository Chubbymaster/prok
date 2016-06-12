package prokins;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import javafx.scene.image.Image;

public class RockSprite extends Sprite{
	static Point[] box = {new Point(-50,-50),new Point(50,-50), new Point(50,50), new Point(-50,50)};
	Polygon hitBox;
	static Random randy = new Random();
	public RockSprite(Image img, double xPos, double yPos, double w, double h,
			double xVelocity, double yVelocity) {
		super(img, xPos, yPos, w, h, xVelocity, yVelocity);
		hitBox = new Polygon(box,new Point((int)this.x,(int)this.y),0);
	}
}

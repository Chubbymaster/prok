package net.mrpaul.ads.mm190.ps11.asteroids;

import java.awt.*;
/**
 * The rock class
 * <p>The Asteroids class uses this to generate the rocks
 * ADS PS11: Asteroids
 * 12/22/15
 * 
 * @author Alex Wang
 * @implements KeyListener - checks for keyboard input
 * @extends Polygon - used to create the shape
 */
public class Asteroid extends Polygon{
	int height;
	int width;
	double howMove = this.rotation*Math.PI/180;//the unit of movement
	/**
	 * Constructs based on Polygon's super constructor
	 * @param inShape points of shape
	 * @param inPosition position of shape
	 * @param inRotation direction shape
	 */
	public Asteroid(Point[] inShape, Point inPosition, double inRotation){
		super(inShape,inPosition,inRotation);
		
	}
	/**
	 * Constructs based on Polygon's super constructor
	 * <p>Also inputs height and width
	 * @param inShape is used to create shape
	 * @param inPosition used to put the shape somewhere
	 * @param inRotation used to face the ship in a direction
	 * @param width play screen width
	 * @param height play screen height
	 */
	public Asteroid(Point[] inShape, Point inPosition, double inRotation, int height, int width){
		super(inShape, inPosition, inRotation);
		this.height=height;
		this.width= width;
	}
	/**
	 * Paints those rocks!
	 * @author Alex Wang
	 * @param brush
	 */
	void paint(Graphics brush){
		Point[] shape = this.getPoints();
		int[] xCoord = new int[shape.length];
		int[] yCoord = new int[shape.length];
		for(int x = 0; x<shape.length; x++){
			xCoord[x] = (int) shape[x].x;
			yCoord[x] = (int) shape[x].y;
		}
		brush.drawPolygon(xCoord,yCoord, shape.length);
		
	}
	/**
	 * Moves automatically
	 * @author Alex Wang
	 */
	void move(){
		Point pos = new Point(2*Math.cos(howMove)+this.position.x,2*Math.sin(howMove)+this.position.y);
		this.position = new Point((pos.x+this.height)%this.height, (pos.y+this.width)%this.width);
	}
}

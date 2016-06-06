package net.mrpaul.ads.mm190.ps11.asteroids;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * The bullet class
 * <p>The Asteroids class uses this to generate its only bullet
 * ADS PS11: Asteroids
 * 12/22/15
 * 
 * @author Alex Wang
 * @implements KeyListener - checks for keyboard input
 * @extends Polygon - used to create the shape
 */
public class Bullets extends Polygon implements KeyListener{
	static final Point[] bulletShape = {new Point(0,0), new Point(1,0),new Point(1,1), new Point(0,1)};//basically a circle
	double howMove = this.rotation*Math.PI/180;//rotation to rads
	int height;
	int width;
	int howFar = 0;
	boolean shoot = false;//detaches from body
	boolean exists = false;//instantiates
	static int counterBullet = 0;
	/**
	 * Constructs a bullet
	 * <p>Uses the polygon class to create a nice 'circle'
	 * @param pos uses as the points that make up the shape
	 * @param rot the direction of the bullet
	 * @param width the width of the play screen
	 * @param height the height of the play screen
	 */
	public Bullets(Point pos, double rot, int width, int height){

		super(bulletShape, new Point(pos.x,pos.y), rot);//makes a circle with the data from the ship		
		this.height=height;
		this.width=width;

	}
	/**
	 * Moves the bullet
	 * @author Alex Wang
	 */
	public void move(){
		howFar++;
		if(howFar<100){
			howMove = this.rotation*Math.PI/180;//converts to radians every time
			Point pos = new Point(5*Math.cos(howMove)+this.position.x,5*Math.sin(howMove)+this.position.y);//moves by a factor of five
			this.position = new Point((pos.x+this.width)%this.width, (pos.y+this.height)%this.height);//wrap around
		}
		//if it goes for far enough, delete it
		else{
			howFar = 0;
			exists = false;
		}
	}
	/**
	 * Paints the bullet
	 * @author Alex Wang
	 * @param brush I still dont know what this is really
	 */
	public void paint (Graphics brush){
		//this literally just draws the bullet
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
	 * Tests if the space bar was pressed
	 * @author Alex Wang
	 */
	public void keyPressed(KeyEvent e){
		if(!exists){
			int keyCode = e.getKeyCode();
			switch( keyCode ) { 
			case KeyEvent.VK_SPACE:
				shoot = true;
				
			}
		}

	}
	/**
	 * Fulfills implement reqs
	 * @author Alex Wang
	 */
	public void keyReleased(KeyEvent e) {
		
		
	}

	/**
	 * Fulfills implement reqs
	 * @author Alex Wang
	 */
	public void keyTyped(KeyEvent e) {
		
	}
}

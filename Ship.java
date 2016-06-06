package net.mrpaul.ads.mm190.ps11.asteroids;

import java.awt.*;
import java.awt.event.*;
/**
 * The ship class
 * <p>The Asteroids class uses this to generate the on-screen ship
 * ADS PS11: Asteroids
 * 12/22/15
 * 
 * @author Alex Wang
 * @implements KeyListener - checks for keyboard input
 * @extends Polygon - used to create the shape
 */
public class Ship extends Polygon implements KeyListener{
	double howMove = this.rotation*Math.PI/180;//rotation to rads
	boolean upForward = false;//if you're moving
	boolean right = false;//if you're turning
	boolean left = false;//if you're turning
	boolean invincible = false;//if you've used the invincibility hack
	int height;//height of the play screen
	int width;//width of the play screen
	/**
	 * Uses the constructor in Polygon
	 * @author Alex Wang
	 * @param inShape is used to create shape
	 * @param inPosition used to put the shape somewhere
	 * @param inRotation used to face the ship in a direction
	 */
	public Ship(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);
		
	}
	/**
	 * Uses the Polygon super constructor and adds height and width of play screen
	 * @author Alex Wang
	 * @param inShape is used to create shape
	 * @param inPosition used to put the shape somewhere
	 * @param inRotation used to face the ship in a direction
	 * @param width play screen width
	 * @param height play screen height
	 */
	public Ship(Point[] inShape, Point inPosition, double inRotation, int width, int height){
		super(inShape, inPosition, inRotation);
		this.height=height;
		this.width= width;
	}
	/**
	 * Paints that stuff bro
	 * @author Alex Wang
	 * @param brush
	 */
	void paint (Graphics brush){
		//paint is like the same for all of these
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
	 * Moves that stuff bro!
	 * <p>Also tests if you are pressing right left or forward
	 * @author Alex Wang
	 */
	public void move(){
		
		Point pos = new Point(0,0);
		if(upForward){//2 is the increment of movement, cos of rotation is change in x
			pos = new Point(2*Math.cos(howMove)+this.position.x,2*Math.sin(howMove)+this.position.y);
			//this.position = new Point((pos.x+this.width)%this.width, (pos.y+this.height)%this.height);//does a wrap-around
			//this.position = new Point(100, 100);//does a wrap-around
		}
		//changes rotation
		if(left){
			this.rotation-=2;
			this.rotation%=360;
			howMove = this.rotation*Math.PI/180;
		}
		//changes rotation
		if(right){
			this.rotation+=2;
			this.rotation%=360;
			howMove = this.rotation*Math.PI/180;
		}
		
	}
	/**
	 * Checks if arrow keys were pressed
	 * @author Alex Wang
	 */
	public void keyPressed(KeyEvent e){
		int keyCode = e.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_RIGHT:
	        	right = true;	        	
	            break;
	        case KeyEvent.VK_UP:
	        	upForward = true;
	        	break;
	        case KeyEvent.VK_LEFT:
	        	left = true;
	        	break;
	        case KeyEvent.VK_I://turns on or off the invincibility hack
	        	if(invincible){
	        		invincible = false;
	        	}
	        	else{
	        		invincible = true;
	        	}
	        	break;
	    }
	        	
	}
	/**
	 * Checks if you let go of the buttons
	 * @author Alex Wang
	 */
	public void keyReleased(KeyEvent e){
		int keyCode = e.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_RIGHT:
	        	right = false;	        	
	            break;
	        case KeyEvent.VK_UP:
	        	upForward = false;
	        	break;
	        case KeyEvent.VK_LEFT:
	        	left = false;
	        	break;
	    }
	}
	/**
	 * Fulfills implements reqs
	 * @author Alex Wang
	 */
	public void keyTyped(KeyEvent e){
		
	}
}

package prokins;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pig implements KeyListener extends Aminal{
	private int health = 1920;
	private Point location = new Point(1920/2,1080/2);
	private double gravity = 1;
	private double flight = 4;
	private boolean right = false;
	private int flapping = 10000;
	private Image pigRight = new Image("file:pigRight.png", 0, 75, true, false);
	private Image pigLeft = new Image("file:pigLeft.png", 0, 75, true, false);
	private ImageView prView = new ImageView(pigRight);
	private ImageView lookLeft = new ImageView(pigLeft);
	
	public Pig(Point p, boolean direction){
		right = direction;
		location = p;
	}


	public Point getLocation(){
		return location;
	}


	public void incrementHealth(){
		health--;
	}


	public void eatBacon(){
		if(health<1280){
			health+=640;
		}
		else{
			health = 1920;
		}
	}


	public void fall(){
		if(flight > 4){
			flight = 4;
			gravity = 1;
		}
		if(location.y+gravity>1720){
			location = new Point(200, location.x);
			gravity = 0;
		}
		else{
			location = new Point(location.y+gravity,location.x);
			gravity*=1.3;
		}
	}


	public void flap(){
		flapping--;
		gravity = 0;
		if(location.y+flight<100){
			location = new Point(1820,location.x); 
			flight = 0;
		}
		else{
			location = new Point(location.y-flight, location.x);
			flight*=1.03;
		}
		//fly up half the screen
		//fly up for 1/2 a second
		if(flapping!=0){
			flap();
		}
		else{
			gravity = 1;
			fall();
		}
	}

	/*
	public void moveRight(){
		if(location.x<1820){
			location = new Point(location.y, location.x+1);
		}
	}


	public void moveLeft(){
		if(location.x>100){
			location = new Point(location.y, location.x-1);
		}
	}
	*/
	
	public void move(){
		if(right){
			if(location.x<1820){
				location = new Point(location.y, location.x+1);
			}
		}
		else{
			if(location.x>100){
				location = new Point(location.y, location.x-1);
			}
		}
	}


	@Override
	public void keyTyped(KeyEvent e) {
		int keyCode = e.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_RIGHT:
	        	right = true;	        	
	            move();
	            break;
	        case KeyEvent.VK_LEFT:
	        	right = false;
	        	move();
	        	break;
	        case KeyEvent.VK_SPACE:
	        	flapping = 10000;
	        	flap();
	        	break;
	    }
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

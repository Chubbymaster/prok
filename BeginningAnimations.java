package net.mrpaul.ads.mm190.ps11.asteroids;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * The beginning animations
 * <p>The Asteroids class uses this to generate the beginning asteroid stuff
 * ADS PS11: Asteroids
 * 12/22/15
 * 
 * @author Alex Wang
 * @implements KeyListener - checks for keyboard input
 */
public class BeginningAnimations implements KeyListener{
	static final String ast = "Asteroids!";//prints the title
	static final String play = "Hit enter to play!";//prints simple directions to get in game
	static final String rulesMenu = "Hit 'q' to see the rules." ;//prints the rules text
	boolean playing = false, rules = false;
	int height;//screen height
	int width;//screen width

	/**
	 * Creates animation from height and width
	 * @author Alex Wang
	 * @param width screen width
	 * @param height screen height
	 */
	public BeginningAnimations(int width, int height){
		this.height = height;
		this.width = width;
	}
	/**
	 * Paints the effect
	 * @author Alex Wang
	 * @param brush
	 */
	public void paint(Graphics brush){
		Font newFont = brush.getFont().deriveFont(brush.getFont().getSize() * 10F);//increases size
		brush.setFont(newFont);
		brush.setColor(Color.white);
		brush.drawString(ast, 120,300);
		newFont = brush.getFont().deriveFont(brush.getFont().getSize() / 7F);//decreases size
		brush.setFont(newFont);
		brush.drawString(play, 325,400);
		brush.drawString(rulesMenu, 325, 425);
	}
	/**
	 * Checks for pressed keys
	 * @author Alex Wang
	 */
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch( keyCode ) { 
		case KeyEvent.VK_ENTER:
			playing = true;	        	
			break;

		case KeyEvent.VK_Q://enters and exits rules menu
			if(rules){
				rules = false;
			}
			else{
				rules = true;
			}
			break;
		}

	}
	/**
	 * Checks if keys were released
	 * @author Alex Wang
	 */
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch( keyCode ) { 
		case KeyEvent.VK_ENTER:
			playing = false;	        	
			break;
		}
	}
	/**
	 * Meets implements reqs
	 * @author Alex Wang
	 */
	public void keyTyped(KeyEvent e) {

	}
}

package net.mrpaul.ads.mm190.ps11.asteroids;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * The most annoying class
 * <p>The Asteroids class uses this to generate the crazy end effect
 * ADS PS11: Asteroids
 * 12/22/15
 * 
 * @author Alex Wang
 * @implements KeyListener - checks for keyboard input
 * @extends Polygon - used to create the shape
 */
public class EndingAnimations implements KeyListener{
	int letter, space;//basically tries to use the dimensions of the play screen
	//warning, if you change the play screen size, it's not as calibrated unfortunately
	int letterHeight;
	int letterSpace = 20;
	int height;
	int width;
	boolean playing = false, menu = false;
	Polygon gShape, aShape, mShape, eShape, oShape, vShape, e2Shape, rShape, oCircle, aCircle, rCircle;
	/**
	 * Creates the objects
	 * @author Alex Wang
	 * @param width screen width
	 * @param height screen height
	 */
	public EndingAnimations(int width, int height){
		letter = width/6-16;
		space = (width-letter*6)/7;
		letterHeight = height/3-letterSpace;
		
		
		//does the g
		Point[] gPoints = {new Point(0,0), new Point(letter,0), new Point(letter,letterHeight/6), 
				new Point((letter/4)+1,letterHeight/6), new Point(letter/4+1, letterHeight/6),//check for error
				new Point((letter/4)+1, letterHeight-(letterHeight/6)), new Point(letter-(letter/4+1), letterHeight-(letterHeight/6)),
				new Point(((letter/4)+1)*2, letterHeight-(letterHeight/3)), new Point(((letter/4)+1)*2, letterHeight/2),
				new Point(letter, letterHeight/2), new Point(letter,letterHeight), 
				new Point(0,letterHeight)};
		Point gPoint = new Point(space+letter/2, letterHeight/2-11);
		gShape = new Polygon(gPoints, gPoint, 0);
		
		
		//does the a
		Point[] aPoints = {new Point(0,0), new Point(letter,0), new Point(letter,letterHeight),
				new Point(letter-((letter/4)+1), letterHeight), new Point(letter-((letter/4)+1),letterHeight-letterHeight/3),
				new Point(letter/4+1,letterHeight-letterHeight/3), new Point(letter/4+1,letterHeight),
				new Point(0,letterHeight)};
		Point aPoint = new Point(2*space+letter+letter/2,letterHeight/2-21);
		aShape = new Polygon(aPoints, aPoint, 0);
		
		
		//does the bit of black in the a
		Point[] aCirclePoints = {new Point(0,0), new Point(2*(letter/4+1)-5, 0), new Point(2*(letter/4+1)-5, letterHeight/3-7), new Point(0,letterHeight/3-7)};
		Point aCPoint = new Point(space+space+letter/2+letter+15, letterHeight/2-15);
		aCircle = new Polygon(aCirclePoints, aCPoint, 0);
		
		
		//does the m
		Point[] mPoints = {new Point(0,0), new Point(letter/4+1, 0), new Point(2*(letter/4+1),letterHeight/2),
			new Point(letter-(letter/4+1),0), new Point(letter,0), new Point(letter,letterHeight),
			new Point(letter-(letter/4+1),letterHeight), new Point(letter-(letter/4+1), letterHeight-letterHeight/6),
			new Point(letter-(letter/4+1),letterHeight/2), new Point(2*(letter/4+1),letterHeight),
			new Point(letter/4+1, letterHeight/2), new Point(letter/4+1, letterHeight),
			new Point(0,letterHeight)};
		Point mPoint = new Point(3*space+2*letter+letter/2-2, letterHeight/2-16);
		mShape = new Polygon(mPoints,mPoint,0);
		
		
		//does the e
		Point[] ePoints = {new Point(0,0), new Point(letter,0), new Point(letter, letterHeight/6), new Point(letter/4+1, letterHeight/6),
				new Point(letter/4+1, 7*letter/12+6), new Point(2*(letter/4+1), 7*letter/12+6), new Point(2*(letter/4+1), letterHeight-(7*letter/12+6)),
				new Point(letter/4+1,letterHeight-(7*letter/12+6)), new Point(letter/4+1,letterHeight-letterHeight/6), new Point(letter,letterHeight-letterHeight/6),
				new Point(letter,letterHeight), new Point(0, letterHeight)};
		Point ePoint = new Point(4*space+3*letter+letter/2-12,letterHeight/2-16);
		eShape = new Polygon(ePoints,ePoint,0);
		
		
		//does the o
		Point[] oPoints = {new Point(0,0), new Point(letter,0), new Point(letter,letterHeight), new Point(0,letterHeight)};
		Point oPoint = new Point(3*space+2*letter+2*(letter/4+1)-49,2*letterHeight+letterHeight/4);
		oShape = new Polygon(oPoints,oPoint,0);
		
		
		//does the bit of black in the o
		Point[] oCirclePoints = {new Point(0,0), new Point(2*(letter/4+1),0), new Point(2*(letter/4+1), letterHeight-letterHeight/3),
				new Point(0, letterHeight-letterHeight/3)};
		Point oCircles = new Point(3*space+2*letter+2*(letter/4+1)-36,2*letterHeight+letterHeight/4+12);
		oCircle = new Polygon(oCirclePoints,oCircles,0);
		
		
		//does the v
		Point[] vPoints = {new Point(0,0), new Point(letter/4+1,0), new Point(2*(letter/4+1), letterHeight-letterHeight/6), new Point(letter-(letter/4+1),0),
				new Point(letter,0), new Point(letter-(letter/4+1), letterHeight), new Point(letter/4+1,letterHeight)};
		Point vPoint = new Point(3*space+2*letter+2*(letter/4+1)-36+letter,2*letterHeight+letterHeight/4+1);
		vShape = new Polygon(vPoints,vPoint,0);
		
		
		//does the second e based on the first e
		Point e2Point = new Point(3*space+4*letter+2*(letter/4+1)-36,2*letterHeight+letterHeight/4);
		e2Shape = new Polygon(ePoints,e2Point,0);
		
		
		//does the r
		Point[] rPoints = {new Point(0,0), new Point(letter, 0), new Point(letter,letterHeight/2+letterHeight/10), new Point(2*(letter/4+1)+10,letterHeight/2+letterHeight/10),
				new Point(letter,letterHeight), new Point(letter-(letter/4+1),letterHeight), new Point(letter/4+10,letterHeight/2+letterHeight/10),
				new Point(letter/4+1,letterHeight/2+letterHeight/10), new Point(letter/4+1,letterHeight), new Point(0,letterHeight)};
		Point rPoint = new Point(3*space+5*letter+2*(letter/4+1)-18,2*letterHeight+letterHeight/4-6);
		rShape = new Polygon(rPoints,rPoint,0);
		
		
		//does the bit of black in the r
		Point[] rCirclePoints = {new Point(0,0), new Point(2*(letter/4+1),0), new Point(2*(letter/4+1),letterHeight/3-5), new Point(0,letterHeight/3-5)};
		Point rCirclePoint = new Point(3*space+5*letter+2*(letter/4+1)-2,2*letterHeight+letterHeight/4-8);
		rCircle = new Polygon(rCirclePoints,rCirclePoint,0);
		}

	/**
	 * Paints the god awful effect
	 * @author Alex Wang
	 * @param brush
	 */
	public void paint(Graphics brush){
		
		//paints the g
		Point[] shapeG = gShape.getPoints();
		int[] xCoordG = new int[shapeG.length];
		int[] yCoordG = new int[shapeG.length];
		for(int x = 0; x<shapeG.length; x++){
			xCoordG[x] = (int) shapeG[x].x;
			yCoordG[x] = (int) shapeG[x].y;
		}
		brush.fillPolygon(xCoordG,yCoordG, shapeG.length);
	
		//paints the a
		Point[] shapeA = aShape.getPoints();
		int[] xCoordA = new int[shapeA.length];
		int[] yCoordA = new int[shapeA.length];
		for(int x = 0; x<shapeA.length; x++){
			xCoordA[x] = (int) shapeA[x].x;
			yCoordA[x] = (int) shapeA[x].y;
		}
		brush.fillPolygon(xCoordA,yCoordA, shapeA.length);
		brush.setColor(Color.black);
		
		//paints the a thing
		Point[] shapeAC = aCircle.getPoints();
		int[] xCoordAC = new int[shapeA.length];
		int[] yCoordAC = new int[shapeA.length];
		for(int x = 0; x<shapeAC.length; x++){
			xCoordAC[x] = (int) shapeAC[x].x;
			yCoordAC[x] = (int) shapeAC[x].y;
		}
		brush.fillPolygon(xCoordAC,yCoordAC, shapeAC.length);
		brush.setColor(Color.white);
		
		//paints the m
		Point[] shapeM = mShape.getPoints();
		int[] xCoordM = new int[shapeM.length];
		int[] yCoordM = new int[shapeM.length];
		for(int x = 0; x<shapeM.length; x++){
			xCoordM[x] = (int) shapeM[x].x;
			yCoordM[x] = (int) shapeM[x].y;
		}
		brush.fillPolygon(xCoordM,yCoordM, shapeM.length);
		
		//paints the e
		Point[] shapeE = eShape.getPoints();
		int[] xCoordE = new int[shapeE.length];
		int[] yCoordE = new int[shapeE.length];
		for(int x = 0; x<shapeE.length; x++){
			xCoordE[x] = (int) shapeE[x].x;
			yCoordE[x] = (int) shapeE[x].y;
		}
		brush.fillPolygon(xCoordE,yCoordE, shapeE.length);
		
		//paints the o
		Point[] shapeO = oShape.getPoints();
		int[] xCoordO = new int[shapeO.length];
		int[] yCoordO = new int[shapeO.length];
		for(int x = 0; x<shapeO.length; x++){
			xCoordO[x] = (int) shapeO[x].x;
			yCoordO[x] = (int) shapeO[x].y;
		}
		brush.fillPolygon(xCoordO,yCoordO, shapeO.length);
		
		brush.setColor(Color.black);
		
		//paints the o thing
		Point[] shapeOC = oCircle.getPoints();
		int[] xCoordOC = new int[shapeOC.length];
		int[] yCoordOC = new int[shapeOC.length];
		for(int x = 0; x<shapeO.length; x++){
			xCoordOC[x] = (int) shapeOC[x].x;
			yCoordOC[x] = (int) shapeOC[x].y;
		}
		brush.fillPolygon(xCoordOC,yCoordOC, shapeOC.length);
		
		brush.setColor(Color.white);
		
		//paints the v
		Point[] shapeV = vShape.getPoints();
		int[] xCoordV = new int[shapeV.length];
		int[] yCoordV = new int[shapeV.length];
		for(int x = 0; x<shapeV.length; x++){
			xCoordV[x] = (int) shapeV[x].x;
			yCoordV[x] = (int) shapeV[x].y;
		}
		brush.fillPolygon(xCoordV,yCoordV, shapeV.length);
		
		//paints the second e
		Point[] shapeE2 = e2Shape.getPoints();
		int[] xCoordE2 = new int[shapeE2.length];
		int[] yCoordE2 = new int[shapeE2.length];
		for(int x = 0; x<shapeE2.length; x++){
			xCoordE2[x] = (int) shapeE2[x].x;
			yCoordE2[x] = (int) shapeE2[x].y;
		}
		brush.fillPolygon(xCoordE2,yCoordE2, shapeE2.length);
		
		//paints the r
		Point[] shapeR = rShape.getPoints();
		int[] xCoordR = new int[shapeR.length];
		int[] yCoordR = new int[shapeR.length];
		for(int x = 0; x<shapeR.length; x++){
			xCoordR[x] = (int) shapeR[x].x;
			yCoordR[x] = (int) shapeR[x].y;
		}
		brush.fillPolygon(xCoordR,yCoordR, shapeR.length);
		
		brush.setColor(Color.black);
		
		//paints the r thing
		Point[] shapeRC = rCircle.getPoints();
		int[] xCoordRC = new int[shapeRC.length];
		int[] yCoordRC = new int[shapeRC.length];
		for(int x = 0; x<shapeRC.length; x++){
			xCoordRC[x] = (int) shapeRC[x].x;
			yCoordRC[x] = (int) shapeRC[x].y;
		}
		brush.fillPolygon(xCoordRC,yCoordRC, shapeRC.length);
		brush.setColor(Color.white);
	}
	/**
	 * Checks for keyboard input
	 * <p>It's used in this program because this input is at the end, like retry or menu
	 * @author Alex Wang
	 */
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch( keyCode ) { 
        case KeyEvent.VK_R:
        	playing = true;//restarts the game
            break;
		
		case KeyEvent.VK_M://menu
			menu = true;
			break;
		}
		
	}

	/**
	 * Checks if a key is released
	 * @author Alex Wang
	 */
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch( keyCode ) { 
        case KeyEvent.VK_R:
        	playing = false;	        	
            break;
            
        case KeyEvent.VK_M:
			menu = false;
			break;
		}
	}

	/**
	 * Meets the implements reqs
	 * @author Alex Wang
	 */
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

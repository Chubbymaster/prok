package net.mrpaul.ads.mm190.ps11.asteroids;

/*
CLASS: Asteroids
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

 */
import java.awt.*;
import java.util.*;
/**
 * Plays Asteroids! for PS11: Asteroids
 * <p>Uses a bunch of other user creates classes to print to the screen the game
 * ADS PS11: Asteroids
 * 12/22/15
 * 
 * @author Alex Wang
 */
class Asteroids extends Game {
	static int counter = 0;

	static boolean doneConstructing = false, flash = false, asteroids= false, plusOneThousand = false;//to be explained later
	static Ship ship;//my ship
	static Asteroid[] b;//my bunch of rocks
	static BeginningAnimations gameStart;//object for beginning animations
	static EndingAnimations gameOver;//object for ending animations
	static int flashCounter = 0;//tests when flash is over
	Bullets bulletOne;//one bullet
	static Point center;//center(i mean duh)
	static int timer;//timer counts for the plus one thousand
	/**
	 * Sets up the variables for the game
	 * @author Alex Wang
	 */
	public Asteroids() {
		super("Asteroids!",800,600);
		this.setFocusable(true);
		this.requestFocus();
		center = new Point(width/2, height/2);
		Point[] shipPoints = {new Point(0,0),new Point(20,5),new Point(0,10),new Point(4,5)};
		ship = new Ship(shipPoints, center,45, width, height);
		gameStart = new BeginningAnimations(800,600);

		bulletOne = new Bullets(ship.position,ship.rotation, this.width, this.height);//creates only bullet
		this.addKeyListener(bulletOne);//adds a key check to the bullet
		this.addKeyListener(gameStart);//adds a key check to the beginning animation object
		this.addKeyListener(ship);//adds a key check to the ship

		b = new Asteroid[6];//creates my rocks

		for(int asteroids = 0; asteroids<b.length; asteroids++){
			Random randy = new Random();//this generates a different set of points for each time you load up the game, and each rock is pseudorandomly generated
			Point[] asteroidPoints = {new Point(35+randy.nextInt(10),0+randy.nextInt(10)), new Point(63+randy.nextInt(10),17+randy.nextInt(10)),
					new Point(69+randy.nextInt(10),20+randy.nextInt(10)), new Point(80+randy.nextInt(10),45+randy.nextInt(10)), 
					new Point(76+randy.nextInt(10),70+randy.nextInt(10)), new Point(57+randy.nextInt(10),68+randy.nextInt(10)), 
					new Point(35+randy.nextInt(10),62+randy.nextInt(10)), new Point(22+randy.nextInt(10), 80+randy.nextInt(10)), 
					new Point(10+randy.nextInt(10),59+randy.nextInt(10)), new Point(14+randy.nextInt(10),44+randy.nextInt(10)), 
					new Point(3+randy.nextInt(10),30+randy.nextInt(10))};
			Point offset = new Point(randy.nextInt(801), randy.nextInt(601));//generates a random offset, problem of spawnkill removed by two second spawn invincibility
			int rotate = randy.nextInt(361);//sets a random rotation
			b[asteroids]= new Asteroid(asteroidPoints, offset, rotate, width, height);//creates yer asteroids
		}

		asteroids = true;//lets the game set up

		gameOver = new EndingAnimations(width,height);//creates the end game animations
		this.addKeyListener(gameOver);//adds a key check
	}
	/**
	 * Paints a bunch of stuff
	 * <p>I have no idea what the brush really is but whatever
	 * @author Alex Wang
	 */
	public void paint(Graphics brush) {


		if(asteroids){//if its done constructing get ready
			brush.setColor(Color.black);//fill the board
			brush.fillRect(0,0,width,height);


			//paint the beginning animation
			gameStart.paint(brush);
			for(int x = 0; x<Asteroids.b.length;x++){
				b[x].paint(brush);
				b[x].move();
			}


			//if they press q it sets up these rules on screen
			if(gameStart.rules){
				brush.setColor(Color.black);
				brush.fillRect(0,0,width,height);
				brush.setColor(Color.white);
				brush.drawString("Rules:",10,20);
				brush.drawString("Try to get the highest possible score by avoiding asteroids!",10,35);
				brush.drawString("Arrow key left turns your ship anticlockwise",10,50);
				brush.drawString("Arrow key right turns your ship clockwise",10,65);
				brush.drawString("Press up to move your ship in the direction your ship is facing",10,80);
				brush.drawString("Press space to shoot, but be careful, you can only shoot the one bullet until it disappears.",10,95);
				brush.drawString("Every time you shoot an asteroid, you get 1000 points, so hit those rocks!",10,110);
				brush.drawString("Good luck and have fun!", 10, 125);
				brush.drawString("Press 'q' again to go back to the main menu.", 10, 140);
				brush.setFont(brush.getFont().deriveFont(brush.getFont().getSize() / 2F));
				brush.drawString("Also, there's a secret key for a little easter egg, you can try them out!",10, this.height-100);
				brush.drawString("(warning, pressing the button has no OBVIOUS visible changes)",10,this.height-85);
			}


			//if they press enter it stops these animations and sets doneConstructing to true, running the game
			if(gameStart.playing){
				asteroids = false;
				doneConstructing = true;
			}
		}


		//runs the game
		if(doneConstructing){
			brush.setColor(Color.black);
			brush.fillRect(0,0,width,height);

			//hahaha, sorry, i used the counter as the score, a bit cheaty but works nicely i must admit
			counter++;


			//paints the ship in white
			brush.setColor(Color.white);
			brush.drawString(""+counter,10,10);
			ship.move();


			//bullets
			if(!bulletOne.exists){//makes sure when the bullet disappears it doesn't keep killing asteroids
				bulletOne.position = new Point(2*this.width, 2*this.height);
			}


			//if the bullet is shot put it where the ship is and fire it
			if(bulletOne.shoot){
				bulletOne.position = new Point(ship.position.x,ship.position.y);
				bulletOne.rotation = ship.rotation;
				brush.setColor(Color.white);
				bulletOne.paint(brush);
				bulletOne.exists = true;
				bulletOne.shoot = false;
			}


			//if the bullet isnt being shot right now but was just shot, start painting bud!
			if(bulletOne.exists&&!bulletOne.shoot){
				brush.setColor(Color.white);
				bulletOne.move();
				bulletOne.paint(brush);
			}


			//tests for collision of bullet and space rock
			for(int x = 0; x<b.length; x++){
				if(b[x].collide(bulletOne)){
					Point offset = new Point(0,0);
					Random randy = new Random();
					int edgeHeight = randy.nextInt(2);

					//the following generate the rock on the edge of the map
					if(edgeHeight==0){
						offset = new Point(this.width, randy.nextInt(this.height+1));
					}
					if(edgeHeight==1){
						offset = new Point(randy.nextInt(this.width+1),this.height);
					}

					//generates a random rotation
					int rotate = randy.nextInt(361);
					//puts the rock at the edge
					b[x].position = offset;
					b[x].rotation = rotate;

					//adds 1000 to your score per rock hit
					counter+=1000;
					bulletOne.exists = false;
					//plusOneThousand enables text to be printed outside of the for loop
					plusOneThousand = true;

				}
			}
			//check if the amount of time the +1000 has been up, then take it down
			if(timer == 50){
				plusOneThousand = false;
				timer = 0;
			}

			//print the +1000
			if(plusOneThousand&&timer<50){
				brush.setColor(Color.white);
				brush.setFont(brush.getFont().deriveFont(brush.getFont().getSize() *2F));
				brush.drawString("+1000!", this.width-200, 30);
				timer++;
			}

			//makes the ship flicker to show two seconds of spawn protection
			if(counter<200&&counter%50>33&&counter%50<50){
				brush.setColor(Color.black);
				ship.paint(brush);
				brush.setColor(Color.white);
			}

			//after two seconds stop flickering
			else{
				ship.paint(brush);
			}

			//draws asteroids and tests for collisions after spawn protection is off
			if(!ship.invincible){
				for(int x = 0; x<Asteroids.b.length;x++){
					brush.setColor(Color.white);
					b[x].paint(brush);
					b[x].move();
					if(counter > 200&&b[x].collide(ship)){//checks for invincibility first two seconds
						doneConstructing = false;
					}
				}
			}
			//if invincibility hack is active, doesnt test for collisions
			if(ship.invincible){
				for(int x = 0; x<Asteroids.b.length;x++){
					brush.setColor(Color.white);
					b[x].paint(brush);
					b[x].move();
				}
			}
			
			//makes animations smoother
			ship.move();
			//makes ship flicker
			if(counter<200&&counter%50>33&&counter%50<50){
				brush.setColor(Color.black);
				ship.paint(brush);
				brush.setColor(Color.white);
			}
			//does that same flicker thing
			else{
				ship.paint(brush);
			}


		}
		
		//if you hit a rock, heres what happens!
		if(!doneConstructing&&counter>0&&!flash){//does the epileptic seizure
			//inverts the colors on the screen every half a second to show the death
			if(flashCounter%50>25&&flashCounter%50<50){
				brush.setColor(Color.white);
				brush.fillRect(0, 0, width, height);
				brush.setColor(Color.black);
				brush.setColor(Color.white);
				brush.fillRect(0, 0, width, height);    			
				brush.setColor(Color.black);
				ship.paint(brush);
				for(int x = 0; x<this.b.length;x++){
					b[x].paint(brush);//keeps the asteroids there
				}
			}
			
			//still flashing
			else{
				brush.setColor(Color.black);
				brush.fillRect(0, 0, width, height);    			
				brush.setColor(Color.white);
				ship.paint(brush);
				for(int x = 0; x<this.b.length;x++){
					b[x].paint(brush);
				}
			}
			flashCounter++;
			if(flashCounter>200){
				flash=true;//flashes for a two seconds
			}

		}
		
		
		//hooray you survived the flashing!
		if(!doneConstructing&&counter>0&&flash){
			
			//this paints the screen you had when you died
			brush.setColor(Color.black);
			brush.fillRect(0, 0, width, height);    			
			brush.setColor(Color.white);
			ship.paint(brush);
			for(int x = 0; x<this.b.length;x++){
				b[x].paint(brush);
			}
			
			//prints that insane end effect and prints score
			brush.setColor(Color.white);
			gameOver.paint(brush);
			brush.setColor(Color.black);
			brush.fillRect(width/2-98,height/2-55,200, 75);//ensures score isn't obstructed by any background asteroids or ships
			brush.setColor(Color.cyan);
			
			//increases font size of score and retry/menu directions
			Font newFont = brush.getFont().deriveFont(brush.getFont().getSize() * 1.4F);
			brush.setFont(newFont);
			brush.drawString("Score is " + counter,width/2-40,height/2-35);
			brush.drawString("Hit 'r' to retry", width/2-41, height/2-15);
			brush.drawString("Hit 'm' to go to the main menu", width/2-98, height/2+3);
			//if you press restart it sets everything to the original state after menu was passed
			if(gameOver.playing){
				counter= 0;
				doneConstructing = true;
				ship.position = center;
				flash = false;
				flashCounter = 0;
				newFont = brush.getFont().deriveFont(brush.getFont().getSize() / 1.4F);
				brush.setFont(newFont);
				bulletOne.exists = false;
				plusOneThousand = false;
				timer = 0;
			}
			//brings back the menu as well
			if(gameOver.menu){
				asteroids = true;
				counter= 0;
				doneConstructing = false;
				ship.position = center;
				flash = false;
				flashCounter = 0;
				newFont = brush.getFont().deriveFont(brush.getFont().getSize() / 1.4F);
				brush.setFont(newFont);
				bulletOne.exists = false;
				plusOneThousand = false;
				timer = 0;
			}
		}
	}
	/**
	 * Creates a new Asteroids! game
	 * <p>Repaints the game over and over
	 * @author Alex Wang
	 * @param args
	 */
	public static void main (String[] args) {
		Asteroids a = new Asteroids();
		
		a.repaint();//paint gets called every ten seconds
	}
}
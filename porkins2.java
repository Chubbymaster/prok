
import java.awt.Point; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Porkins extends Application{
	Game g;
	final Image PIGRIGHT = new Image("file:pigRight.png", 0, 75, true, false);
	final Image PIGLEFT = new Image("file:pigLeft.png", 0, 75, true, false);
	final Image HORSELEFT1 = new Image("file:horseLeft1.png", 0, 100, true, false);
	final Image HORSELEFT2 = new Image("file:horseLeft2.png", 0, 100, true, false);
	final Image HORSERIGHT1 = new Image("file:horseRight1.png", 0, 100, true, false);
	final Image HORSERIGHT2 = new Image("file:horseRight2.png", 0, 100, true, false);
	final Image ROCK = new Image("file:Rock.png",0,150,true,false);
	boolean vulnerable = true;
	int invincible = 0;

	public void main(String[] args){
		launch(args);
	}


	
	public void start(Stage st) throws Exception {
		g = new Game("ahhhh");
		g.window = st;
		g.window.setScene(g.sc);
		g.window.show();
		Random randy = new Random();
		g.gc.setFill(Color.DARKRED);
		g.gc.fillRect(1720, 0, 1820, 1080);
		final long lastTime = System.nanoTime();		
		final PigSprite pigSprite = new PigSprite(PIGRIGHT, 0, 0, PIGRIGHT.getWidth(), PIGLEFT.getHeight(), 0, 5);
		final HorseSprite h1 = new HorseSprite(HORSERIGHT1, 0, 860, HORSERIGHT1.getWidth(), HORSERIGHT1.getHeight(), 5, 0);
		h1.setLeft(0);
		h1.setRight(1820);
		final HorseSprite h2 = new HorseSprite(HORSERIGHT1, 200, 880, HORSERIGHT1.getWidth(), HORSERIGHT1.getHeight(), 5, 0);
		h2.setLeft(100);
		h2.setRight(800);
		final RockSprite[] sprites = {new RockSprite(ROCK,(double)randy.nextInt(1720)+100,(double)randy.nextInt(780)+100,ROCK.getWidth(),ROCK.getHeight(),(double)5,(double)0),new RockSprite(ROCK,(double)randy.nextInt(1720)+100,(double)randy.nextInt(780)+100,ROCK.getWidth(),ROCK.getHeight(),(double)5,(double)0)};
		
		int counter = 0;
		new AnimationTimer(){
			@Override
			public void handle(long currentTime) {
				//g.gc.drawImage(pig.img, pig.getLocation().getX(), pig.getLocation().getY());
				//pig.fall();
				//long newTime = currentTime;
				//g.gc.setFill(Color.PALETURQUOISE);
				
				
				if(pigSprite.health<=0){
					g.gc.setFill(Color.PALETURQUOISE);
				}
				else{
					g.gc.setFill(Color.PALETURQUOISE);
				}
				if(vulnerable){
					if(pigSprite.hitBox.collide(h1.hitBox)){
						pigSprite.health-=100;
						//pigSprite.health = 0;
						vulnerable = false;
					}
					if(pigSprite.hitBox.collide(sprites[0].hitBox)||pigSprite.hitBox.collide(sprites[1].hitBox)){
						pigSprite.health-=90000;
						vulnerable = false;
						
					}
					
				}
				else{
					invincible++;
					if(invincible>50){
						invincible = 0;
						vulnerable = true;
					}
				}
				
				g.gc.fillRect(0,  0,  1920 , 1080);
				sprites[0].render(g.gc);
				sprites[1].render(g.gc);
				double elapsedTime = (currentTime - lastTime)/1000000000.0;
				//lastTime.setValue(currentTime);

				//pigSprite.yVel = 10;
				if(pigSprite.yVel>0){
					if(pigSprite.yVel>40){
					}
					else{
						pigSprite.yVel*=1.05;
					}
				}

				g.sc.setOnKeyPressed(new EventHandler<KeyEvent>(){

					@Override
					public void handle(KeyEvent e){
						switch(e.getCode()){ 
						case RIGHT:
							pigSprite.image = PIGRIGHT;
							//pigSprite.iv.setImage(pigSprite.img);
							pigSprite.xVel =10;
							break;
						case LEFT:
							pigSprite.image = PIGLEFT;
							//pigSprite.iv.setImage(g.pig.img);
							pigSprite.xVel = -10;
							//move();
							break;
						case UP:
							pigSprite.yVel = -15;
							break;
						
						case SPACE:
							pigSprite.health = 1920;
						} 
					}
				});
				g.sc.setOnKeyReleased(new EventHandler<KeyEvent>(){
					@Override
					public void handle(KeyEvent e){
						switch(e.getCode()){
						case RIGHT:
							pigSprite.image = PIGRIGHT;
							//g.pig.iv.setImage(g.pig.img);
							pigSprite.xVel = 0;
							break;
						case LEFT:
							pigSprite.image = g.pig.PIGLEFT;
							//g.pig.iv.setImage(g.pig.img);
							pigSprite.xVel = 0;
							break;
						case UP:
							pigSprite.yVel = 5;
							break;
						}
					}
				});

				pigSprite.move(pigSprite.xVel, pigSprite.yVel);
				pigSprite.render(g.gc);
				pigSprite.decrHealth();
				h1.move(h1.xVel);
				if(h1.xVel>0){
					//System.out.println(currentTime%1000000000L);
					/*
					if(currentTime%1000000000<=10000000){
						//System.out.println("time");
						h1.changeImg();
						if(h1.imgNum==1)
							h1.image = HORSERIGHT1;
						else
							h1.image = HORSERIGHT2;
					}else{
						if(h1.imgNum==1)
							h1.image = HORSERIGHT1;
						else
							h1.image = HORSERIGHT2;
					}*/
					h1.image = HORSERIGHT1;

				}
				else{
					/*
					if(currentTime%2200000000L==0){
						//System.out.println("time");
						h1.changeImg();
						if(h1.imgNum==1)
							h1.image = HORSELEFT1;
						else
							h1.image = HORSELEFT2;
					}else{
						if(h1.imgNum==1)
							h1.image = HORSELEFT1;
						else
							h1.image = HORSELEFT2;
					}*/
					h1.image = HORSELEFT1;
				}
				h1.render(g.gc);
				g.gc.setFill(Color.DARKRED);
				g.gc.fillRect(0, 980, pigSprite.health, 1080);
				g.gc.drawImage(pigSprite.image, pigSprite.getX(), pigSprite.getY());
			}
		}.start();
	}




}

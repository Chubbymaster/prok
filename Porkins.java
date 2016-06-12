package porkins.game;


import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import porkins.game.Game;
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
	final Image SHEEP1 = new Image("file:sheep.png", 0, 85, true, false);
	final Image SHEEP2 = new Image("file:sheep2.png", 0, 85, true, false);
	final Image BACON = new Image("file:bacon.png", 0, 75, true, false);
	final Image BACKGROUND = new Image("file:background.png", 1920, 0, true, false);
	

	public static void main(String[] args){
		launch(args);
	}


	@Override
	public void start(Stage st) throws Exception {
		g = new Game("ahhhh");
		g.window = st;
		g.window.setScene(g.sc);
		g.window.show();
		
		//g.gc.setFill(Color.DARKRED);
		//g.gc.fillRect(1720, 0, 1820, 1080);
		final long lastTime = System.nanoTime();
		
		final PigSprite pigSprite = new PigSprite(PIGRIGHT, 0, 0, PIGRIGHT.getWidth(), PIGLEFT.getHeight(), 0, 5);
		final HorseSprite h1 = new HorseSprite(HORSERIGHT1, 600, 600, HORSERIGHT1.getWidth(), HORSERIGHT1.getHeight(), 5, 0);
		h1.setLeft(300);
		h1.setRight(900);
		final HorseSprite h2 = new HorseSprite(HORSERIGHT1, 200, 880, HORSERIGHT1.getWidth(), HORSERIGHT1.getHeight(), 5, 0);
		h2.setLeft(100);
		h2.setRight(800);
		final SheepSprite s1 = new SheepSprite(SHEEP1, 300, 200, SHEEP1.getWidth(), SHEEP1.getHeight(), 3, 1);
		
		final Bacon b1 = new Bacon(BACON, 1000, 880);

		int counter = 0;
		new AnimationTimer(){
			@Override
			public void handle(long currentTime) {
				//g.gc.drawImage(pig.img, pig.getLocation().getX(), pig.getLocation().getY());
				//pig.fall();
				//long newTime = currentTime;
				
				g.gc.setFill(Color.BLACK);
				g.gc.fillRect(0,  0,  1920 , 1080);
				
				//g.gc.drawImage(BACKGROUND, BACKGROUND.getWidth(), BACKGROUND.getHeight());
				
				double elapsedTime = (currentTime - lastTime)/1000000000.0;
				//lastTime.setValue(currentTime);
				
				//pigSprite.yVel = 10;
				g.sc.setOnKeyPressed(new EventHandler<KeyEvent>(){
					
					@Override
					public void handle(KeyEvent e){
						switch(e.getCode()) { 
					        case RIGHT:
					        	pigSprite.image = PIGRIGHT;
					        	//pigSprite.iv.setImage(pigSprite.img);
					        	pigSprite.xVel = 5;
					            break;
					        case LEFT:
					        	pigSprite.image = PIGLEFT;
					        	//pigSprite.iv.setImage(g.pig.img);
					        	pigSprite.xVel = -5;
					        	//move();
					        	break;
					        case SPACE:
					        	pigSprite.yVel = -5;
					        	break;
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
							pigSprite.xVel = 5;
							break;
						case LEFT:
							pigSprite.image = g.pig.PIGLEFT;
							//g.pig.iv.setImage(g.pig.img);
							pigSprite.xVel = -5;
							break;
						case SPACE:
							pigSprite.yVel = 5;
							break;
						}
					}
				});
				
				pigSprite.move(pigSprite.xVel, pigSprite.yVel);
				pigSprite.render(g.gc);
				pigSprite.decrHealth();
				
				//horse1
				h1.move(h1.xVel);
				if(h1.xVel>0){
					//System.out.println(currentTime%1000000000L);
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
					}
						
				}
				if(h1.xVel<0){
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
					}
				}
				h1.render(g.gc);
				
				//horse2
				h2.move(h2.xVel);
				if(h2.xVel>0){
					//System.out.println(currentTime%1000000000L);
					if(currentTime%1000000000<=10000000){
						//System.out.println("time");
						h2.changeImg();
						if(h2.imgNum==1)
							h2.image = HORSERIGHT1;
						else
							h2.image = HORSERIGHT2;
					}else{
						if(h2.imgNum==1)
							h2.image = HORSERIGHT1;
						else
							h2.image = HORSERIGHT2;
					}
						
				}
				if(h2.xVel<0){
					if(currentTime%2200000000L==0){
						//System.out.println("time");
						h2.changeImg();
						if(h2.imgNum==1)
							h2.image = HORSELEFT1;
						else
							h2.image = HORSELEFT2;
					}else{
						if(h2.imgNum==1)
							h2.image = HORSELEFT1;
						else
							h2.image = HORSELEFT2;
					}
				}
				h2.render(g.gc);
				
				//sheep
				s1.move(s1.xVel, s1.yVel);
				if(s1.xVel>0)
					s1.image = SHEEP2;
				if(s1.xVel<0)
					s1.image = SHEEP1;
				s1.render(g.gc);
				
				//bacon
				b1.render(g.gc);
				
				//health bar
				g.gc.setFill(Color.DARKRED);
				g.gc.fillRect(0, 980, pigSprite.health, 1080);
				
			}
		}.start();
	}


	

}

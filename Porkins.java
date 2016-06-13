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
		
		final PigSprite p1 = new PigSprite(PIGRIGHT, 0, 0, PIGRIGHT.getWidth(), PIGLEFT.getHeight(), 0, 0);
		final HorseSprite h1 = new HorseSprite(HORSERIGHT1, 600, 600, HORSERIGHT1.getWidth(), HORSERIGHT1.getHeight(), 5, 0);
		h1.setLeft(300);
		h1.setRight(900);
		final HorseSprite h2 = new HorseSprite(HORSERIGHT1, 200, 880, HORSERIGHT1.getWidth(), HORSERIGHT1.getHeight(), 5, 0);
		h2.setLeft(100);
		h2.setRight(800);
		final SheepSprite s1 = new SheepSprite(SHEEP1, 1500, 200, SHEEP1.getWidth(), SHEEP1.getHeight(), 3, 2);
		s1.left = 1000;
		s1.right = 1600;
		
		final Bacon b1 = new Bacon(BACON, 1000, 880);
		
		final Wall w1 = new Wall(480, 0, 15, 300);
		
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
				
				//p1.yVel = 10;
				if(!p1.intersect){
				g.sc.setOnKeyPressed(new EventHandler<KeyEvent>(){
					
					@Override
					public void handle(KeyEvent e){
						switch(e.getCode()) { 
					        case RIGHT:
					        	p1.image = PIGRIGHT;
					        	//p1.iv.setImage(p1.img);
					        	p1.xVel = 5;
					            break;
					        case LEFT:
					        	p1.image = PIGLEFT;
					        	//p1.iv.setImage(g.pig.img);
					        	p1.xVel = -5;
					        	//move();
					        	break;
					        case SPACE:
					        	p1.yVel = -5;
					        	break;
						}

					}
				});
				g.sc.setOnKeyReleased(new EventHandler<KeyEvent>(){
					@Override
					public void handle(KeyEvent e){
						switch(e.getCode()){
						case RIGHT:
							p1.image = PIGRIGHT;
							//g.pig.iv.setImage(g.pig.img);
							p1.xVel = 5;
							break;
						case LEFT:
							p1.image = g.pig.PIGLEFT;
							//g.pig.iv.setImage(g.pig.img);
							p1.xVel = -5;
							break;
						case SPACE:
							p1.yVel = 5;
							break;
						}
					}
				});
				}
				p1.move(p1.xVel, p1.yVel);
				p1.render(g.gc);
				p1.decrHealth();
				
			//horse1
				h1.move(h1.xVel);
				//System.out.println(h1.counter);
				if(h1.xVel>0){
					if(h1.one){
						h1.changeImg(HORSERIGHT2);
					}else{
						h1.changeImg(HORSERIGHT1);
					}
					
					if(h1.counter<=0){
						if(h1.one){
							h1.changeImg(HORSERIGHT2);
						}else{
							h1.changeImg(HORSERIGHT1);
						}
						h1.one = !h1.one;
						h1.counter = 25;
					}
				}
				
				if(h1.xVel<0){
					if(h1.one){
						h1.changeImg(HORSELEFT2);
					}else{
						h1.changeImg(HORSELEFT1);
					}
					
					if(h1.counter<=0){
						if(h1.one){
							h1.changeImg(HORSELEFT2);
						}else{
							h1.changeImg(HORSELEFT1);
						}
						h1.one = !h1.one;
						h1.counter = 25;
					}
				}
				h1.render(g.gc);
				
				if(p1.intersects(h1))
					p1.health-=3;
				
			//horse2
				h2.move(h2.xVel);
				if(h2.xVel>0){
					if(h2.one){
						h2.changeImg(HORSERIGHT2);
					}else{
						h2.changeImg(HORSERIGHT1);
					}
					
					if(h2.counter<=0){
						if(h2.one){
							h2.changeImg(HORSERIGHT2);
						}else{
							h2.changeImg(HORSERIGHT1);
						}
						h2.one = !h2.one;
						h2.counter = 25;
					}						
				}
				if(h2.xVel<0){
					if(h2.one){
						h2.changeImg(HORSELEFT2);
					}else{
						h2.changeImg(HORSELEFT1);
					}
					
					if(h2.counter<=0){
						if(h2.one){
							h2.changeImg(HORSELEFT2);
						}else{
							h2.changeImg(HORSELEFT1);
						}
						h2.one = !h2.one;
						h2.counter = 25;
					}					}
				h2.render(g.gc);
				
				if(p1.intersects(h2))
					p1.health-=3;
				
			//sheep
				s1.move(s1.xVel, s1.yVel);
				if(s1.xVel>0)
					s1.image = SHEEP2;
				if(s1.xVel<0)
					s1.image = SHEEP1;
				s1.render(g.gc);
				if(p1.intersects(s1))
					p1.health-=3;
				
			//bacon
				
				if(b1.intersect(p1)){
					b1.x = 0;
					b1.y = 1005;
					p1.health += 10;
					if(p1.health>1820)
						p1.health = 1820;
				}
				b1.render(g.gc);
					
				
			//health bar
				g.gc.setFill(Color.DARKRED);
				g.gc.fillRect(0, 980, p1.health, 1080);
			//wall
				g.gc.setFill(Color.BURLYWOOD);
				w1.render(g.gc);
				//double origVel = 0;
				if(w1.intersect(p1)){
					p1.intersect = true;
					p1.origXVel = p1.xVel;
				}
				/*
				if(p1.y<=w1.y+w1.height && (p1.x>=w1.x && p1.x<w1.x + w1.width)){
					p1.intersect2 = true;
					p1.origYVel = p1.yVel;
				}
				*/
				if(p1.intersect2)
					p1.yVel = -p1.origYVel;
				if(p1.intersect){
					p1.xVel = -p1.origXVel;
					p1.counter--;
					/*
					if(p1.x<w1.x)
						p1.x = p1.x-40;
					else
						p1.x = p1.x+40;
					*/
				}
				if(p1.counter==0){
					//p1.xVel = p1.origVel;
					p1.counter = 15;
					p1.intersect = false;
				}
				
			}
		}.start();
	}


	

}

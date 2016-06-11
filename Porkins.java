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
	
	

	public static void main(String[] args){
		launch(args);
	}


	@Override
	public void start(Stage st) throws Exception {
		g = new Game("ahhhh");
		g.window = st;
		g.window.setScene(g.sc);
		g.window.show();
		//Point p = new Point(300, 300);
		//Pig pig = new Pig(p, true);
		//g.setFocusTraversable(true);
		//g.addKeyListener();
		//this.addKeyListener(g.pig);
		//GraphicsContext gc = new GraphicsContext();
		
		//LongValue lastTime = new LongValue(System.nanoTime());
		final long lastTime = System.nanoTime();
		
		final Sprite pigSprite = new Sprite(g.pig.img, g.pig.getLocation().getX(), g.pig.getLocation().getY(), g.pig.img.getWidth(), g.pig.img.getHeight(), 0, 0);
		new AnimationTimer(){
			@Override
			public void handle(long currentTime) {
				//g.gc.drawImage(pig.img, pig.getLocation().getX(), pig.getLocation().getY());
				//pig.fall();
				long newTime = currentTime;
				g.gc.setFill(Color.BLACK);
				g.gc.fillRect(0,  0,  1920 , 1080);
				
				double elapsedTime = (currentTime - lastTime)/1000000000.0;
				//lastTime.setValue(currentTime);
				
				
				g.sc.setOnKeyPressed(new EventHandler<KeyEvent>(){
					
					@Override
					public void handle(KeyEvent e){
						switch(e.getCode()) { 
					        case RIGHT:
					        	g.pig.img = g.pig.PIGRIGHT;
					        	g.pig.iv.setImage(g.pig.img);
					        	g.pig.xVel = 10;
					            break;
					        case LEFT:
					        	g.pig.img = g.pig.PIGLEFT;
					        	g.pig.iv.setImage(g.pig.img);
					        	g.pig.xVel = -10;
					        	//move();
					        	break;
					        case SPACE:
					        	g.pig.yVel = -5;
					        	break;
						}

					}
				});
				g.sc.setOnKeyReleased(new EventHandler<KeyEvent>(){
					@Override
					public void handle(KeyEvent e){
						switch(e.getCode()){
						case RIGHT:
							g.pig.img = g.pig.PIGRIGHT;
							g.pig.iv.setImage(g.pig.img);
							g.pig.xVel = 0;
							break;
						case LEFT:
							g.pig.img = g.pig.PIGLEFT;
							g.pig.iv.setImage(g.pig.img);
							g.pig.xVel = 0;
							break;
						case SPACE:
							g.pig.yVel = 5;
							break;
						}
					}
				});
				
				pigSprite.move(g.pig.xVel, g.pig.yVel);
				pigSprite.render(g.gc);
			}
		}.start();
	}


	

}

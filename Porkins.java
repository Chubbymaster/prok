package porkins.game;


import java.awt.Color;
import java.awt.Graphics;
import porkins.game.Game;

import javafx.application.Application;
import javafx.stage.Stage;
public class Porkins extends Application{
	Game g;
	

	public static void main(String[] args){
		launch(args);
	}


	@Override
	public void start(Stage arg0) throws Exception {
		g = new Game("ahhhh");
		g.window.show();
		Pig p = new Pig();
		
		new AnimationTimer(){
			@Override
			public void handle(long arg0) {
				g.gc.drawImage(pig.pigLeft, pig.getLocation().getX(), pig.getLocation().getY());
			}
		}.start();
		
	}

} 

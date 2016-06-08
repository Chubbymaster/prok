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
		
	}

}

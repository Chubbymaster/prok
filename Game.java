package porkins.game;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game extends Canvas{
	final int WIDTH = 1920;
	final int HEIGHT = 1080;
	//Image buffer;
	boolean on = true;
	String name = "";
	Stage window;
	Canvas c;
	GraphicsContext gc;
	
	public Game(String s){
		window = new Stage();
		name = s;
		
		Group group = new Group();
		
		c = new Canvas(WIDTH, HEIGHT);
		gc = c.getGraphicsContext2D();
		
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, WIDTH, HEIGHT);
		
		group.getChildren().add(c);
		Scene sc = new Scene(group, WIDTH, HEIGHT, Color.DARKRED);
		window.setScene(sc);
		window.setTitle(name);
		
		
	}
	
}

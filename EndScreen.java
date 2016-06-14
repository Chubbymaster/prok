package porkins.game;

import javafx.scene.Group;

import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EndScreen extends Canvas{
	final int WIDTH = 1920;
	final int HEIGHT = 1080;
	final static Image BACK_IMAGE = new Image("/images/piggy 2.png");
	//Image buffer;
	boolean on = true;
	String name = "";
	Stage window;
	Canvas c;
	GraphicsContext gc;
	
	
	public EndScreen(String s){
		final ImageView background = new ImageView(BACK_IMAGE);
		window = new Stage();
		name = s;
		
		Group group = new Group(background);
		
		c = new Canvas(WIDTH, HEIGHT);
		gc = c.getGraphicsContext2D();
		
		background.setFitWidth(604);
		background.setFitHeight(528);
		background.setLayoutX(1920/2-300);
		background.setLayoutY(540);
		
		gc.setFill(Color.DARKSALMON);
		gc.setFont(Font.font("Comic Sans MS", 100));
		gc.fillText("GAME OVER", WIDTH/2-300, HEIGHT/2-100);
		
		
		group.getChildren().add(c);
		Scene sc = new Scene(group, WIDTH, HEIGHT, Color.DARKRED);
		window.setScene(sc);
		window.setTitle(name);
		
		
	}
	
}

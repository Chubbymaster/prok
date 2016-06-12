package porkins.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bacon {
	Image img;
	int x, y;
	
	public Bacon(Image image, int xPos, int yPos){
		img = image;
		x = xPos;
		y = yPos;
	}
	
	public void render(GraphicsContext gc){
		gc.drawImage(img, x, y);
	}
}

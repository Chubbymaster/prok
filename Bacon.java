package porkins.game;

import java.awt.Point;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bacon {
	Image img;
	int x, y;
	//Polygon hitbox;
	Rectangle2D hitbox;
	boolean touched;
	
	public Bacon(Image image, int xPos, int yPos){
		img = image;
		x = xPos;
		y = yPos;
		//Point[] points = {new Point(x, y), new Point(x+ (int)image.getWidth(), y), new Point(x, y+ (int)image.getHeight()), new Point(x+(int)image.getWidth(), y+(int)image.getHeight())};
		//Point p = new Point(x, y);
		//hitbox = new Polygon(points, p, 0);
		hitbox = new Rectangle2D(x, y, img.getWidth(), img.getHeight());
		touched = false;
	}
	
	public void render(GraphicsContext gc){
		gc.drawImage(img, x, y);
	}
	
	public boolean intersect(Sprite s){
		return this.hitbox.intersects(s.hitbox);
	}
}

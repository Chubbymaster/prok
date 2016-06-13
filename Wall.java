package porkins.game;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;


public class Wall {
	int x, y, width, height;
	
	
	public Wall(int topLeftX, int topLeftY, int w, int h){
		x = topLeftX;
		y = topLeftY;
		width = w;
		height = h;
	}
	
	public void render(GraphicsContext gc){
		gc.fillRect(x, y, width, height);
	}
	
	public boolean intersect(Sprite s){
		Rectangle2D bounds = new Rectangle2D(x, y, width, height);
		return bounds.intersects(s.getBoundary());
	}
	
	public void bounce(PigSprite p){
		//p.intersect = true;
		p.counter--;
		p.xVel = -p.origXVel;
		if(p.counter==0){
			p.counter = 15;
			p.intersect = false;
		}
	}
}

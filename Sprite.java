package porkins.game;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {
	
	public Image image;
	protected double x;
	protected double y;
	protected double width;
	protected double height;
	protected double xVel;
	protected double yVel;
	
	public Sprite(Image img, double xPos, double yPos, double w, double h, double xVelocity, double yVelocity){
		image = img;
		x = xPos;
		y = yPos;
		width = w;
		height = h;
		xVel = xVelocity;
		yVel = yVelocity;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public double getWidth(){
		return width;
	}
	
	public double getHeight(){
		return height;
	}
	
	public double getXVel(){
		return xVel;
	}
	
	public double getYVel(){
		return yVel;
	}
	
	public void setXVel(double d){
		xVel = d;
	}
	
	public void setYVel(double d){
		yVel = d;
	}
	
	public void setWAndH(double w, double h){
		width = w;
		height = h;
	}
	//use move instead of update
	/*
	public void update(double time){
		x += xVel*time;
		y += yVel*time;
	}
	*/
	public void move(double xDist, double yDist){
		x += xDist;
		y += yDist;
	}
	
	public void render(GraphicsContext gc){
		gc.drawImage(image, x, y);
		
	}
	
	public Rectangle2D getBoundary(){
		return new Rectangle2D(x, y, width, height);
	}
	
	public boolean intersects(Sprite s){
		return s.getBoundary().intersects(this.getBoundary());
	}
	
}

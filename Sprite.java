import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {
	
	private Image image;
	private double x;
	private double y;
	private double width;
	private double height;
	private double xVel;
	private double yVel;
	
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
	public void update(double time){
		x += xVel*time;
		y += yVel*time;
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

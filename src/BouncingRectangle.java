import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class BouncingRectangle extends BouncingFigure {

	private int height;
	private int width;
	

	BouncingRectangle(int xLeft, int yTop, int height, int width, double trajectory, int speed) {
		setXLeft(xLeft);
		setYTop(yTop);
		setTrajectory(trajectory);
		setSpeed(speed);
		this.height=height;
		this.width=width;
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		Rectangle rectangle = new Rectangle(getXLeft(),getYTop(), this.height, this.width);
		g2.setColor(Color.RED);
		g2.fill(rectangle);
		g2.draw(rectangle);
	}

	//Methods to test of object hit each of four possible borders
	public boolean rightBorderCollision(int screenLimit){
		if(getXLeft()+this.width > screenLimit){	
			this.setXLeft(screenLimit-this.width);
			this.setTrajectory(getTrajectory()-180);
			
			return true;
			}
		return false;
	}
	
	public boolean leftBorderCollision(){
		if(getXLeft() < 0)
			System.out.println("not allowed");
			this.setXLeft(0);
			this.setTrajectory(getTrajectory()+180);
			
			return true;
		
	}

	public boolean upperBorderCollision(){
		if(getYTop() < 0)
			setYTop(0);
			setTrajectory(getTrajectory()+90);
			return true;
	}

	public boolean lowerBorderCollision(int screenLimit){
		if(getYTop()+this.height > screenLimit)
			setYTop(screenLimit-this.height);
			setTrajectory(getTrajectory()-90);
			return true;
		
	}
}

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;

public class BouncingBox extends JComponent {

	private ArrayList<BouncingFigure> figures = new ArrayList<BouncingFigure>();

	public void add(BouncingFigure f) {
		figures.add(f);
	}

	public void paintComponent(Graphics g) {
		for (BouncingFigure f : figures) {
			f.draw(g); f.move();
			// Add code here for Lab Q5
			//
			if(f.leftBorderCollision()){
				f.setTrajectory(f.getTrajectory()+90);
				f.draw(g); f.move();
			}
			if(f.rightBorderCollision(this.getWidth())){
				f.setTrajectory(f.getTrajectory()+90);
				f.draw(g); f.move();
			}
			if(f.upperBorderCollision()){
				f.setTrajectory(f.getTrajectory()+90);
				f.draw(g); f.move();


			}
			if(f.lowerBorderCollision(this.getHeight())){
				f.setTrajectory(f.getTrajectory()+90);
				f.draw(g); f.move();
			}
		}
	}
}

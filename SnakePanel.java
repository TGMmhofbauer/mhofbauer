package Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Iterator;
import javax.swing.JPanel;

public class SnakePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private SnakeModel m;
	private Food food;
	
	public SnakePanel(SnakeModel m){
		this.m = m;
		this.food = new Food(this);
		
		this.setFocusable(true);
		this.requestFocusInWindow();
	}
	
	public void paintComponent(Graphics g){
		int breite = this.getWidth();
		int hoehe = this.getHeight();
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(new Color(105,105,105));
	    int y=0;
	    while(y<=hoehe){
	    	g.drawLine(0, y, breite, y);     // Vertikale linien
	    	y=y+10;
	    }
	       
	    int x=0;
	    while(x<=breite){
	    	g.drawLine(x, 0, x, hoehe);    // Horizontale linien
	    	x=x+10;
	    }
		
	    g.setColor(Color.white);
		g.drawString(this.m.printScore(), 25, 25);
		g.drawString(this.m.printPause(), 500, 25);
		
		Iterator<Point> i = m.schlange.iterator();
		 while(i.hasNext()){
			 g.setColor(Color.GREEN);
			 Point p = i.next();
			 g.fillRect(p.x, p.y, 10, 10);
		 }
		 
		Point Kopf = m.schlange.getLast();
		g.setColor(Color.BLUE);
		g.fillRect(Kopf.x, Kopf.y, 10, 10);
		
		food.drawFood(g);
	
		if(food.eat(Kopf)){
			food.moveFood();
			this.m.growSnake(1);
		}
		
	}
}

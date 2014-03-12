package Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

public class Food{
	
	private Point food;
	public Food(SnakePanel p){
		food = new Point(10,10);
		new Random();
	}
	
	public void moveFood(){
		food.x = 1+(int)(Math.random() * ((70 - 1)));
		food.y = 1+(int)(Math.random() * ((70 - 1)));
		
	}
	
	public void drawFood(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(food.x*10, food.y*10, 10, 10);
	}
	
	public Point getFood(){
		return food;
	}
	
	public boolean eat(Point x){
		if(new Rectangle((int)x.getX(), (int)x.getY(),10,10).intersects(new Rectangle((int)food.getX()*10,(int)food.getY()*10,10,10)))
			return true;
		return false;
	}
}

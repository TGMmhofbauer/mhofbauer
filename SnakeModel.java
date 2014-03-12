package Snake;

import java.awt.*;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JOptionPane;

public class SnakeModel {
	public LinkedList<Point> schlange = new LinkedList<Point>();
	private int schrittweite = 10;//Schrittweite, die die Schlange nach einem Zug zurücklegen soll
	private int laenge = 2;
	private int score;
	public Timer t;
	private String schwierig;
	
	public SnakeModel(){
		init();
		
	}
	
	public void rauf(){
		Point e = new Point(schlange.getLast().x, schlange.getLast().y - schrittweite);//neuer Punkt der die Schlange nach oben bewegt
		//System.out.println("rauf " + schlange.get(0).y +  schlange.get(0).x);
		if(schlange.size() <= laenge){
			schlange.add(e);
		}
		else{
			schlange.add(e);
			schlange.removeFirst();
		}
		
	}
	
	public void runter(){
		Point e = new Point(schlange.getLast().x, schlange.getLast().y + schrittweite);//neuer Punkt der die Schlange nach unten bewegt
		if(schlange.size() <= laenge){
			schlange.add(e);
		}
		else{
			schlange.add(e);
			schlange.removeFirst();
		}
	}
	
	public void rechts(){
		Point e = new Point(schlange.getLast().x + schrittweite, schlange.getLast().y);//neuer Punkt der die Schlange nach rechts bewegt
		if(schlange.size() <= laenge){
			schlange.add(e);
		}
		else{
			schlange.add(e);
			schlange.removeFirst();
		}
	}
	
	public void links(){
		Point e = new Point();
		if(schlange.getLast().getX()-schrittweite != schlange.get(schlange.size()-1).getX())
		{
		e = new Point(schlange.getLast().x - schrittweite, schlange.getLast().y);//neuer Punkt der die Schlange nach links bewegt
		if(schlange.size() <= laenge){
			schlange.add(e);
		}
		else{
			schlange.add(e);
			schlange.removeFirst();
		}
		}
	}
	
	public void growSnake(int n){
		this.schlange.addFirst(schlange.getFirst());
		this.schlange.addFirst(schlange.getFirst());
		switch(schwierig){
		case "einfach":
			score += 50;
			break;
		case "mittel":
			score += 100;
			break;
		case "schwer":
			score += 150;
			break;
		case "hardcore":
			score += 1000;
			break;
		}
	}
	
	public Point getPoint(){
		return schlange.get(0);
	}
	
	public List<Point> getSchlange(){
		return this.schlange;
	}
	public void snakeCollision(){
		for(int x = schlange.size()-3; x>=0; x--){
			if(schlange.getLast().getX() == schlange.get(x).getX() && schlange.getLast().getY() == schlange.get(x).getY()){
				gameOver();
			}
		}
	}
	
	public void init(){
		Point e = new Point(50,50);//Anfangsposition der Schlange
		
		schlange.add(e);
		schlange.add(new Point(50,40));
		schlange.add(new Point(50,30));
		t = new Timer();
	}
	
	public String printScore(){
		String temp = "Score: " + score;
		return temp;
	}
	
	public String printPause(){
		String temp = "Um das Spiel zu pausieren,\n Escape zu drücken!";
		return temp;
	}
	
	public void startMove(TimerTask task){
		String schwierigkeitsgrad = JOptionPane.showInputDialog(null, "Schwierigkeitsgrad wählen:\n 1 - leicht,\n 2 - mittel,\n 3 - schwer");
		switch(schwierigkeitsgrad){
		case "1": 
			this.t.schedule(task, 150, 150);
			this.schwierig = "einfach";
			break;
		case "2": 
			this.t.schedule(task, 80, 80);
			this.schwierig = "mittel";
			break;
		case "3":
			this.t.schedule(task, 50, 50);
			this.schwierig = "schwer";
			break;
		case "4":
			this.t.schedule(task, 15, 15);
			this.schwierig = "hardcore";
			break;
		}
	}
	
	public void gameOver(){
		JOptionPane.showMessageDialog(null, "Game Over! ");
		HighscoreManager hm = new HighscoreManager();
        hm.addScore(JOptionPane.showInputDialog(null, "Geben Sie Ihren Namen ein: "), score);
		JOptionPane.showMessageDialog(null, hm.getHighscoreString());
		System.exit(0);
	}
	
	public void isLose()
	{
		if(schlange.getLast().getX() >= 790 || schlange.getLast().getY() >= 790 || schlange.getLast().getX() <= -10 || schlange.getLast().getY() <= -10)
		{
			gameOver();
		}
			
	}
	
}

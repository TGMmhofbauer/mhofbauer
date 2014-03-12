package Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class SnakeController implements KeyListener{
	
	private SnakeModel m;
	private SnakeView v;
	private Task t;
	
	public SnakeController(){
		this.m = new SnakeModel();
		this.v = new SnakeView(m, this);
		this.t = new Task(m,v);
		this.m.startMove(t);
	}
	
	public SnakeController(SnakeModel m, SnakeView v){
		this.m = new SnakeModel();
		this.v = new SnakeView(m, this);
		this.t = new Task(m,v);
		this.m.startMove(t);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP){
			this.t.richtung = 1;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			this.t.richtung = 2;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			this.t.richtung = 3;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			this.t.richtung = 4;
		}
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			this.t.richtung = 0;
			JOptionPane.showMessageDialog(null, "Spiel pausiert");
		}
		this.v.refresh();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
}

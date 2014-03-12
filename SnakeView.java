package Snake;

import javax.swing.*;
import java.awt.*;

public class SnakeView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private SnakeModel m;
	private SnakeController c;
	private SnakePanel p;
	private JPanel anzeige;
	
	public SnakeView(SnakeModel m, SnakeController c){
		this.m = m;
		this.c = c;
		this.p = new SnakePanel(this.m);
		
		this.anzeige = new JPanel(new GridLayout(1,1));//BorderLayout wird verwendet
		this.p.addKeyListener(this.c);
		
		anzeige.add(this.p);
		this.add(this.anzeige);
		
		this.setSize(new Dimension(800, 800));
		this.setVisible(true);
		this.setTitle("Snake");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(1,1);
		this.setResizable(false);
		//setSize, setVisible, setTitle, setDefaultCloseOperation
	}

	public void refresh(){
		this.repaint();//Schlange wird mit neuen Koordinaten gezeichnet
	}
}

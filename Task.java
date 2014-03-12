package Snake;

import java.util.TimerTask;

public class Task extends TimerTask{
	
	SnakeModel m;
	SnakeView v;
	int richtung = 0;
	int r2 = 0;
	
	public Task(SnakeModel m, SnakeView v){
		this.m=m;
		this.v=v;
	}
	
	public void run(){
		switch(richtung){
		
			case 1:
				if(r2 != 2)
				{
				this.m.rauf();
				}
				else
					richtung = 2;
			break;
			
			case 2:
				if(r2 != 1){
				this.m.runter();
				}
				else
					richtung = 1;
			break;
			
			case 3: 
				if(r2 != 4){
					this.m.rechts();
				}
				else
					richtung = 4;
			break;
			
			case 4:
				if(r2 != 3){
				this.m.links();
				}
				else
					richtung = 3;
			break;
		}
		this.v.refresh();
		this.m.isLose();
		this.m.snakeCollision();
		r2 = richtung;
	}
	
}

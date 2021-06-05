package model;

import processing.core.PApplet;

public class Polo extends Automaton implements Runnable{

	//private boolean stopMoving;
	
	
	public Polo(int posX, int posY, int speedX, int speedY, String message, PApplet app) {
		super(posX, posY, speedX, speedY, message, app);
		//stopMoving = false;
	}

	public void drawPolo() {
		
		
		app.noStroke();
		app.fill(144, 70, 207);
		super.drawAutomaton();
		

	}
	
	
	public void movePolo() {
		
		//if (stopMoving = false) {
			if (posX > app.width) {
				posX = app.width;
				speedX = -speedX;

			}
			if (posY > app.height) {
				posY = app.height;
				speedY = -speedY;

			}
			if (posX < 0) {
				posX = 0;
				speedX = -speedX;

			}
			if (posY < 0) {
				posY = 0;
				speedY = -speedY;

			}
			
			super.moveAutomaton();
			//+System.out.println("move");
		//}
		
		
	}
	

	
	public void sayMessage() {
		app.text(message+": "+posX+","+posY, posX - sizeBall/2, posY+sizeBall);
	}
	
	@Override
	public void run() {
		movePolo();
		
		try {
			
			Thread.sleep(10);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/*public boolean isStopMoving() {
		return stopMoving;
	}

	public void setStopMoving(boolean stopMoving) {
		this.stopMoving = stopMoving;
	}*/




}

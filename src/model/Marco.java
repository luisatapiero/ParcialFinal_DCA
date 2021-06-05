package model;

import processing.core.PApplet;

public class Marco extends Automaton implements Runnable{

	public Marco(int posX, int posY, int speedX, int speedY, String message, PApplet app) {
		super(posX, posY, speedX, speedY, message, app);

	}

	public void drawMarco() {
		
		
		app.stroke(255, 107, 53);
		app.strokeWeight(5);
		app.noFill();
		super.drawAutomaton();
		
		
		
	}
	
	private void moveMarco() {
		
		
	}
	
	public int calculateDistance(int posXPolo, int posYPolo) {
		int distance = (int) PApplet.dist(posX, posY, posXPolo, posYPolo);
		
		//System.out.println(PApplet.dist(posX, posY, posXPolo, posYPolo));
		return distance;
		
	}
	
	public void sayMessage() {
		
		app.text(message, posX - sizeBall/2, posY+sizeBall);
	}

	@Override
	public void run() {
		moveMarco();
		
	}

	

}

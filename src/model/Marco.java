package model;

import processing.core.PApplet;

public class Marco extends Automaton {

	public Marco(int posX, int posY, int speedX, int speedY, String message, PApplet app) {
		super(posX, posY, speedX, speedY, message, app);

	}

	public void drawMarco() {
		
		
		app.stroke(255, 107, 53);
		app.strokeWeight(5);
		app.noFill();
		super.drawAutomaton("Marco");
		
		
		
	}
	
	public void moveMarco() {
		super.moveAutomaton();
	}

}

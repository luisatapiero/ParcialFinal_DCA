package model;

import processing.core.PApplet;

public class Marco extends Automaton {

	public Marco(int posX, int posY, int speed, int direction, String message, PApplet app) {
		super(posX, posY, speed, direction, message, app);

	}

	public void drawAutomaton() {
		super.drawAutomaton("Marco");
		
		app.stroke(255, 107, 53);
		app.strokeWeight(7);
		app.noFill();
		System.out.println("pinto");
		
		
	}

}

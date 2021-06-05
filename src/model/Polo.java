package model;

import processing.core.PApplet;

public class Polo extends Automaton{

	public Polo(int posX, int posY, int speed, int direction, String message, PApplet app) {
		super(posX, posY, speed, direction, message, app);
		message = "Polo";
	}

	public void drawAutomaton() {
		super.drawAutomaton("Polo");
		System.out.println("pinto");
		app.noStroke();
		app.fill(144, 70, 207);
		
		

	}
}

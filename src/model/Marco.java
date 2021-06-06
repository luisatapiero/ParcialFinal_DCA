package model;

import processing.core.PApplet;

public class Marco extends Automaton implements Runnable {

	private boolean stopMoving;

	public Marco(int posX, int posY, int speedX, int speedY, String message, PApplet app) {
		super(posX, posY, speedX, speedY, message, app);

		stopMoving = false;
	}

	public void drawMarco() {

		app.stroke(255, 107, 53);
		app.strokeWeight(5);
		app.noFill();
		super.drawAutomaton();

	}

	public void moveMarco() {

		if (stopMoving == true) {
			if (posX < app.width && posX > -2 && posY < app.height && posY > -2) {
				super.moveAutomaton();
			} else {
				posX = app.width / 2;
				posY = app.height / 2;
			}

		}

		stopMoving = false;

	}

	public int calculateDistance(int posXPolo, int posYPolo) {

		int distance = (int) PApplet.dist(posX, posY, posXPolo, posYPolo);

		return distance;

	}

	public void sayMessage() {

		app.text(message, posX - sizeBall / 2, posY + sizeBall);
		stopMoving = true;
	}

	@Override
	public void run() {

		moveMarco();

		try {

			Thread.sleep(10);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

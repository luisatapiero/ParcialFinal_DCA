package model;

import processing.core.PApplet;

public class Automaton {

	protected PApplet app;
	protected int posX, posY, speedX, speedY;
	protected String message;
	protected final int sizeBall;

	public Automaton(int posX, int posY, int speedX, int speedY, String message, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.speedX = speedX;
		this.speedY = speedY;
		this.message = message;
		this.app = app;

		sizeBall = 30;
	}

	public void drawAutomaton() {

		app.circle(posX, posY, sizeBall);
		app.fill(251, 254, 249);
		

		// app.text(message+": "+posX+","+posY, posX, posY+sizeBall);
	}

	public void moveAutomaton() {
		posX += speedX;
		posY += speedY;

		if (posX > 1000) {
			posX = 1000;
			speedX = -speedX;

		}
		if (posY > 700) {
			posY = 700;
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

	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speed) {
		this.speedX = speed;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speed) {
		this.speedY = speed;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getSizeBall() {
		return sizeBall;
	}

}

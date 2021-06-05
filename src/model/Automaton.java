package model;

import processing.core.PApplet;

public class Automaton {
	
	protected PApplet app;
	protected int posX, posY, speed, direction;
	protected String message;
	protected final int sizeBall;

	public Automaton(int posX, int posY, int speed, int direction, String message, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.speed = speed;
		this.direction = direction;
		this.app = app;
		
		sizeBall = 30;
	}
	
	public void drawAutomaton(String message) {
		app.text(message+": "+posX+","+posY, posX - sizeBall/2, posY+sizeBall);
		app.circle(posX, posY, sizeBall);
		
		//app.text(message+": "+posX+","+posY, posX, posY+sizeBall);
	}
	
	public void moveAutomaton() {
		
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
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

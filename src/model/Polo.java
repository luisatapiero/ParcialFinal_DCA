package model;

import processing.core.PApplet;

public class Polo extends Automaton implements Runnable{

	public Polo(int posX, int posY, int speedX, int speedY, String message, PApplet app) {
		super(posX, posY, speedX, speedY, message, app);
	}

	public void drawPolo() {
		
		
		app.noStroke();
		app.fill(144, 70, 207);
		super.drawAutomaton();
		

	}
	
	
	private void movePolo() {
		super.moveAutomaton();
		//+System.out.println("move");
	}
	
	@Override
	public void run() {
		moveAutomaton();
		
		try {
			
			Thread.sleep(10);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void sayMessage() {
		app.text(message+": "+posX+","+posY, posX - sizeBall/2, posY+sizeBall);
	}




}

package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class World {

	PApplet app;
	private Marco marco;
	private ArrayList<Polo> poloList;
	private int startTime, currentTime;
	private boolean stopMoving;

	public World(PApplet app) {

		this.app = app;
		poloList = new ArrayList<Polo>();
		startTime = app.millis();
		currentTime = 0;
		stopMoving = false;

		createAutomatons();

	}

	private void createAutomatons() {

		int speed = 2;

		for (int i = 0; i < 20; i++) {

			poloList.add(new Polo((int) app.random(30, 970), (int) app.random(30, 970), speed, -speed, "Polo", app));

		}

		marco = new Marco(340, 340, speed * 2, -speed * 2, "Marco", app);

	}

	public void drawAutomatons() {
		stopMoving = false;
		currentTime = app.millis() - startTime;
		app.text("Tiempo: " + currentTime / 1000, 60, 60);

		marco.drawMarco();
		if (stopMoving == false) {
			new Thread(marco).start();
		}
		

		for (int i = 0; i < poloList.size(); i++) {
			poloList.get(i).drawPolo();
			if (stopMoving == false) {
				new Thread(poloList.get(i)).start();
			}
			
		}
		
		sayMessage();
		
		

	}

	private void sayMessage() {
		if (currentTime / 1000 % 2 == 0 && currentTime / 1000 != 0) {
			//stopMoving = true;
			marco.sayMessage();
			for (int i = 0; i < poloList.size(); i++) {
				poloList.get(i).sayMessage();
			}
			
			
		}
		
		//
	}

}

package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class World {

	PApplet app;
	private Marco marco;
	private ArrayList<Polo> poloList;
	private int startTime, currentTime, selectedPoloX, selectedPoloY;
	private boolean stopMoving;

	public World(PApplet app) {

		this.app = app;
		poloList = new ArrayList<Polo>();
		startTime = app.millis();
		currentTime = 0;
		stopMoving = false;
		selectedPoloX = 0;
		selectedPoloY = 0;

		createAutomatons();

	}

	private void createAutomatons() {

		int speed = 2;

		for (int i = 0; i < 20; i++) {

			poloList.add(new Polo((int) app.random(30, 970), (int) app.random(30, 970), speed, -speed, "Polo", app));

		}

		marco = new Marco(480, 340, speed * 2, -speed * 2, "Marco", app);

	}

	public void draw() {
		stopMoving = false;
		currentTime = app.millis() - startTime;
		app.text("Tiempo: " + currentTime / 1000, 60, 60);

		drawAutomatons();
	}

	private void drawAutomatons() {

		marco.drawMarco();
		sayMessagePolo();
		if (stopMoving == true) {
			new Thread(marco).start();
		}

		for (int i = 0; i < poloList.size(); i++) {
			poloList.get(i).drawPolo();
			if (stopMoving == false) {
				new Thread(poloList.get(i)).start();
			}

		}

	}

	private boolean sayMessageMarco() {

		if (currentTime / 1000 % 2 == 0 && currentTime / 1000 != 0) {
			stopMoving = true;
			marco.sayMessage();
			calculateDistance();

			return true;
		}
		return false;

	}

	private void calculateDistance() {
		
		selectedPoloX = poloList.get(0).getPosX();
		selectedPoloY = poloList.get(0).getPosY();
		
		int distanceSelected = (int) PApplet.dist(marco.getPosX(), marco.getPosY(), selectedPoloX, selectedPoloY);

		for (int i = 1; i < poloList.size(); i++) {
			marco.calculateDistance(poloList.get(i).getPosX(), poloList.get(0).posY);

			if (marco.calculateDistance(poloList.get(i).getPosX(), poloList.get(i).posY) < distanceSelected) {
				selectedPoloX = poloList.get(i).getPosX();
				selectedPoloY = poloList.get(i).getPosY();
			}
		}
		
		System.out.println(selectedPoloX + " " + selectedPoloY);

	}

	private void sayMessagePolo() {

		if (sayMessageMarco()) {

			for (int i = 1; i < poloList.size(); i++) {

				poloList.get(i).sayMessage();

				if (selectedPoloX > poloList.get(i).getPosX() && selectedPoloY < poloList.get(i).getPosY()) {

					selectedPoloX = poloList.get(i).getPosX();
					selectedPoloY = poloList.get(i).getPosY();

				}
			}

			System.out.println(selectedPoloX + " " + selectedPoloY);
		}

	}

}

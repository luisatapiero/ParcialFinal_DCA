package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class World {

	PApplet app;
	private Marco marco;
	private ArrayList<Polo> poloList;
	private int startTime, currentTime, selectedPoloX, selectedPoloY;
	private boolean stopMoving;
	private int speed, numSelected;

	public World(PApplet app) {

		this.app = app;
		poloList = new ArrayList<Polo>();
		startTime = app.millis();
		currentTime = 0;
		stopMoving = false;
		selectedPoloX = 0;
		selectedPoloY = 0;
		speed = 2;
		numSelected = 0;

		createAutomatons();

	}

	private void createAutomatons() {

		for (int i = 0; i < 20; i++) {

			poloList.add(new Polo((int) app.random(30, 970), (int) app.random(30, 970), speed, -speed, "Polo", app));

		}

		marco = new Marco(app.width / 2, app.height / 2, speed * 2, speed * 2, "Marco", app);

	}

	public void draw() {

		currentTime = app.millis() - startTime;
		app.text("Tiempo: " + currentTime / 1000, 60, 60);

		drawAutomatons();
	}

	private void drawAutomatons() {
		drawMarco();
		drawPolo();
		playAgain();
	}

	private void drawMarco() {
		marco.drawMarco();
		sayMessageMarco();
	}

	private void drawPolo() {
		for (int i = 0; i < poloList.size(); i++) {
			poloList.get(i).drawPolo();
			if (stopMoving == false) {
				new Thread(poloList.get(i)).start();
			}
		}
		sayMessagePolo();
	}

	private boolean sayMessageMarco() {

		if (currentTime / 1000 % 2 == 0 && currentTime / 1000 != 0) {
			marco.sayMessage();
			stopMoving = true;

			return true;
		}
		return false;

	}

	private void sayMessagePolo() {

		if (sayMessageMarco()) {

			for (int i = 0; i < poloList.size(); i++) {

				poloList.get(i).sayMessage();
				// poloList.get(i).setStopMoving(true);

			}
			calculateDistance();
		}

	}

	private void calculateDistance() {

		selectedPoloX = poloList.get(0).getPosX();
		selectedPoloY = poloList.get(0).getPosY();
		// System.out.println("PRIMERO "+selectedPoloX + " " + selectedPoloY);

		for (int i = 1; i < poloList.size(); i++) {
			int distanceSelected = (int) app.dist(marco.getPosX(), marco.getPosY(), selectedPoloX, selectedPoloY);
			if ((marco.calculateDistance(poloList.get(i).getPosX(), poloList.get(i).posY)) < distanceSelected) {

				numSelected = i;
				selectedPoloX = poloList.get(numSelected).getPosX();
				selectedPoloY = poloList.get(numSelected).getPosY();

				// marco.calculateDistance(poloList.get(i).getPosX(), poloList.get(i).posY);

			}
		}

		System.out.println(selectedPoloX + " " + selectedPoloY);
		System.out.println(numSelected);
		chasePolo();
	}

	private void chasePolo() {

		if (marco.getPosX() < poloList.get(numSelected).getPosX()) {
			if (marco.getSpeedX() > 0) {
				marco.setSpeedX(marco.getSpeedX());
			} else if (marco.getSpeedX() < 0) {
				marco.setSpeedX(marco.getSpeedX() * -1);
			}

		} else if (marco.getPosX() > poloList.get(numSelected).getPosX()) {

			if (marco.getSpeedX() < 0) {
				marco.setSpeedX(marco.getSpeedX());
			} else if (marco.getSpeedX() > 0) {
				marco.setSpeedX(marco.getSpeedX() * -1);
			}
		}

		if (marco.getPosY() < poloList.get(numSelected).getPosY()) {

			if (marco.getSpeedY() > 0) {
				marco.setSpeedY(marco.getSpeedY());
			} else if (marco.getSpeedY() < 0) {
				marco.setSpeedY(marco.getSpeedY() * -1);
			}

		} else if (marco.getPosY() > poloList.get(numSelected).getPosY()) {

			if (marco.getSpeedY() < 0) {
				marco.setSpeedY(marco.getSpeedX());
			} else if (marco.getSpeedY() > 0) {
				marco.setSpeedY(marco.getSpeedY() * -1);
			}
		} else if (marco.getPosY() == 0) {
			marco.setSpeedY(marco.getSpeedY() * 0);
		} else if (marco.getPosX() == 0) {
			marco.setSpeedX(marco.getSpeedX() * 0);
		}
		new Thread(marco).start();
		catchPolo();
	}

	private void catchPolo() {
		if (PApplet.dist(marco.getPosX(), marco.getPosY(), poloList.get(numSelected).getPosX(),
				poloList.get(numSelected).getPosY()) < 50 && stopMoving == true) {
			poloList.remove(numSelected);
			System.out.println("remove");
			stopMoving = false;
		}

		stopMoving = false;
		numSelected = 0;
	}
	
	private void playAgain() {
		if (poloList.size() == 1) {

			for (int i = 0; i < 20; i++) {

				poloList.add(new Polo((int) app.random(30, 970), (int) app.random(30, 970), speed, -speed, "Polo", app));

			}
		}
	}

}

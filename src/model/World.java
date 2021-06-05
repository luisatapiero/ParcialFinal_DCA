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
		//stopMoving = false;
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
		// stopMoving = false;
		currentTime = app.millis() - startTime;
		app.text("Tiempo: " + currentTime / 1000, 60, 60);

		drawAutomatons();
	}

	private void drawAutomatons() {
		drawMarco();
		drawPolo();
	}

	private void drawMarco() {
		marco.drawMarco();
		sayMessageMarco();
	}

	private void drawPolo() {
		for (int i = 0; i < poloList.size(); i++) {
			poloList.get(i).drawPolo();
			// if (stopMoving == false) {
			new Thread(poloList.get(i)).start();
			// }
		}
		sayMessagePolo();
	}

	private boolean sayMessageMarco() {

		if (currentTime / 1000 % 2 == 0 && currentTime / 1000 != 0) {
			marco.sayMessage();

			return true;
		}
		return false;

	}

	private void sayMessagePolo() {

		if (sayMessageMarco()) {

			for (int i = 0; i < poloList.size(); i++) {

				poloList.get(i).sayMessage();
				//poloList.get(i).setStopMoving(true);

			}

		}
		calculateDistance();
		//stopMoving = true;
		//chasePolo();
	}

	private void calculateDistance() {

		selectedPoloX = poloList.get(0).getPosX();
		selectedPoloY = poloList.get(0).getPosY();
		//System.out.println("PRIMERO "+selectedPoloX + " " + selectedPoloY);

		int distanceSelected = (int) PApplet.dist(marco.getPosX(), marco.getPosY(), selectedPoloX, selectedPoloY);
		for (int i = 1; i < poloList.size(); i++) {
			// marco.calculateDistance(poloList.get(i).getPosX(), poloList.get(i).posY);

			if ((marco.calculateDistance(poloList.get(i).getPosX(), poloList.get(i).posY)) < distanceSelected) {
				
				numSelected = i;
			}
		}
		
		selectedPoloX = poloList.get(numSelected).getPosX();
		selectedPoloY = poloList.get(numSelected).getPosY();
		
		System.out.println(selectedPoloX + " " + selectedPoloY);
		chasePolo(selectedPoloX, selectedPoloY);
	}

	private void chasePolo(int selectedPoloX, int selectedPoloY) {
		// new Thread (marco).start();

			//marco.moveMarco();
			new Thread (marco).start();
			
			if (marco.getPosX() < selectedPoloX) {
				marco.setSpeedX(marco.getSpeedX()*1);
			} else if (marco.getPosX() > selectedPoloX){
				marco.setSpeedX(marco.getSpeedX()*-1);
			} 

			if (marco.getPosY() < selectedPoloY) {
				marco.setSpeedY(marco.getSpeedY()*1);
			} else if (marco.getPosY() > selectedPoloY){
				marco.setSpeedY(marco.getSpeedY()*-1);
			} 
			
			// new Thread(marco).start();
			catchPolo();

	}
	
	private void catchPolo() {
		if (marco.getPosX() > selectedPoloX && marco.getPosY() == selectedPoloY) {
			poloList.remove(numSelected);
			System.out.println("remove");
		}
	}

}

package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class World {

	PApplet app;
	private Marco marco;
	private ArrayList<Polo> poloList;

	public World(PApplet app) {

		this.app = app;
		poloList = new ArrayList<Polo>();
		createAutomatons();

	}

	private void createAutomatons() {

		for (int i = 0; i < 20; i++) {

			poloList.add(new Polo((int) app.random(30, 970), (int) app.random(30, 970), 3, -3, "Polo", app));

		}

		marco = new Marco(340, 340, 0, 0,"Marco",app);

	}

	public void drawAutomatons() {
		marco.drawMarco();

		for (int i = 0; i < poloList.size(); i++) {
			poloList.get(i).drawPolo();
			poloList.get(i).movePolo();
			// System.out.println(automatonList.get(0).getMessage());
		}

	}

}

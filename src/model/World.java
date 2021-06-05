package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class World {

	PApplet app;
	private ArrayList<Automaton> automatonList;

	public World(PApplet app) {

		this.app = app;
		automatonList = new ArrayList<Automaton>();
		createAutomatons();

	}

	private void createAutomatons() {
		automatonList.add(new Marco(340, 340, 0, 0, "Marco", app));
		for (int i = 1; i < 20; i++) {
			automatonList.add(new Polo((int) app.random(10, 980), (int) app.random(10, 680), 0, 0, "Polo", app));
		}
		System.out.println(automatonList.size());
		
	}
	
	public void drawAutomatons() {
		automatonList.get(0).drawAutomaton("Marco");
		
		for (int i = 1; i < automatonList.size(); i++) {
			automatonList.get(i).drawAutomaton("Polo");
			//System.out.println(automatonList.get(0).getMessage());
		}
		
		
	}
	

}

package controller;

import model.World;
import processing.core.PApplet;


public class ControllerMain {

	World world;

	public ControllerMain(PApplet app) {

		world = new World(app);
	
	}
	
	public void drawAutomatons() {
		world.drawAutomatons();
	}

}

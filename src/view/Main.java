package view;

import controller.ControllerMain;
import processing.core.PApplet;

public class Main extends PApplet {

	ControllerMain controllerMain;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}

	public void settings() {
		size(1000, 700);
	}

	public void setup() {
		controllerMain = new ControllerMain(this);
	}

	public void draw() {
		background(25, 25, 35);
		controllerMain.drawAutomatons();
	}

}

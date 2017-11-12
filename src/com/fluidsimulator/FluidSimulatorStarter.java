package com.fluidsimulator;

//libgdx api Game
import com.badlogic.gdx.Game;


//this class basically creates an object of class FluidSimulator and sets the screen to it
public class FluidSimulatorStarter extends Game {
	FluidSimulator fluidSimulatorScreen;

	//override the null definition of the create function in com.badlogic.Game
	//create() function is first called when the application is first created
	@Override
	public void create() {
		//Sets the current screen. Screen.hide() is called on any old screen,
		//and Screen.show() is called on the new screen, if any.
		setScreen(switchToFluidSimulator());
		
	}
	
	//if the current screen is null, create an instance of our main object, and sendit to create to
	//to set the screen accordingly
	public FluidSimulator switchToFluidSimulator() {
		if (fluidSimulatorScreen == null)
			fluidSimulatorScreen = new FluidSimulator(this);
		return fluidSimulatorScreen;
	}
}

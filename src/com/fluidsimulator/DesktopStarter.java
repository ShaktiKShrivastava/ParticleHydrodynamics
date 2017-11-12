package com.fluidsimulator;

import java.awt.Toolkit;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopStarter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.fullscreen = true;
		config.resizable = false;
		config.title = "Fluid Simulator";
		
		//disabled matching the frame rate with the monitor refresh rate
		config.vSyncEnabled = false;
		
		config.width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		config.height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		//whether to use opengl version 2.0 or not
		config.useGL20 = false;
		
		//now create a new object of fluidSimulatorStarter() with the configurations config just defined above
		new LwjglApplication(new FluidSimulatorStarter(), config);
	}

}

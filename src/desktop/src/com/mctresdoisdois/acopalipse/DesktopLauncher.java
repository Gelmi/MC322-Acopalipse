package com.mctresdoisdois.acopalipse;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mctresdoisdois.acopalipse.Acopalipse;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("Acopalipse");
		config.setWindowedMode(800, 480);
		config.setResizable(false);
		config.useVsync(true);
		config.setForegroundFPS(60);
		new Lwjgl3Application(new Acopalipse(), config);
	}
}

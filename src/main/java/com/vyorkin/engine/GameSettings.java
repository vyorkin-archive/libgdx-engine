package com.vyorkin.engine;

public class GameSettings {
	public int width;
	public int height;

	public String title;
	public String version;
	
	public String log;
	public String preferences;
	public boolean developer;
	public String cursorFileName;
	
	public boolean useGL20;
	
	public boolean useAccelerometer;
	public boolean useCompass;
	public boolean useWakelock;
	public boolean hideStatusBar;
	
	public boolean vSyncEnabled;
	public boolean fullscreen;
	public boolean resizable;
	public boolean forceExit;
	
	public GameSettings(String title, String version, int width, int height) {
		this(title, version, title, width, height);
	}
	public GameSettings(String title, String version, 
		String log, int width, int height) {
		this.version = version;
		this.log = log;
		this.width = width;
		this.height = height;
		this.preferences = title.toLowerCase().replace(' ', '-');
		
		this.forceExit = true;
		this.resizable = true;
		this.vSyncEnabled = true;
		
		this.useAccelerometer = true;
		this.useCompass = true;
	}
}

package com.vyorkin.engine;


public class GameSettings {
	public int width;
	public int height;
	public boolean useGL20;
	public String preferences;
	public String version;
	public String log;
	public String title;
	
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
	}
}

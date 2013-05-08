package com.vyorkin.engine.services;

import com.badlogic.gdx.audio.Sound;
import com.vyorkin.engine.E;

public class SoundManager {
	private float volume;
	private boolean muted;
	
	public SoundManager() {
		this.muted = E.preferences.isSoundMuted();
		this.volume = E.preferences.getSoundVolume();
		
		E.log("Sound muted: " + this.muted);
		E.log("Sound volume: " + this.volume);
	}
	
	public void play(String fileName) {
		if (muted)
			return;
		
		E.log("Playing sound: " + fileName);
		E.assets.get(fileName, Sound.class).play(volume);
	}
	
	public float getVolume() {
		return volume;
	}
	
	public void setVolume(float volume) {
		E.log("Adjusting volume to: " + volume);
		
		this.volume = volume;
	}
	
	public boolean isMuted() {
		return muted;
	}
	
	public void setMuted(boolean muted) {
		this.muted = muted;
	}
}

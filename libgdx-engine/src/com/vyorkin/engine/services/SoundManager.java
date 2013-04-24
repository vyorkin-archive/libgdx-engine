package com.vyorkin.engine.services;

import com.badlogic.gdx.audio.Sound;
import com.vyorkin.engine.E;

public class SoundManager {
	private float volume;
	private boolean muted;
	
	public SoundManager(boolean muted, float volume) {
		this.volume = 1;
		this.muted = false;
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

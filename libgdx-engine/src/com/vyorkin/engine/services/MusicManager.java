package com.vyorkin.engine.services;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.Disposable;
import com.vyorkin.engine.E;

public class MusicManager implements Disposable {
    private String current;
    private float volume;
    private boolean muted;

    public MusicManager(boolean muted, float volume) {
    	this.muted = false;
    	this.volume = 1;
    }

    public void play(String fileName) {
    	if (muted || current == fileName)
    		return;
    	
    	E.log("Playing music: " + fileName);
    	
    	stop();

    	Music resource = E.assets.get(fileName, Music.class);
    	
    	resource.setVolume(volume);
    	resource.setLooping(true);
    	resource.play();
    	
    	current = fileName;
    }
    
    public void stop() {
    	if (current != null) {
    		E.log("Stopping current music");
    		E.assets.get(current, Music.class).stop();
    	}
    }
    
    public void setVolume(float volume) {
    	E.log("Adjusting music volume to: " + volume);
    	
    	this.volume = volume;
    	
    	if (current != null)
    		E.assets.get(current, Music.class).setVolume(volume);
    }
    
    public boolean isMuted() {
    	return muted;
    }
    
    public void setMuted(boolean muted) {
    	this.muted = muted;
    	if (muted)
    		stop();
    }
    
    public void dispose() {
    	E.log("Disposing music manager");
    	stop();
    }
}
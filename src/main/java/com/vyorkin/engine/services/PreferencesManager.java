package com.vyorkin.engine.services;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.vyorkin.engine.E;

public class PreferencesManager {
	private static final String DEVELOPER_MODE_KEY = "developer";
	private static final String MUSIC_VOLUME_KEY = "music.volume";
	private static final String MUSIC_MUTED_KEY = "music.muted";
	private static final String SOUND_VOLUME_KEY = "sound.volume";
	private static final String SOUND_MUTED_KEY = "sound.muted";
	
	private static final float SOUND_VOLUME_DEFAULT = 0.5f;
	private static final float MUSIC_VOLUME_DEFAULT = 0.5f;
	
	public Preferences get() {
		return Gdx.app.getPreferences(E.settings.preferences);
	}
	
	public void save() {
		get().flush();
	}
	
	public boolean isDeveloperMode() {
		return get().getBoolean(DEVELOPER_MODE_KEY, E.settings.developer);
	}
	
	public void toggleDeveloperMode() {
		get().putBoolean(DEVELOPER_MODE_KEY, !isDeveloperMode());
		save();
	}
	
	public boolean isMusicMuted() {
		return get().getBoolean(MUSIC_MUTED_KEY, false);
	}
	public void setMusicMuted(boolean muted) {
		get().putBoolean(MUSIC_MUTED_KEY, muted);
		save();
	}
	
	public float getMusicVolume() {
		return get().getFloat(
			MUSIC_VOLUME_KEY, 
			MUSIC_VOLUME_DEFAULT
		);
	}
	public void setMusicVolume(float volume) {
		get().putFloat(MUSIC_VOLUME_KEY, volume);
		save();
	}
	
	public boolean isSoundMuted() {
		return get().getBoolean(SOUND_MUTED_KEY);
	}
	public void setSoundMuted(boolean muted) {
		get().putBoolean(SOUND_MUTED_KEY, false);
		save();
	}
	
	public float getSoundVolume() {
		return get().getFloat(
			SOUND_VOLUME_KEY, 
			SOUND_VOLUME_DEFAULT
		);
	}
	public void setSoundVolume(float volume) {
		get().putFloat(SOUND_VOLUME_KEY, volume);
		save();
	}
}
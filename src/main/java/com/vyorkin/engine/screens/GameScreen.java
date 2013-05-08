package com.vyorkin.engine.screens;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.vyorkin.engine.E;

public abstract class GameScreen extends InputAdapter implements Screen {
	private boolean done;
	
	public boolean isDone() {
		return done;
	}
	
	public void setDone() {
		done = true;
	}
	
	public String getName() {
		return getClass().getSimpleName();
	}
	
	@Override
	public void render(float delta) {
		update(delta);
		draw(delta);
	}
	
	@Override
	public void resize(int width, int height) {
		log(String.format("Resizing screen to: %dx%d", width, height));
	}

	@Override
	public void show() {
		log("Showing screen: " + getName());
	}

	@Override
	public void hide() {
		log("Hiding screen: " + getName()); 
	}

	@Override
	public void pause() {
		log("Pausing screen: " + getName());
	}

	@Override
	public void resume() {
		log("Resuming screen: " + getName());
	}

	@Override
	public void dispose() {
		log("Disposing screen: " + getName());
		unload();
	}
	
	protected void log(String text) {
		E.log(text);
	}
	
	public abstract Camera getCamera();
	
	protected void update(float delta) {}
	protected abstract void draw(float delta);
	
	public void load() {}
	protected void unload() {}
}

package com.vyorkin.engine.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.vyorkin.engine.E;

public abstract class StageScreen extends GameScreen {
	protected Stage stage;
	
	protected StageScreen() {
		this(E.settings.width, E.settings.height);
	}
	
	protected StageScreen(int width, int height) {
		stage = new Stage(width, height, true);
	}
	
	@Override
	public void show() {
		super.show();
		Gdx.input.setInputProcessor(stage);
	}
	
	@Override
	public void dispose() {
		super.dispose();
		stage.dispose();
	}
	
	@Override
	protected void update(float delta) {
		stage.act(delta);
	}
	
	@Override
	protected void draw(float delta) {
		stage.draw();
	}
}

package com.vyorkin.engine.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;

import com.vyorkin.engine.E;

public class TextLoadingRenderer extends LoadingRenderer {
	public TextLoadingRenderer(Runnable doneCallback) {
		super(doneCallback);
	}
	
	@Override
	protected void draw(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		E.batch.begin();
		
		E.font.setColor(Color.WHITE);
		E.font.draw(E.batch, "Loading: " + getPercents(), 100, 200);
		
		E.batch.end();
	}
}

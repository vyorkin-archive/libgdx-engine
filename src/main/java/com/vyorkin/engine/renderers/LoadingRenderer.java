package com.vyorkin.engine.renderers;

import com.vyorkin.engine.E;
import com.vyorkin.engine.base.Renderable;

public abstract class LoadingRenderer implements Renderable {
	private final Runnable doneCallback;
	
	protected LoadingRenderer() {
		this(null);
	}
	protected LoadingRenderer(Runnable doneCallback) {
		this.doneCallback = doneCallback;
	}
	
	public int getPercents() {
		return (int)(E.assets.getProgress() * 100.0f);
	}
	
	public boolean isDone() {
		return E.assets.getProgress() == 1;
	}
	
	public void render(float delta) {
		if (E.assets.update()) {
			if (doneCallback != null) {
				doneCallback.run();
			}
		} else {
			draw(delta);
			E.log("Loading: " + getPercents());
		}
	}
	
	protected abstract void draw(float delta);
}

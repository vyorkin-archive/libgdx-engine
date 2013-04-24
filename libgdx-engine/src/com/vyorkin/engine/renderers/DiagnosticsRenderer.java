package com.vyorkin.engine.renderers;

import com.badlogic.gdx.Gdx;
import com.vyorkin.engine.E;
import com.vyorkin.engine.base.Renderable;

public class DiagnosticsRenderer implements Renderable {
	@Override
	public void render(float delta) {
		E.batch.begin();
		
		E.font.drawMultiLine(
			E.batch, getDiagnostics(), 
			E.settings.width - 160, 60
		);
		
		E.batch.end();
	}
	
	private String getDiagnostics() {
		return 
			"FPS: " + Gdx.graphics.getFramesPerSecond() + "\n" +
			"Java heap: " + Gdx.app.getJavaHeap()/1024/1024 + "M" + "\n" +
			"Native heap: " + Gdx.app.getNativeHeap()/1024/1024 + "M";
	}
}

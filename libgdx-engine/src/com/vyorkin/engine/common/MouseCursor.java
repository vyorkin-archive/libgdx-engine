package com.vyorkin.engine.common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.vyorkin.engine.E;

public class MouseCursor {
	private TextureRegion texture;
	private final boolean enabled;

	public MouseCursor() {
		this.enabled = isCursorEnabled();
		if (this.enabled) {
			this.texture = new TextureRegion(
				E.assets.get(E.settings.cursorFileName, Texture.class));
			
			Gdx.input.setCursorCatched(true);
		}
	}
	
	public void draw(Camera camera) {
		if (this.enabled) {
			Vector3 position = new Vector3(
				Gdx.input.getX(), Gdx.input.getY(), 0
			);
			camera.unproject(position);
			
			E.batch.draw(texture, position.x, position.y);
		}
	}
	
	private static boolean isCursorEnabled() {
		return 
			Gdx.app.getType() != ApplicationType.Android &&
			E.settings.cursorFileName != null;
	}
}
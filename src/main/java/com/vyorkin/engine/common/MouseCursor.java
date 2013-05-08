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

	public MouseCursor(String fileName) {
		this.enabled = isCursorEnabled(fileName);
		if (this.enabled) {
			E.assets.load(fileName, Texture.class);
			E.assets.finishLoading();
			
			Texture tex = E.assets.get(fileName, Texture.class);
			this.texture = new TextureRegion(tex);

			Gdx.input.setCursorCatched(true);
		}
	}
	
	public void draw(Camera camera) {
		if (this.enabled) {
			Vector3 position = new Vector3(
				Gdx.input.getX(), Gdx.input.getY(), 0
			);
			camera.unproject(position);
			
//			E.batch.begin();
			E.batch.draw(texture, 
				position.x + texture.getRegionWidth() / 2, 
				position.y - texture.getRegionHeight() / 2
			);
//			E.batch.end();
		}
	}
	
	private static boolean isCursorEnabled(String fileName) {
		return 
			Gdx.app.getType() != ApplicationType.Android &&
			fileName != null;
	}
}
package com.vyorkin.engine.common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.vyorkin.engine.E;

public class GameCamera extends OrthographicCamera {
	private final int virtualWidth;
	private final int virtualHeight;
	private final float virtualAspectRatio;

	protected Rectangle viewport;

	public GameCamera(int width, int height) {
		super(width, height);

		this.virtualWidth = width;
		this.virtualHeight = height;
		this.virtualAspectRatio = virtualWidth / virtualHeight;

		resize(width, height);
		setToOrtho(false, virtualWidth, virtualHeight);
	}

	public void updateViewport() {
		Gdx.gl.glViewport((int) viewport.x, (int) viewport.y,
				(int) viewport.width, (int) viewport.height);
	}

	public void resize(int width, int height) {
		float aspectRatio = (float) width / (float) height;
		float scale = 1f;
		Vector2 crop = new Vector2(0f, 0f);

		if (aspectRatio > virtualAspectRatio) {
			scale = (float) height / virtualHeight;
			crop.x = (width - virtualWidth * scale) / 2f;
		} else if (aspectRatio < virtualAspectRatio) {
			scale = (float) width / virtualWidth;
			crop.y = (height - virtualHeight * scale) / 2f;
		} else {
			scale = (float) width / virtualWidth;
		}

		float w = (float) virtualWidth * scale;
		float h = (float) virtualHeight * scale;

		viewport = new Rectangle(crop.x, crop.y, w, h);

		E.log(String.format("Setting viewport to: (%d, %d, %d, %d)",
				(int) crop.x, (int) crop.y, (int) w, (int) h));
	}

	public Vector2 unproject(float x, float y) {
		Vector3 v = new Vector3(x, y, 0);
		unproject(v, viewport.x, viewport.y, 
			viewport.width, viewport.height);
		
		return new Vector2(v.x, v.y);
	}

	public Vector2 unproject(Vector2 pos) {
		return unproject(pos.x, pos.y);
	}

	public float getWidth() {
		return virtualWidth;
	}

	public float getHeight() {
		return virtualHeight;
	}

	public float getAspectRation() {
		return virtualAspectRatio;
	}

	public Vector2 getSize() {
		return new Vector2(virtualWidth, virtualHeight);
	}
}

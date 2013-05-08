package com.vyorkin.engine.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.math.Vector2;
import com.vyorkin.engine.E;

public class FontHelper {
	public static void drawCenter(String val) {
		draw(val, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
	}
	
	public static void draw(String val, Vector2 pos) {
		draw(val, pos.x, pos.y);
	}
	
	public static void draw(String val, float x, float y) {
		TextBounds numberBounds = E.font.getBounds(val);
		
		float cx = x - numberBounds.width / 2;
		float cy = y - numberBounds.height / 2;
		
		E.font.draw(E.batch, val, cx, cy);
	}
	
	public static void draw(int val, Vector2 pos) {
		draw(Integer.toString(val), pos);
	}
}

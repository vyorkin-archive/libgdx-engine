package vyorkin.engine.helpers;

import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.math.Vector2;
import com.vyorkin.engine.E;

public class FontHelper {
	public static void draw(String val, Vector2 pos) {
		
		TextBounds numberBounds = E.font.getBounds(val);
		
		float x = pos.x - numberBounds.width/2;
		float y = pos.y - numberBounds.height/2;
		
		E.font.draw(E.batch, val, x, y);
	}
	
	public static void draw(int val, Vector2 pos) {
		draw(Integer.toString(val), pos);
	}
}

package com.vyorkin.engine.viewport;

import com.badlogic.gdx.Gdx;

// Learned from this answer: http://stackoverflow.com/questions/3008772/how-to-smart-resize-a-displayed-image-to-original-aspect-ratio
// and from this posts:
// http://blog.gemserk.com/2013/01/22/our-solution-to-handle-multiple-screen-sizes-in-android-part-one/
// http://blog.gemserk.com/tag/libgdx/

/*
So the basic idea we have is:

original_ratio = original_width / original_height
designer_ratio = designer_width / designer_height
if original_ratio > designer_ratio
 designer_height = designer_width / original_ratio
else
 designer_width = designer_height * original_ratio

FROM: 	4:3  (800x600) = 1.3(3)
TO:		16:9 (854:480) = 1.778 (1.779166666666667)

MAX: 427:300 (854:600) = 1.423(3)
MIN: 5:3 	 (800x480) = 1.666666666666667
	
##########################

1) "original ar <= target ar"

816x544 = 1.5

orig = 1.423(3)
desi = 1.5

d_w = 544 * 1.423(3) = 774.112
d_h = 544

816x544 -> 774x544

--------------------------

2) "original ar < target ar"

800x620 = 1.290322580645161

orig = 1.423(3)
desi = 1.290322580645161

d_w = 800
d_h = 800/1.423(3) = 562.1925509486999 

800x620 -> 800x562
*/

public class VirtualViewport {
	private final float virtualAspectRatio;
	
	public final float virtualWidth;
	public final float virtualHeight;
	
    public VirtualViewport(float virtualWidth, float virtualHeight) {  
        this.virtualWidth = virtualWidth;  
        this.virtualHeight = virtualHeight;
        this.virtualAspectRatio = virtualWidth / virtualHeight;
    }  
  
    public float getWidth() {  
        return getWidth(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());  
    }  
  
    public float getHeight() {  
        return getHeight(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());  
    }  
  
    /** 
     * Returns the view port width to let all the virtual view port to be shown on the screen. 
     *  
     * @param screenWidth 
     *            The screen width. 
     * @param screenHeight 
     *            The screen Height. 
     */  
    public float getWidth(float screenWidth, float screenHeight) {  
        float aspect = screenWidth / screenHeight;  
        if (aspect > virtualAspectRatio || (Math.abs(aspect - virtualAspectRatio) < 0.01f)) {  
            return virtualHeight * aspect;  
        } else {  
            return virtualWidth;  
        }  
    }  
  
    /** 
     * Returns the view port height to let all the virtual view port to be shown on the screen. 
     *  
     * @param screenWidth 
     *            The screen width. 
     * @param screenHeight 
     *            The screen Height. 
     */  
    public float getHeight(float screenWidth, float screenHeight) {  
        float aspect = screenWidth / screenHeight;  
        if (aspect > virtualAspectRatio || (Math.abs(aspect - virtualAspectRatio) < 0.01f)) {  
            return virtualHeight;  
        } else {  
            return virtualWidth / aspect;  
        }  
    }  
  
}

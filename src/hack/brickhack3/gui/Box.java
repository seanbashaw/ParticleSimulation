package hack.brickhack3.gui;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 * Created by Connor on 2/11/2017.
 */
public class Box {
    public void start(){
        try{
            Display.setDisplayMode(new DisplayMode(800,800));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        while (Display.isCloseRequested()){
            Display.update();
        }
        Display.destroy();
    }
}

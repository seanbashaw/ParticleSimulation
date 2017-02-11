package hack.brickhack3.gui;

import hack.brickhack3.particle.Particle;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Connor on 2/11/2017.
 */
public class Box {

    List<Particle> particles = new ArrayList<>();

    public void addParticle(Particle p) {
        this.particles.add(p);
    }


    public void start(){
        try{
            Display.setDisplayMode(new DisplayMode(800,800));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        while (!Display.isCloseRequested()){
            Display.update();
        }
        Display.destroy();
    }
}

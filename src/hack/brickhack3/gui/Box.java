package hack.brickhack3.gui;

import hack.brickhack3.particle.Particle;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

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

    public static int width = 800;
    public static int height = 800;
    public static int inputpanel = 400;
    public static int barlength = 300;
    public float volumemin = 0;
    public float volumemax = 4;
    public float volume = (volumemax+volumemin)/2;
    public float kelvinmin = 0;
    public float kelvinmax = 1000;
    public float kelvin = (kelvinmax+kelvinmin)/2;

    public void start(){
        try{
            Display.setDisplayMode(new DisplayMode(width+inputpanel,height));
            Display.setFullscreen(true);
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0,width+inputpanel,0,height,1,-1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        while (!Display.isCloseRequested()){
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);
            GL11.glColor3f(.7f,.7f,.7f);
            GL11.glBegin(GL11.GL_QUADS);
            GL11.glVertex2f(width,0);
            GL11.glVertex2f(width,height);
            GL11.glVertex2f(width+inputpanel,height);
            GL11.glVertex2f(width+inputpanel,0);
            GL11.glEnd();
            float barstart = width+(inputpanel-barlength)/2;
            float mult = height/5;
            GL11.glColor3f(.9f,.9f,.9f);
            for (int i = 0; i < 3; i++) {
                GL11.glBegin(GL11.GL_QUADS);
                GL11.glVertex2f(barstart, mult+mult*i-5);
                GL11.glVertex2f(barstart, mult+mult*i+5);
                GL11.glVertex2f(barstart+barlength, mult+mult*i+5);
                GL11.glVertex2f(barstart+barlength, mult+mult*i-5);
                GL11.glEnd();
            }
            float volumepos=(volumemax-volume);
            GL11.glBegin(GL11.GL_QUADS);
            GL11.glVertex2f(barstart, mult+mult-5);
            GL11.glVertex2f(barstart, mult+mult+5);
            GL11.glVertex2f(barstart+barlength, mult+mult+5);
            GL11.glVertex2f(barstart+barlength, mult+mult-5);
            GL11.glEnd();
            update();
            Display.update();
        }
        Display.destroy();
    }
    public void update(){

    }
}

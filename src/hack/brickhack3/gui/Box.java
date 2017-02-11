package hack.brickhack3.gui;

import hack.brickhack3.particle.Particle;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Connor on 2/11/2017.
 */
public class Box {

    private List<Particle> particles = new ArrayList<>();

    public void addParticle(Particle p) {
        this.particles.add(p);
    }

    private static int width = 800;
    private static int height = 800;
    private static int inputpanel = 400;
    private static int barlength = 300;
    private float volumemin = 0;
    private float volumemax = 4;
    private float volume = (volumemax+volumemin)/2;
    private float kelvinmin = 0;
    private float kelvinmax = 1000;
    private float guinum = -1;
    public float kelvin = (kelvinmax+kelvinmin)/2;
    private double DEG2RAD = 3.14159/180;
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
        GL11.glOrtho(0,width+inputpanel,height,0,1,-1);
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
            GL11.glColor3f(.9f,.2f,.1f);
            for (Particle p : particles){
                GL11.glBegin(GL11.GL_TRIANGLE_FAN);
                for (int i = 0; i < 360; i++){
                    double deg = i*DEG2RAD;
                    GL11.glVertex2d(p.getX()+Math.cos(deg)*p.getRadius(),p.getY()+Math.sin(deg)*p.getRadius());
                }
                GL11.glEnd();
            }
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
            GL11.glColor3f(1f,1f,1f);
            float volumepos=(inputpanel-barlength)/2+width+(barlength*((volume-volumemin)/(volumemax-volumemin)));
            float volumeheight = mult+mult*0;
            GL11.glBegin(GL11.GL_QUADS);
            GL11.glVertex2f(volumepos-5, volumeheight-10);
            GL11.glVertex2f(volumepos+5, volumeheight-10);
            GL11.glVertex2f(volumepos+5, volumeheight+10);
            GL11.glVertex2f(volumepos-5, volumeheight+10);
            GL11.glEnd();
            if (Mouse.isButtonDown(0)){
                int x = Mouse.getX();
                int y = Mouse.getY();
                if (x >= width && x < width+inputpanel && y > 0 && y < height){
                    if (guinum==-1){
                        guinum = 0;
                    }
                    if (x > (volumepos-5) && x < (volumepos+5) && y < (volumeheight-10) && y > (volumeheight+10)){

                    }
                }
            }
            update();
            Display.update();
        }
        Display.destroy();
    }
    public void update(){
    }
}

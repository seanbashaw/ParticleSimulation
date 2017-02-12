package hack.brickhack3.gui;

import hack.brickhack3.particle.Particle;
import org.lwjgl.opengl.GL11;

/**
 * Created by seanb on 2/11/2017.
 */
public class Box {
    public Particle[] particles;
    private static int width=1080;
    private static int height=1080;
    private double DEG2RAD = Math.PI / 180;
    public Box(Particle[] particles){
        this.particles = particles;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public void draw() {
        GL11.glColor3f(.9f, .2f, .1f);
        for (int a = 0; a < particles.length; a++) {
            Particle p = particles[a];
            GL11.glBegin(GL11.GL_TRIANGLE_FAN);
            for (int i = 0; i < 360; i++) {
                double deg = i * DEG2RAD;
                GL11.glVertex2d(p.getX() + Math.cos(deg) * p.getRadius(), p.getY() + Math.sin(deg) * p.getRadius());
            }
            GL11.glEnd();
        }
    }

    public void update() {
        int i = 0;
        while(i < particles.length){
            particles[i].setDeltaT(1.00/Gui.getFps());
            particles[i].updatePosition();
            particles[i].wallCollisions();

            i += 1;
        }
    }
}

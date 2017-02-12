package hack.brickhack3.particle;

import hack.brickhack3.gui.Gui;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.tests.SoundTest;

import java.util.Vector;

/**
 * Created by Connor on 2/11/2017.
 * Class for the particles flying around and stuff
 */
public class Particle {

    private double x;
    private double y;
    private double velX = 0;
    private double velY = 0;

    private final int radius;

    private double deltaT;

    public Particle(double x, double y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;

    }

    /**
     * Get the radius of this particle
     *
     * @return the radius of this particle
     */
    public int getRadius() {
        return this.radius;
    }

    /**
     * Get the x-position of this particle
     *
     * @return the x-position of this particle
     */
    public double getX() {
        return x;
    }

    /**
     * Set a new x-position of this particle
     *
     * @param x a new x-position of this particle
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     *
     * @return
     */
    public double getY() {
        return y;
    }


    /**
     *
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     *
     * @return
     */
    public double getVelX() {
        return velX;
    }

    /**
     *
     * @param velX
     */
    public void setVelX(double velX) {
        this.velX = velX;
    }

    /**
     *
     * @return
     */
    public double getVelY() {
        return velY;
    }

    /**
     *
     * @param velY
     */
    public void setVelY(double velY) {
        this.velY = velY;
    }

    /**
     * Sets the velocity of this particle
     * TODO: divide magnitude by some factor
     * @param magnitude a magnitude
     * @param direction a direction (in degrees)
     */
    public void setVelocity(double magnitude, double direction) {
        magnitude *= 500;
        this.velX = magnitude * Math.cos(direction);
        this.velY = magnitude * Math.sin(direction);
    }

    /**
     * Updates the particle's xy based on it's velocity
     * TODO: skip frames if very slow
     */
    public void updatePosition(){
        x += velX * this.deltaT;
        y += velY * this.deltaT;
    }

    /**
     * Checks for collisions with the wall
     * Run in updatePosition
     * TODO: possible merge with checkCollisions
     */
    public void wallCollisions(){
        //Left wall
        if((x - radius) <= 0){
            velX = -velX;
            x = radius;
        }
        //Right wall
        else if((x + radius) >= Gui.getWidth()){
            velX = -velX;
            x = Gui.getWidth() - radius;
        }
        //Upper wall
        else if((y - radius) <= 0){
            velY = -velY;
            y = radius;
        }
        //Bottom wall
        else if((y + radius) >= Gui.getHeight()){
            velY = -velY;
            y = Gui.getHeight() - radius;
        }
    }

    /**
     * Calculate the new velocity and
     * @param that
     */
    public void particleCollide(Particle that){
        Vector2f pos1 = new Vector2f((float)this.x, (float)this.y);
        Vector2f pos2 = new Vector2f((float)that.x, (float)that.y);
        Vector2f delta = (pos2.add(pos1.negate()));
        float d = delta.length();
        if(d > 2 * radius) return;
        Vector2f mtd = delta.scale(((2 * radius) - d) / d);

        pos1.add(mtd.scale(0.5f));
        pos2.add(mtd.scale(-0.5f));

        Vector2f vel1 = new Vector2f((float)this.velX, (float)this.velY);
        Vector2f vel2 = new Vector2f((float)that.velX, (float)that.velY);

        Vector2f n = mtd.scale(1/mtd.length());

        Vector2f v = new Vector2f(0 , 0);
        v.add(vel1);
        v.add(vel2.negate());

        float vn = v.dot(n);
        if(vn > 0.0f) return;

        float i = - vn / 1.0f;
        Vector2f impulse = new Vector2f(n);
        impulse.scale(i);

        vel1.add(impulse);
        vel2.add(impulse.negate());

        this.velX = vel1.getX();
        this.velY = vel1.getY();
        that.velX = vel2.getX();
        that.velY = vel2.getY();

        this.updatePosition();
        that.updatePosition();
    }

    public double getDeltaT() {
        return deltaT;
    }

    public void setDeltaT(double deltaT) {
        this.deltaT = deltaT;
    }

    public void update() {
        this.updatePosition();
        this.wallCollisions();
    }

}

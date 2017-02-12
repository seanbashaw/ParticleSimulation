package hack.brickhack3.particle;

import hack.brickhack3.gui.Gui;

/**
 * Created by Connor on 2/11/2017.
 * Class for the particles flying around and stuff
 */
public class Particle implements Runnable {

    private double x;
    private double y;
    private double velX = 0;
    private double velY = 0;

    private final int radius;

    private double deltaT;
    private boolean complete;

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
        magnitude*=100;
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
        double theta1 = Math.atan(this.velX / this.velY);
        double theta2 = Math.atan(that.velX / that.velY);

        double v1 = Math.sqrt(Math.pow(this.velX,2) + Math.pow(this.velY, 2));
        double v2 = Math.sqrt(Math.pow(that.velX,2) + Math.pow(that.velY, 2));

        double phi = Math.atan((this.y - that.y) / (that.x - this.x));
        double pi = Math.PI;

        this.velX = (v2 * Math.cos(theta2 - phi) * Math.cos(phi)) + (v1 * Math.sin(theta1 - pi) * Math.cos(phi + pi));
        this.velY = (v2 * Math.cos(theta2 - phi) * Math.sin(phi)) + (v1 * Math.sin(theta1 - pi) * Math.sin(phi + pi));

        that.velY = (v1 * Math.cos(theta1 - phi) * Math.sin(phi)) + (v2 * Math.sin(theta2 - pi) * Math.sin(phi + pi));
        that.velX = (v1 * Math.cos(theta1 - phi) * Math.cos(phi)) + (v2 * Math.sin(theta2 - pi) * Math.cos(phi + pi));
    }

    public boolean isComplete() {
        return this.complete;
    }

    public double getDeltaT() {
        return deltaT;
    }

    public void setDeltaT(double deltaT) {
        this.deltaT = deltaT;
    }

    @Override
    public void run() {
        this.complete = false;
        this.updatePosition();
        this.wallCollisions();
        // check for other collisions

        this.complete = true;



    }
}

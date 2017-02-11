package hack.brickhack3.particle;

/**
 * Created by Connor on 2/11/2017.
 */
public class Particle {

    private double x;
    private double y;
    private double velocityCompX = 0;
    private double velocityCompY = 0;

    private final int radius;

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
    public double getVelocityCompX() {
        return velocityCompX;
    }

    /**
     *
     * @param velocityCompX
     */
    public void setVelocityCompX(double velocityCompX) {
        this.velocityCompX = velocityCompX;
    }

    /**
     *
     * @return
     */
    public double getVelocityCompY() {
        return velocityCompY;
    }

    /**
     *
     * @param velocityCompY
     */
    public void setVelocityCompY(double velocityCompY) {
        this.velocityCompY = velocityCompY;
    }

    /**
     * Sets the velocity of this particle
     *
     * @param magnitude a magnitude
     * @param direction a direction (in degrees)
     */
    public void setVelocity(double magnitude, double direction) {
        this.velocityCompX = magnitude * Math.cos(Math.toRadians(direction));
        this.velocityCompY = magnitude * Math.sin(Math.toRadians(direction));
    }


    
}

package hack.brickhack3.particle;

/**
 * Created by Connor on 2/11/2017.
 */
public class Particle {

    private double x;
    private double y;
    private double velocityCompX;
    private double velocityCompY;

    public Particle(double x, double y) {
        this.x = x;
        this.y = y;

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

package hack.brickhack3.startup;

import hack.brickhack3.gui.Box;
import hack.brickhack3.particle.Particle;

/**
 * Created by seanb on 2/11/2017.
 */
public class Main {
    public static void main(String[] args){
        Box box = new Box();

        Particle particle = new Particle(400, 400, 10);
        box.addParticle(particle);
        box.start();
    }
}

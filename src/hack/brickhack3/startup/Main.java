package hack.brickhack3.startup;

import hack.brickhack3.gui.Box;
import hack.brickhack3.particle.Particle;

/**
 * Created by Sean on 2/11/2017.
 * Start up found here
 */
public class Main {

    /**
     *  Constants needed for speed and such
     */
    public double T, M, R;


    /**
     * This function describes the distributions of the speed
     * @param v the given speed
     * @return the fraction of particles that will have that speed.
     */
    private double func(double v){
        return 4 * Math.PI * Math.pow( (3/2) , (M/2 * Math.PI * R * T)) * Math.pow( v , 2 )
                * Math.exp((-M * Math.pow( v , 2 ) / (2 * R * T)));
    }


    /**
     * Create an array of particles with weighted speeds and random directions and positions
     * @param N the number of particles to generate
     * @return the array full of particles
     */
    public Particle[] createParticles(int N){
        Particle[] arr = new Particle[N];
        int i = 0;

        double v = 0;
        while (i < N){

            int j = (int)(func(v) * N);
            if(j == 0 && i > 0) j = N;  //Catches right end of graph
            while(j > 0 && i < N){

                //create a particle with speed v
                arr[i] = new Particle(0, 0, 10);    //TODO: randomize xy or something
                double dir = Math.random() * 2 * Math.PI;
                arr[i].setVelocity(v, dir);

                j -= 1;
                i += 1;
            }

            v += 1;
        }

        return arr;
    }

    public static void main(String[] args){
        Box box = new Box();

        Particle particle = new Particle(400, 400, 10);
        box.start();
    }
}

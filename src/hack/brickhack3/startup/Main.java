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
    private static double T = 293, M = 1, R = 8.3145;


    /**
     * This function describes the distributions of the speed
     * @param v the given speed
     * @return the fraction of particles that will have that speed.
     */
    private static double func(double v){
        return 4 * Math.PI * Math.pow( (3/2) , (M/2 * Math.PI * R * T)) * Math.pow( v , 2 )
                * Math.exp((-M * Math.pow( v , 2 ) / (2 * R * T)));
    }


    /**
     * Create an array of particles with weighted speeds and random directions and positions
     * @param N the number of particles to generate
     * @return the array full of particles
     */
    private static Particle[] createParticles(int N){
        Particle[] arr = new Particle[N];
        int i = 0;

        double v = 0;
        while (i < N){

            int j = (int)(func(v) * N);
            if(j == 0 && i > 0) j = N;  //Catches right end of graph
            while(j > 0 && i < N){

                //create a particle with speed v
                arr[i] = new Particle(0, 0, 4);
                double dir = Math.random() * 2 * Math.PI;
                arr[i].setVelocity(v, dir);

                j -= 1;
                i += 1;
            }

            v += 1;
        }

        return arr;
    }

    private static void distributeParticles(Particle[] arr){
        int N = arr.length;
        //Particle[] placed = new Particle[N];

        int i = 0;
        while(i < N){
            Particle p = arr[i];

            //randomize position
            //while(true){
                p.setX((Math.random() * (Box.getWidth() - (2 * p.getRadius()))) + p.getRadius());
                p.setY((Math.random() * (Box.getHeight() - (2 * p.getRadius()))) + p.getRadius());

                //TODO: check if it overlaps

            //    break;
            //}

            i += 1;
        }

    }

    public static void main(String[] args){
        Box box = new Box();

        box.particles = createParticles(100);
        distributeParticles(box.particles);

        box.start();

        //move to thread?



    }
}

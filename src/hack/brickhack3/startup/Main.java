package hack.brickhack3.startup;

import hack.brickhack3.gui.Box;
import hack.brickhack3.gui.Gui;
import hack.brickhack3.particle.Particle;

import java.util.ArrayList;

import static javafx.scene.input.KeyCode.P;

/**
 * Created by Sean on 2/11/2017.
 * Start up found here
 */
public class Main {

    /**
     *  Constants needed for speed and such
     */
    private static double T = 2093, M = 1, R = 8.3145;


    /**
     * This function describes the distributions of the speed
     * @param v the given speed
     * @return the fraction of particles that will have that speed.
     */
    private static double func(double v){
        return 4 * Math.PI * Math.pow((M/2 * Math.PI * R * T) , (3/2)) * Math.pow( v , 2 )
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

    private static void distributeParticles(Particle[] arr) {
        int N = arr.length;
        ArrayList<Particle> placed = new ArrayList<Particle>();

        int i = 0;
        while (i < N) {
            Particle p = arr[i];
            boolean isSamePos = true;
            //randomize position
            while (isSamePos) {
                isSamePos = false;
                double x = ((Math.random() * (Box.getWidth() - (2 * p.getRadius()))) + p.getRadius());
                double y = ((Math.random() * (Box.getHeight() - (2 * p.getRadius()))) + p.getRadius());
                if (placed.size()==0) {
                    p.setX(x);
                    p.setY(y);
                    placed.add(p);
                    i++;
                }
                else {
                    for (Particle P : placed) {
                        if (P.getX() == x && P.getY() == y) isSamePos = true;
                    }
                    if (!isSamePos) {
                        p.setX(x);
                        p.setY(y);
                        placed.add(p);
                        i++;
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Box box = new Box(createParticles(100));
        distributeParticles(box.particles);
        Gui gui = new Gui(box);

        gui.start();

        //move to thread?




    }
}

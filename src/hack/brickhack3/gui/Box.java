package hack.brickhack3.gui;

import hack.brickhack3.particle.Particle;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

/**
 * Created by seanb on 2/11/2017.
 *
 */
public class Box {
    private Particle[] particles;

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    private boolean paused = false;
    private static int width = 1080;
    private static int height = 1080;
    private double DEG2RAD = Math.PI / 180;
    private QuadTree quad;

    public Box(Particle[] particles){
        this.particles = particles;
    }
    public Box(int num_particles, float t, float m){
        this.T = t;
        this.M = m;
        this.particles = this.createParticles(num_particles);
        this.distributeParticles(this.particles);
        this.quad = new QuadTree(0,new Rectangle(0,0,1080,1080));
    }
    public Box(int num_particles) {
        this.particles = this.createParticles(num_particles);
        this.distributeParticles(this.particles);
        this.quad = new QuadTree(0,new Rectangle(0,0,1080,1080));
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
        if (paused)
            return;
        /*for(Particle p : particles){
            p.setDeltaT(.50/Gui.getFps());
            p.updatePosition();
            p.wallCollisions();

            int i = 0;
            while(i < particles.length){
                int j = i + 1;
                while(j < particles.length){
                    //particles[i].particleCollide(particles[j]);
                    particles[i].particleCollide(particles[j]);
                    j += 1;
                }
                i += 1;
            }
        }*/
        this.quad.clear();
        if (this.particles.length > 50) {
            for (int i = 0; i < this.particles.length; i += 50) {
                final int i_temp = i;
                new Thread(() -> {
                    for (int k = 0; k < 51; k += 1) {

                        // this section is called on every particle

                        try {
                            this.particles[k + i_temp].setDeltaT(1.00/Gui.getFps());
                            this.particles[k + i_temp].update();
                        } catch (ArrayIndexOutOfBoundsException e) {
                            break;
                        }
                    }
                }).start();
            }
        } else {
            for (Particle p : this.particles) {
                p.setDeltaT(1.0/Gui.getFps());
                p.update();
            }

        }
        for(int i = 0; i < this.particles.length; i++){
            quad.insert(particles[i]);
        }
        ArrayList<Particle> returnObjects = new ArrayList<Particle>();
        for (int l = 0; l < this.particles.length; l++){
            returnObjects.clear();
            this.quad.retrieve(returnObjects,this.particles[l]);
            for (int x = 0; x < returnObjects.size(); x++){
                this.particles[l].particleCollide(returnObjects.get(x));
            }
        }
        this.quad.clear();
        // this section is called once
    }
    private enum Element {
        HYDROGEN,
        HELIUM,
        OXYGEN,
        NITROGEN,
        NEON
    }
    public void setTemperature(double t) {
        T = t;
    }

    public void setM(Element e) {
        if (e == Element.HELIUM){
            M = 0.004002602;
        }
        if (e == Element.HYDROGEN){
            M = 0.00100794;
        }
        if (e == Element.NEON){
            M = 0.0201797;
        }
        if (e == Element.NITROGEN){
            M = 0.0140067;
        }
        if (e == Element.OXYGEN){
            M = 0.0159994;
        }
    }


    /**
     *  Constants needed for speed and such
     */
    private double T = 1, M = 0.00100794, R = 8.3145;

    /**
     * This function describes the distributions of the speed
     * @param v the given speed
     * @return the fraction of particles that will have that speed.
     */
    private double func(double v){
        double pi = Math.PI;
        return 4.0 * pi
                * Math.pow((M / (2.0 * pi * R * T)) , (3.0/2.0))
                * Math.pow( v , 2.0 )
                * Math.exp((-M * Math.pow( v , 2.0 )) / (2.0 * R * T));
    }

    /**
     * Create an array of particles with weighted speeds and random directions and positions
     * @param N the number of particles to generate
     * @return the array full of particles
     */
    private Particle[] createParticles(int N){
        Particle[] arr = new Particle[N];
        double v = 0, avgV = 0;

        int i = 0;
        while(i < N) {
            double sum = 0, d = (1.0 / N);
            if(T < 150.0) d *= 0.5;
            if(T < 50.0) d *= 0.5;
            while (sum < 1.0 / (N + 1)) {
                sum += func(v) * d;
                v += d;
            }
            System.out.println("v=" + v + ", func(v)=" + func(v));

            arr[i] = new Particle(0, 0, 400);
            double dir = Math.random() * 2 * Math.PI;
            arr[i].setVelocity(v, dir);

            avgV += v;

            i += 1;
        }

        avgV /= N;
        System.out.println("AvgV=" + avgV);
        return arr;
    }

    private void distributeParticles(Particle[] arr) {
        int N = arr.length;
        ArrayList<Particle> placed = new ArrayList<>();

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
                        if ((P.getX() >= x+P.getRadius()) && (x-P.getRadius() >= P.getX()) && (P.getY() >= y+P.getRadius() && y-P.getRadius() >= P.getY() )) isSamePos = true;
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

}

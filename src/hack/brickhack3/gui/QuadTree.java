package hack.brickhack3.gui;

import hack.brickhack3.particle.Particle;

import java.util.ArrayList;

/**
 * @Author: Federico Rueda.
 */
public class QuadTree {
    public static final int MAX_LEVEL = 4;
    private int level;
    private Particle particle;
    private ArrayList<QuadTree> branches;


    public QuadTree(int level,Particle particle){
        this.level = level;
        this.particle = particle;
        this.branches = new ArrayList<QuadTree>();
    }

    public void subdivide(Particle particle){
        if (this.level <= MAX_LEVEL){
            this.branches.add(new QuadTree(this.level+1, particle));
        }
        else{
            // TODO: Collision
        }
    }

    public boolean isBranchFull(){
        return this.branches.size() >= 4; // True if full
    }

    public boolean isTreeFull(){
        return this.particle != null; // True if full
    }


}

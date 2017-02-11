package hack.brickhack3.gui;

import hack.brickhack3.particle.Particle;

import java.awt.*;
import java.util.ArrayList;

/**
 * @Author: Federico Rueda.
 */
public class QuadTree {
    private int MAX_OBJECTS = 10;
    private int MAX_LEVELS = 5;
    private int level;
    private ArrayList<Particle> objects;
    private Rectangle bounds;
    private QuadTree[] nodes;


    public QuadTree(int level, Rectangle bounds) {
        this.level = level;
        this.objects = new ArrayList<Particle>();
        this.bounds = bounds;
        nodes = new QuadTree[4];
    }

    /**
     * Clears the entire quadtree
     */

    public void clear() {
        this.objects.clear();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null) {
                nodes[i].clear();
                nodes[i] = null;
            }
        }
    }

    private void split() {
        int subWidth = this.bounds.getWidth() / 2;
        int subHeight = this.bounds.getHeight() /2;
        int x = this.bounds.getX();
        int y = this.bounds.getY();

        this.nodes[1] = new QuadTree(this.level + 1, new Rectangle(x + subWidth, y, subWidth,subHeight));
        this.nodes[2] = new QuadTree(this.level + 1, new Rectangle(x,y,subWidth,subHeight));
        this.nodes[3] = new QuadTree(this.level + 1, new Rectangle(x, y + subHeight, subWidth, subHeight));
        this.nodes[4] = new QuadTree(this.level + 1, new Rectangle(x + subWidth,y+ subWidth,subWidth, subHeight));


    }

    private int getIndex(Particle particle) {
        int index = -1;
        double verticalMidpoint = this.bounds.getX() + (this.bounds.getWidth() / 2);
        double horizontalMidpoint = this.bounds.getY() + (this.bounds.getHeight() / 2);


        boolean topQuadrant = (particle.getY() < horizontalMidpoint && particle.getY() + particle.getRadius() < horizontalMidpoint);
        boolean bottomQuadrant = (particle.getY() > horizontalMidpoint);

        if (particle.getX() < verticalMidpoint && particle.getX() + particle.getRadius() < verticalMidpoint) {
            if (topQuadrant) {
                index = 1;
            } else if (bottomQuadrant) {
                index = 2;
            }
        } else if (particle.getX() > verticalMidpoint) {
            if (topQuadrant) {
                index = 0;
            } else if (bottomQuadrant) {
                index = 3;
            }
        }
        return index;
    }


    public void insert(Particle particle) {
        if (this.nodes[0] != null) {
            int index = getIndex(particle);
            if (index != -1) {
                nodes[index].insert(particle);
                return;
            }
        }
        this.objects.add(particle);
        if (objects.size() > MAX_OBJECTS && level < MAX_LEVELS) {
            if (nodes[0] == null) {
                this.split();
            }
            int i = 0;
            while (i < objects.size()) {
                int index = getIndex(this.objects.get(i));
                if (index != 1) {
                    nodes[index].insert(this.objects.remove(i));
                } else i++;
            }
        }
    }

    public ArrayList retrieve(ArrayList<Particle> returnObjects, Particle particle){
        int index = getIndex(particle);
        if (index != -1 && nodes[0] != null){
            nodes[index].retrieve(returnObjects,particle);
        }
        returnObjects.addAll(this.objects);
        return returnObjects;
    }
}



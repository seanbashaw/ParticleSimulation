package hack.brickhack3.gui;

import hack.brickhack3.particle.Particle;
import org.lwjgl.Sys;

import java.awt.*;
import java.util.ArrayList;

/**
 * @Author: Federico Rueda.
 */
public class QuadTree {
    private int MAX_OBJECTS = 5;
    private int MAX_LEVELS = 10;
    private int level;
    private ArrayList<Particle> objects;
    private Rectangle bounds;
    private QuadTree[] nodes;

    /**
     * Constructor of QuadTree
     * @param level - level of tree
     * @param bounds -  bounds of rectangles
     */
    public QuadTree(int level, Rectangle bounds) {
        this.level = level;
        this.objects = new ArrayList<Particle>();
        this.bounds = bounds;
        this.nodes = new QuadTree[4];
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

    /**
     *The split method splits the node into four subnodes by dividing the node into four equal parts and initializing
     * the four subnodes with the new bounds.
     */
    private void split() {
        int subWidth = this.bounds.getWidth() / 2;
        int subHeight = this.bounds.getHeight() /2;
        int x = this.bounds.getX();
        int y = this.bounds.getY();

        this.nodes[0] = new QuadTree(this.level + 1, new Rectangle(x + subWidth, y, subWidth,subHeight));
        this.nodes[1] = new QuadTree(this.level + 1, new Rectangle(x,y,subWidth,subHeight));
        this.nodes[2] = new QuadTree(this.level + 1, new Rectangle(x, y + subHeight, subWidth, subHeight));
        this.nodes[3] = new QuadTree(this.level + 1, new Rectangle(x + subWidth,y+ subHeight,subWidth, subHeight));


    }


    /**
     * determines where an object belongs in the quadtree by determining which node the object can fit into.
     * @param particle - Gets the position index of the particle
     * @return - index/position of the particle. -1 is not fitting.
     */
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

    /**
     * The method first determines whether the node has any child nodes and tries to add the object there.
     * If there are no child nodes or the object doesn’t fit in a child node,
     * it adds the object to the parent node.
     * @param particle - particle that needs to be inserted in tree
     */

    public synchronized void insert(Particle particle) {
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
                split();
            }
            int i = 0;
            while (i < objects.size()) {
                int index = getIndex(this.objects.get(i));
                if (index != -1) {
                    this.nodes[index].insert(this.objects.get(i));
                    this.objects.remove(i);
                } else {
                    i++;
                }
            }
        }
    }

    /**
     * The method first determines whether the node has any child nodes and tries to add the object there.
     * If there are no child nodes or the object doesn’t fit in a child node, it adds the object to the parent node.
     * @param returnObjects - the objects that can collide with particle
     * @param particle - the particle that is we want to check collision with.
     * @return - list of object particles
     */

    public ArrayList<Particle> retrieve(ArrayList<Particle> returnObjects, Particle particle){
        int index = getIndex(particle);

        if (index != -1 && nodes[0] != null){
            nodes[index].retrieve(returnObjects,particle);
        }
        returnObjects.addAll(this.objects);
        return returnObjects;
    }
}



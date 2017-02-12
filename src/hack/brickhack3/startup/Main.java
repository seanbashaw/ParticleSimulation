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

    public static void main(String[] args){
        Box box = new Box(100);
        Gui gui = new Gui(box);

        gui.start();

        //move to thread?




    }
}

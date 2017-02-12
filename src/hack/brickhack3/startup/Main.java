package hack.brickhack3.startup;

import hack.brickhack3.gui.Box;
import hack.brickhack3.gui.Gui;

/**
 * Created by Sean on 2/11/2017.
 * Start up found here
 */
public class Main {

    public static void main(String[] args){
        Box box = new Box(1);
        Gui gui = new Gui(box);
        gui.start();

        //move to thread?




    }
}

package hack.brickhack3.gui;

import hack.brickhack3.particle.Particle;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Connor on 2/11/2017.
 */
public class Box {

    public Particle[] particles;

   // public void addParticle(Particle p) {
   //     this.particles.add(p);
   //     this.particles.add(p);
   // }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }
    public void type(String s, int x, int y) {
        int startX = x;
        GL11.glBegin(GL11.GL_POINTS);
        for (char c : s.toLowerCase().toCharArray()) {
            if (c == 'a') {
                for (int i = 0; i < 8; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                    GL11.glVertex2f(x + 7, y - i);
                }
                for (int i = 2; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y - 8);
                    GL11.glVertex2f(x + i, y - 4);
                }
                x += 8;
            } else if (c == 'b') {
                for (int i = 0; i < 8; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                }
                for (int i = 1; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y);
                    GL11.glVertex2f(x + i, y - 4);
                    GL11.glVertex2f(x + i, y - 8);
                }
                GL11.glVertex2f(x + 7, y - 5);
                GL11.glVertex2f(x + 7, y - 7);
                GL11.glVertex2f(x + 7, y - 6);

                GL11.glVertex2f(x + 7, y - 1);
                GL11.glVertex2f(x + 7, y - 2);
                GL11.glVertex2f(x + 7, y - 3);
                x += 8;
            } else if (c == 'c') {
                for (int i = 1; i <= 7; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                }
                for (int i = 2; i <= 5; i++) {
                    GL11.glVertex2f(x + i, y);
                    GL11.glVertex2f(x + i, y - 8);
                }
                GL11.glVertex2f(x + 6, y - 1);
                GL11.glVertex2f(x + 6, y - 2);

                GL11.glVertex2f(x + 6, y - 6);
                GL11.glVertex2f(x + 6, y - 7);

                x += 8;
            } else if (c == 'd') {
                for (int i = 0; i <= 8; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                }
                for (int i = 2; i <= 5; i++) {
                    GL11.glVertex2f(x + i, y);
                    GL11.glVertex2f(x + i, y - 8);
                }
                GL11.glVertex2f(x + 6, y - 1);
                GL11.glVertex2f(x + 6, y - 2);
                GL11.glVertex2f(x + 6, y - 3);
                GL11.glVertex2f(x + 6, y - 4);
                GL11.glVertex2f(x + 6, y - 5);
                GL11.glVertex2f(x + 6, y - 6);
                GL11.glVertex2f(x + 6, y - 7);

                x += 8;
            } else if (c == 'e') {
                for (int i = 0; i <= 8; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                }
                for (int i = 1; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y + 0);
                    GL11.glVertex2f(x + i, y - 8);
                }
                for (int i = 2; i <= 5; i++) {
                    GL11.glVertex2f(x + i, y - 4);
                }
                x += 8;
            } else if (c == 'f') {
                for (int i = 0; i <= 8; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                }
                for (int i = 1; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y - 8);
                }
                for (int i = 2; i <= 5; i++) {
                    GL11.glVertex2f(x + i, y - 4);
                }
                x += 8;
            } else if (c == 'g') {
                for (int i = 1; i <= 7; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                }
                for (int i = 2; i <= 5; i++) {
                    GL11.glVertex2f(x + i, y);
                    GL11.glVertex2f(x + i, y - 8);
                }
                GL11.glVertex2f(x + 6, y - 1);
                GL11.glVertex2f(x + 6, y - 2);
                GL11.glVertex2f(x + 6, y - 3);
                GL11.glVertex2f(x + 5, y - 3);
                GL11.glVertex2f(x + 7, y - 3);

                GL11.glVertex2f(x + 6, y - 6);
                GL11.glVertex2f(x + 6, y - 7);

                x += 8;
            } else if (c == 'h') {
                for (int i = 0; i <= 8; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                    GL11.glVertex2f(x + 7, y - i);
                }
                for (int i = 2; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y - 4);
                }
                x += 8;
            } else if (c == 'i') {
                for (int i = 0; i <= 8; i++) {
                    GL11.glVertex2f(x + 3, y - i);
                }
                for (int i = 1; i <= 5; i++) {
                    GL11.glVertex2f(x + i, y + 0);
                    GL11.glVertex2f(x + i, y - 8);
                }
                x += 7;
            } else if (c == 'j') {
                for (int i = 1; i <= 8; i++) {
                    GL11.glVertex2f(x + 6, y - i);
                }
                for (int i = 2; i <= 5; i++) {
                    GL11.glVertex2f(x + i, y + 0);
                }
                GL11.glVertex2f(x + 1, y - 3);
                GL11.glVertex2f(x + 1, y - 2);
                GL11.glVertex2f(x + 1, y - 1);
                x += 8;
            } else if (c == 'k') {
                for (int i = 0; i <= 8; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                }
                GL11.glVertex2f(x + 6, y - 8);
                GL11.glVertex2f(x + 5, y - 7);
                GL11.glVertex2f(x + 4, y - 6);
                GL11.glVertex2f(x + 3, y - 5);
                GL11.glVertex2f(x + 2, y - 4);
                GL11.glVertex2f(x + 2, y - 3);
                GL11.glVertex2f(x + 3, y - 4);
                GL11.glVertex2f(x + 4, y - 3);
                GL11.glVertex2f(x + 5, y - 2);
                GL11.glVertex2f(x + 6, y - 1);
                GL11.glVertex2f(x + 7, y);
                x += 8;
            } else if (c == 'l') {
                for (int i = 0; i <= 8; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                }
                for (int i = 1; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y);
                }
                x += 7;
            } else if (c == 'm') {
                for (int i = 0; i <= 8; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                    GL11.glVertex2f(x + 7, y - i);
                }
                GL11.glVertex2f(x + 3, y - 6);
                GL11.glVertex2f(x + 2, y - 7);
                GL11.glVertex2f(x + 4, y - 5);

                GL11.glVertex2f(x + 5, y - 6);
                GL11.glVertex2f(x + 6, y - 7);
                GL11.glVertex2f(x + 4, y - 5);
                x += 8;
            } else if (c == 'n') {
                for (int i = 0; i <= 8; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                    GL11.glVertex2f(x + 7, y - i);
                }
                GL11.glVertex2f(x + 2, y - 7);
                GL11.glVertex2f(x + 2, y - 6);
                GL11.glVertex2f(x + 3, y - 5);
                GL11.glVertex2f(x + 4, y - 4);
                GL11.glVertex2f(x + 5, y - 3);
                GL11.glVertex2f(x + 6, y - 2);
                GL11.glVertex2f(x + 6, y - 1);
                x += 8;
            } else if (c == 'o' || c == '0') {
                for (int i = 1; i <= 7; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                    GL11.glVertex2f(x + 7, y - i);
                }
                for (int i = 2; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y - 8);
                    GL11.glVertex2f(x + i, y + 0);
                }
                x += 8;
            } else if (c == 'p') {
                for (int i = 0; i <= 8; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                }
                for (int i = 2; i <= 5; i++) {
                    GL11.glVertex2f(x + i, y - 8);
                    GL11.glVertex2f(x + i, y - 4);
                }
                GL11.glVertex2f(x + 6, y - 7);
                GL11.glVertex2f(x + 6, y - 5);
                GL11.glVertex2f(x + 6, y - 6);
                x += 8;
            } else if (c == 'q') {
                for (int i = 1; i <= 7; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                    if (i != 1)
                        GL11.glVertex2f(x + 7, y - i);
                }
                for (int i = 2; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y - 8);
                    if (i != 6)
                        GL11.glVertex2f(x + i, y + 0);
                }
                GL11.glVertex2f(x + 4, y - 3);
                GL11.glVertex2f(x + 5, y - 2);
                GL11.glVertex2f(x + 6, y - 1);
                GL11.glVertex2f(x + 7, y);
                x += 8;
            } else if (c == 'r') {
                for (int i = 0; i <= 8; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                }
                for (int i = 2; i <= 5; i++) {
                    GL11.glVertex2f(x + i, y - 8);
                    GL11.glVertex2f(x + i, y - 4);
                }
                GL11.glVertex2f(x + 6, y - 7);
                GL11.glVertex2f(x + 6, y - 5);
                GL11.glVertex2f(x + 6, y - 6);

                GL11.glVertex2f(x + 4, y - 3);
                GL11.glVertex2f(x + 5, y - 2);
                GL11.glVertex2f(x + 6, y - 1);
                GL11.glVertex2f(x + 7, y);
                x += 8;
            } else if (c == 's') {
                for (int i = 2; i <= 7; i++) {
                    GL11.glVertex2f(x + i, y - 8);
                }
                GL11.glVertex2f(x + 1, y - 7);
                GL11.glVertex2f(x + 1, y - 6);
                GL11.glVertex2f(x + 1, y - 5);
                for (int i = 2; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y - 4);
                    GL11.glVertex2f(x + i, y);
                }
                GL11.glVertex2f(x + 7, y - 3);
                GL11.glVertex2f(x + 7, y - 2);
                GL11.glVertex2f(x + 7, y - 1);
                GL11.glVertex2f(x + 1, y - 1);
                GL11.glVertex2f(x + 1, y - 2);
                x += 8;
            } else if (c == 't') {
                for (int i = 0; i <= 8; i++) {
                    GL11.glVertex2f(x + 4, y - i);
                }
                for (int i = 1; i <= 7; i++) {
                    GL11.glVertex2f(x + i, y - 8);
                }
                x += 7;
            } else if (c == 'u') {
                for (int i = 1; i <= 8; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                    GL11.glVertex2f(x + 7, y - i);
                }
                for (int i = 2; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y + 0);
                }
                x += 8;
            } else if (c == 'v') {
                for (int i = 2; i <= 8; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                    GL11.glVertex2f(x + 6, y - i);
                }
                GL11.glVertex2f(x + 2, y - 1);
                GL11.glVertex2f(x + 5, y - 1);
                GL11.glVertex2f(x + 3, y);
                GL11.glVertex2f(x + 4, y);
                x += 7;
            } else if (c == 'w') {
                for (int i = 1; i <= 8; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                    GL11.glVertex2f(x + 7, y - i);
                }
                GL11.glVertex2f(x + 2, y);
                GL11.glVertex2f(x + 3, y);
                GL11.glVertex2f(x + 5, y);
                GL11.glVertex2f(x + 6, y);
                for (int i = 1; i <= 6; i++) {
                    GL11.glVertex2f(x + 4, y - i);
                }
                x += 8;
            } else if (c == 'x') {
                for (int i = 1; i <= 7; i++)
                    GL11.glVertex2f(x + i, y - i);
                for (int i = 7; i >= 1; i--)
                    GL11.glVertex2f(x + i, y - 8 + i);
                x += 8;
            } else if (c == 'y') {
                GL11.glVertex2f(x + 4, y);
                GL11.glVertex2f(x + 4, y - 1);
                GL11.glVertex2f(x + 4, y - 2);
                GL11.glVertex2f(x + 4, y - 3);
                GL11.glVertex2f(x + 4, y - 4);

                GL11.glVertex2f(x + 3, y - 5);
                GL11.glVertex2f(x + 2, y - 6);
                GL11.glVertex2f(x + 1, y - 7);
                GL11.glVertex2f(x + 1, y - 8);

                GL11.glVertex2f(x + 5, y - 5);
                GL11.glVertex2f(x + 6, y - 6);
                GL11.glVertex2f(x + 7, y - 7);
                GL11.glVertex2f(x + 7, y - 8);
                x += 8;
            } else if (c == 'z') {
                for (int i = 1; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y);
                    GL11.glVertex2f(x + i, y - 8);
                    GL11.glVertex2f(x + i, y - i);
                }
                GL11.glVertex2f(x + 6, y - 7);
                x += 8;
            } else if (c == '1') {
                for (int i = 2; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y);
                }
                for (int i = 1; i <= 8; i++) {
                    GL11.glVertex2f(x + 4, y - i);
                }
                GL11.glVertex2f(x + 3, y - 7);
                x += 8;
            } else if (c == '2') {
                for (int i = 1; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y);
                }
                for (int i = 2; i <= 5; i++) {
                    GL11.glVertex2f(x + i, y - 8);
                }
                GL11.glVertex2f(x + 1, y - 7);
                GL11.glVertex2f(x + 1, y - 6);

                GL11.glVertex2f(x + 6, y - 7);
                GL11.glVertex2f(x + 6, y - 6);
                GL11.glVertex2f(x + 6, y - 5);
                GL11.glVertex2f(x + 5, y - 4);
                GL11.glVertex2f(x + 4, y - 3);
                GL11.glVertex2f(x + 3, y - 2);
                GL11.glVertex2f(x + 2, y - 1);
                x += 8;
            } else if (c == '3') {
                for (int i = 1; i <= 5; i++) {
                    GL11.glVertex2f(x + i, y - 8);
                    GL11.glVertex2f(x + i, y);
                }
                for (int i = 1; i <= 7; i++) {
                    GL11.glVertex2f(x + 6, y - i);
                }
                for (int i = 2; i <= 5; i++) {
                    GL11.glVertex2f(x + i, y - 4);
                }
                x += 8;
            } else if (c == '4') {
                for (int i = 2; i <= 8; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                }
                for (int i = 2; i <= 7; i++) {
                    GL11.glVertex2f(x + i, y - 1);
                }
                for (int i = 0; i <= 4; i++) {
                    GL11.glVertex2f(x + 4, y - i);
                }
                x += 8;
            } else if (c == '5') {
                for (int i = 1; i <= 7; i++) {
                    GL11.glVertex2f(x + i, y - 8);
                }
                for (int i = 4; i <= 7; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                }
                GL11.glVertex2f(x + 1, y - 1);
                GL11.glVertex2f(x + 2, y);
                GL11.glVertex2f(x + 3, y);
                GL11.glVertex2f(x + 4, y);
                GL11.glVertex2f(x + 5, y);
                GL11.glVertex2f(x + 6, y);

                GL11.glVertex2f(x + 7, y - 1);
                GL11.glVertex2f(x + 7, y - 2);
                GL11.glVertex2f(x + 7, y - 3);

                GL11.glVertex2f(x + 6, y - 4);
                GL11.glVertex2f(x + 5, y - 4);
                GL11.glVertex2f(x + 4, y - 4);
                GL11.glVertex2f(x + 3, y - 4);
                GL11.glVertex2f(x + 2, y - 4);
                x += 8;
            } else if (c == '6') {
                for (int i = 1; i <= 7; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                }
                for (int i = 2; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y);
                }
                for (int i = 2; i <= 5; i++) {
                    GL11.glVertex2f(x + i, y - 4);
                    GL11.glVertex2f(x + i, y - 8);
                }
                GL11.glVertex2f(x + 7, y - 1);
                GL11.glVertex2f(x + 7, y - 2);
                GL11.glVertex2f(x + 7, y - 3);
                GL11.glVertex2f(x + 6, y - 4);
                x += 8;
            } else if (c == '7') {
                for (int i = 0; i <= 7; i++)
                    GL11.glVertex2f(x + i, y - 8);
                GL11.glVertex2f(x + 7, y - 7);
                GL11.glVertex2f(x + 7, y - 6);

                GL11.glVertex2f(x + 6, y - 5);
                GL11.glVertex2f(x + 5, y - 4);
                GL11.glVertex2f(x + 4, y - 3);
                GL11.glVertex2f(x + 3, y - 2);
                GL11.glVertex2f(x + 2, y - 1);
                GL11.glVertex2f(x + 1, y);
                x += 8;
            } else if (c == '8') {
                for (int i = 1; i <= 7; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                    GL11.glVertex2f(x + 7, y - i);
                }
                for (int i = 2; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y - 8);
                    GL11.glVertex2f(x + i, y + 0);
                }
                for (int i = 2; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y - 4);
                }
                x += 8;
            } else if (c == '9') {
                for (int i = 1; i <= 7; i++) {
                    GL11.glVertex2f(x + 7, y - i);
                }
                for (int i = 5; i <= 7; i++) {
                    GL11.glVertex2f(x + 1, y - i);
                }
                for (int i = 2; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y - 8);
                    GL11.glVertex2f(x + i, y + 0);
                }
                for (int i = 2; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y - 4);
                }
                GL11.glVertex2f(x + 1, y + 0);
                x += 8;
            } else if (c == '.') {
                GL11.glVertex2f(x + 1, y);
                x += 2;
            } else if (c == ',') {
                GL11.glVertex2f(x + 1, y);
                GL11.glVertex2f(x + 1, y - 1);
                x += 2;
            } else if (c == '\n') {
                y -= 10;
                x = startX;
            } else if (c == ' ') {
                x += 8;
            }
        }
        GL11.glEnd();
    }
    private static int width = 800;
    private static int height = 800;
    private static int inputpanel = 400;
    private static int barlength = 300;
    private float volumemin = 0;
    private float volumemax = 4;
    private float volume = (volumemax + volumemin) / 2;
    private float kelvinmin = 0;
    private float kelvinmax = 1000;
    private float guinum = -1;
    public float kelvin = (kelvinmax + kelvinmin) / 2;
    private double DEG2RAD = Math.PI / 180;

    public void start() {
        try {
            Display.setDisplayMode(new DisplayMode(width + inputpanel, height));
            Display.setFullscreen(true);
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, width + inputpanel, 0, height, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        while (!Display.isCloseRequested()) {
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
            GL11.glColor3f(.7f, .7f, .7f);
            GL11.glBegin(GL11.GL_QUADS);
            GL11.glVertex2f(width, 0);
            GL11.glVertex2f(width, height);
            GL11.glVertex2f(width + inputpanel, height);
            GL11.glVertex2f(width + inputpanel, 0);
            GL11.glEnd();
            GL11.glColor3f(.9f, .2f, .1f);
            for (Particle p : particles) {
                GL11.glBegin(GL11.GL_TRIANGLE_FAN);
                for (int i = 0; i < 360; i++) {
                    double deg = i * DEG2RAD;
                    GL11.glVertex2d(p.getX() + Math.cos(deg) * p.getRadius(), p.getY() + Math.sin(deg) * p.getRadius());
                }
                GL11.glEnd();
            }
            float barstart = width + (inputpanel - barlength) / 2;
            float mult = height / 5;
            GL11.glColor3f(.9f, .9f, .9f);
            for (int i = 0; i < 3; i++) {
                GL11.glBegin(GL11.GL_QUADS);
                GL11.glVertex2f(barstart, mult + mult * i - 5);
                GL11.glVertex2f(barstart, mult + mult * i + 5);
                GL11.glVertex2f(barstart + barlength, mult + mult * i + 5);
                GL11.glVertex2f(barstart + barlength, mult + mult * i - 5);
                GL11.glEnd();
            }
            GL11.glColor3f(1f, 1f, 1f);
            float volumepos = (inputpanel - barlength) / 2 + width + (barlength * ((volume - volumemin) / (volumemax - volumemin)));
            float volumeheight = mult + mult * 0;
           // type(""+volumemin, volumeheight-10,volumepos);
            GL11.glBegin(GL11.GL_QUADS);
            GL11.glVertex2f(volumepos - 5, volumeheight - 10);
            GL11.glVertex2f(volumepos + 5, volumeheight - 10);
            GL11.glVertex2f(volumepos + 5, volumeheight + 10);
            GL11.glVertex2f(volumepos - 5, volumeheight + 10);
            GL11.glEnd();
            float kelvinpos = (inputpanel - barlength) / 2 + width + (barlength * ((kelvin - kelvinmin) / (kelvinmax - kelvinmin)));
            float kelvinheight = mult + mult * 1;
            GL11.glBegin(GL11.GL_QUADS);
            GL11.glVertex2f(kelvinpos - 5, kelvinheight - 10);
            GL11.glVertex2f(kelvinpos + 5, kelvinheight - 10);
            GL11.glVertex2f(kelvinpos + 5, kelvinheight + 10);
            GL11.glVertex2f(kelvinpos - 5, kelvinheight + 10);
            GL11.glEnd();
            if (Mouse.isButtonDown(0)) {
                int x = Mouse.getX();
                int y = Mouse.getY();
                if (x >= width && x < width + inputpanel && y > 0 && y < height) {
                    if (x > (volumepos - 5) && x < (volumepos + 5) && y > (volumeheight - 10) && y < (volumeheight + 10)) {
                        if (guinum == -1) {
                            guinum = 0;
                        }
                    }
                    if (x > (kelvinpos - 5) && x < (kelvinpos + 5) && y > (kelvinheight - 10) && y < (kelvinheight + 10)) {
                        if (guinum == -1) {
                            guinum = 1;
                        }
                    }
                }
                if (guinum == 0) {
                    volume = volumemin+((volumemax-volumemin)*((x-barstart)/(barlength)));
                    volume = Math.max(Math.min(volume, volumemax), volumemin);
                }
                if (guinum == 1){
                    kelvin = kelvinmin+((kelvinmax-kelvinmin)*((x-barstart)/(barlength)));
                    kelvin = Math.max(Math.min(kelvin, kelvinmax), kelvinmin);
                }
            } else {
                guinum = -1;
            }
            update();
            Display.update();
        }
        Display.destroy();
    }

    public void update() {
    }
}

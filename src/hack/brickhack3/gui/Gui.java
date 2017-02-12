package hack.brickhack3.gui;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Gui {
    public Gui(Box p){
        this.box = p;
    }

    private Box box;
    public static int getWidth() {
        return Box.getWidth();
    }
    public static int getHeight() {
        return Box.getHeight();
    }
    private void type(String s, int x, int y) {
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
                    GL11.glVertex2f(x + i, y);
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
                    GL11.glVertex2f(x + i, y);
                    GL11.glVertex2f(x + i, y - 8);
                }
                x += 7;
            } else if (c == 'j') {
                for (int i = 1; i <= 8; i++) {
                    GL11.glVertex2f(x + 6, y - i);
                }
                for (int i = 2; i <= 5; i++) {
                    GL11.glVertex2f(x + i, y);
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
                    GL11.glVertex2f(x + i, y);
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
                        GL11.glVertex2f(x + i, y);
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
                    GL11.glVertex2f(x + i, y);
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
                    GL11.glVertex2f(x + i, y);
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
                    GL11.glVertex2f(x + i, y);
                }
                for (int i = 2; i <= 6; i++) {
                    GL11.glVertex2f(x + i, y - 4);
                }
                GL11.glVertex2f(x + 1, y);
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
    public static int getFps() {
        return fps;
    }
    private boolean toggle = false;
    private static int fps = 60;
    private float minimumVolume = 0;
    private float maximumVolume = 4;
    private float volume = (maximumVolume + minimumVolume) / 2;
    private float minimumKelvin = 0;
    private float maximumKelvin = 1000;
    private float selectedSlider = -1;
    private int selectedElement = 0;
    private Element element=Element.values()[selectedElement];
    private enum Element{
        HYDROGEN,
        HELIUM,
        OXYGEN,
        NITROGEN,
        NEON
    };

    private float kelvin = (maximumKelvin + minimumKelvin) / 2;
    private void drawBox(float x, float y, float width, float height){
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(x-width/2, y+height/2);
        GL11.glVertex2f(x-width/2, y-height/2);
        GL11.glVertex2f(x+width/2, y-height/2);
        GL11.glVertex2f(x+width/2, y+height/2);
        GL11.glEnd();
    }
    public void start() {
        int sliderLength = 300;
        int interfaceWidth = 400;
        int elementLength = 5;
        try {
            Display.setDisplayMode(new DisplayMode(Box.getWidth() + interfaceWidth, Box.getHeight()));
            Display.setVSyncEnabled(true);
            Display.setFullscreen(true);
            Display.setTitle("Particle Simulator - BrickHacks 3");
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, Box.getWidth() + interfaceWidth, Box.getHeight(), 0, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        while (!Display.isCloseRequested()) {
            float barStartPosition = Box.getWidth() + (interfaceWidth - sliderLength) / 2;
            float verticalSpacing = Box.getHeight() / 5;
            float volumeSliderPosition = (interfaceWidth - sliderLength) / 2 + Box.getWidth() + (sliderLength * ((volume - minimumVolume) / (maximumVolume - minimumVolume)));
            float volumeVerticalPosition = verticalSpacing * 1;
            float elementSliderPosition = (interfaceWidth - sliderLength) / 2 + Box.getWidth() + (sliderLength * selectedElement) / (elementLength-1);
            float elementVerticalPosition = verticalSpacing * 3;
            float kelvinSliderPosition = (interfaceWidth - sliderLength) / 2 + Box.getWidth() + (sliderLength * ((kelvin - minimumKelvin) / (maximumKelvin - minimumKelvin)));
            float kelvinVerticalPosition = verticalSpacing * 2;
            Display.sync(fps);
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
            box.draw();
            GL11.glColor3f(.7f, .7f, .7f);
            drawBox(Box.getWidth()+(interfaceWidth /2),Box.getHeight()/2, interfaceWidth,Box.getHeight());
            GL11.glColor3f(.9f, .9f, .9f);
            for (int i = 0; i < 3; i++) {
                drawBox(barStartPosition + (sliderLength / 2), verticalSpacing + verticalSpacing * i, sliderLength, 5);
            }
            type(""+ minimumVolume, (int)(barStartPosition)-10,(int)volumeVerticalPosition-20);
            type(""+ maximumVolume, (int)(barStartPosition+ sliderLength -10),(int)volumeVerticalPosition-20);
            type(Float.toString(volume).substring(0,3),(int)volumeSliderPosition-10,(int)volumeVerticalPosition-20);
            type("Volume",(int)(barStartPosition+ sliderLength /2-25),(int)(volumeVerticalPosition-40));
            type(element.name(),(int)(barStartPosition+ sliderLength /2)-25,(int)(elementVerticalPosition-40));
            GL11.glColor3f(1f, 1f, 1f);
            drawBox(volumeSliderPosition,volumeVerticalPosition,10,20);
            type(""+ minimumKelvin, (int)(barStartPosition)-12,(int)kelvinVerticalPosition-20);
            type(""+ maximumKelvin, (int)(barStartPosition+ sliderLength -12),(int)kelvinVerticalPosition-20);
            type((int)(kelvin)+"",(int)kelvinSliderPosition-12,(int)kelvinVerticalPosition-20);
            type("Kelvin",(int)(barStartPosition+ sliderLength /2-25),(int)(kelvinVerticalPosition-40));
            drawBox(kelvinSliderPosition,kelvinVerticalPosition,10,20);
            drawBox(elementSliderPosition,elementVerticalPosition,10,20);
            if (box.isPaused()){
                GL11.glColor3f(1,0,0);
            }else{
                GL11.glColor3f(0,1,0);
            }
            drawBox(barStartPosition+sliderLength/2,verticalSpacing*4,sliderLength,40);
            if (Mouse.isButtonDown(0)) {
                int x = Mouse.getX();
                int y = (Box.getHeight()-Mouse.getY());
                if (x >= Box.getWidth() && x < Box.getWidth() + interfaceWidth && y > 0 && y < Box.getHeight()) {
                    if (x > (volumeSliderPosition - 5) && x < (volumeSliderPosition + 5) && y > (volumeVerticalPosition - 10) && y < (volumeVerticalPosition + 10)) {
                        if (selectedSlider == -1) {
                            selectedSlider = 0;
                        }
                    }
                    if (x > (kelvinSliderPosition - 5) && x < (kelvinSliderPosition + 5) && y > (kelvinVerticalPosition - 10) && y < (kelvinVerticalPosition + 10)) {
                        if (selectedSlider == -1) {
                            selectedSlider = 1;
                        }
                    }
                    if (x > (elementSliderPosition - 5) && x < (elementSliderPosition + 5) && y > (elementVerticalPosition - 10) && y < (elementVerticalPosition + 10)) {
                        if (selectedSlider == -1) {
                            selectedSlider = 2;
                        }
                    }
                    if (x> (barStartPosition)&& x < barStartPosition+ sliderLength && y > verticalSpacing*4 - 40 && y < verticalSpacing*4 + 40&&!toggle){
                        toggle = true;
                        box.setPaused(!box.isPaused());
                    }
                }
                if (selectedSlider == 0) {
                    volume = minimumVolume +((maximumVolume - minimumVolume)*((x-barStartPosition)/(sliderLength)));
                    volume = Math.max(Math.min(volume, maximumVolume), minimumVolume);
                }
                if (selectedSlider == 1){
                    kelvin = minimumKelvin +((maximumKelvin - minimumKelvin)*((x-barStartPosition)/(sliderLength)));
                    kelvin = Math.max(Math.min(kelvin, maximumKelvin), minimumKelvin);
                }
                if (selectedSlider == 2){
                    selectedElement = (int)(((elementLength-1)*((x-barStartPosition)/(sliderLength))));
                    selectedElement = Math.max(Math.min(selectedElement,elementLength-1),0);
                    element = Element.values()[selectedElement];
                }
            } else {
                selectedSlider = -1;
                toggle=false;
            }
            update();
            Display.update();
        }
        Display.destroy();
    }
    private void update() {
        box.update();
    }
}

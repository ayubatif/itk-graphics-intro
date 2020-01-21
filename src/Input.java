import java.awt.event.*;

public class Input implements KeyListener {

    public static boolean W = false;
    public static boolean A = false;
    public static boolean S = false;
    public static boolean D = false;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keySwitch(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keySwitch(e, false);
    }

    public void keySwitch(KeyEvent e, boolean mode) {
        switch (e.getKeyChar()) {
            case 'w':
                W = mode;
                break;
            case 'a':
                A = mode;
                break;
            case 's':
                S = mode;
                break;
            case 'd':
                D = mode;
        }
    }

}

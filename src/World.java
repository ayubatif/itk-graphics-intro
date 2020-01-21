import javax.swing.*;
import java.awt.*;

public class World extends JPanel {

    public final int WIDTH, HEIGHT;
    public boolean running = false;

    public World(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;

        Dimension screenSize = new Dimension(WIDTH, HEIGHT);
        setPreferredSize(screenSize);
    }

    public void start() {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        repaint();
    }

}

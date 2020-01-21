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
        running = true;

        while(running) {
            try {
                float sleepTime = 1f/60 * 1000;
                update(sleepTime / 1000);
                repaint();
                Thread.sleep((int) sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    float x = 50;
    float y = 50;
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.CYAN);
        g.fillRect((int) x, (int) y, 50, 50);
    }

    public void update(float delta) {
        x += 200 * delta;
        y += 200 * delta;

        if(x > WIDTH) {
            x = -50;
        }
        if(y > HEIGHT) {
            y = -50;
        }
    }

}

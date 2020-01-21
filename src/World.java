import javax.swing.*;
import java.awt.*;

public class World extends JPanel {

    public static int WIDTH, HEIGHT;
    public boolean running = false;

    private Block block;

    public World(int WIDTH, int HEIGHT) {
        World.WIDTH = WIDTH;
        World.HEIGHT = HEIGHT;

        Dimension screenSize = new Dimension(WIDTH, HEIGHT);
        setPreferredSize(screenSize);

        block = new Block(50, 50, 100, Color.CYAN);
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

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        block.draw(g);
    }

    public void update(float delta) {
        block.update(delta);
    }

}

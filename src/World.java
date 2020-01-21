import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class World extends JPanel {

    private BufferedImage buffer;
    private Graphics g2;

    public static int WIDTH, HEIGHT;
    public boolean running = false;

    private Block block;

    private Snowflake[] snowflakes;

    public World(int WIDTH, int HEIGHT) {
        World.WIDTH = WIDTH;
        World.HEIGHT = HEIGHT;

        Dimension screenSize = new Dimension(WIDTH, HEIGHT);
        setPreferredSize(screenSize);

        buffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g2 = buffer.createGraphics();

        block = new Block(50, 50, 100, Color.CYAN);

        snowflakes = new Snowflake[100];
        for(int i = 0; i < snowflakes.length; i++) {
            snowflakes[i] = new Snowflake();
        }
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
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, WIDTH, HEIGHT);

        block.draw(g2);

        for(int i = 0; i < snowflakes.length; i++) {
            snowflakes[i].draw(g2);
        }

        g.drawImage(buffer, 0, 0, WIDTH, HEIGHT, null);
    }

    public void update(float delta) {
        block.update(delta);

        for(int i = 0; i < snowflakes.length; i++) {
            snowflakes[i].update(delta);
        }
    }

}

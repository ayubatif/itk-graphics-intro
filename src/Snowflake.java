import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Snowflake {

    private static BufferedImage image = null;

    private float x, y;

    public Snowflake() {
        if(image == null) {
            try {
                image = ImageIO.read(new File("src/snow.png"));
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Using circle as snowflake instead!");
                image = new BufferedImage(15, 15, BufferedImage.TYPE_INT_RGB);
                Graphics g = image.createGraphics();
                g.setColor(Color.WHITE);
                g.fillOval(2, 2, 11, 11);
            }
        }

        this.x = (float) (World.WIDTH * Math.random());
        this.y = (float) (World.HEIGHT * Math.random());
    }

    public void draw(Graphics g) {
        g.drawImage(image, (int) x, (int) y, null);
    }

    public void update(float delta) {
        y += 200 * delta;
        if(y > World.HEIGHT) {
            this.x = (float) (World.WIDTH * Math.random());
            y = -image.getHeight();
        }
    }

}

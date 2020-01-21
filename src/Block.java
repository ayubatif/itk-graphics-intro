import java.awt.*;

public class Block {

    private float x, y;
    private int size;
    private Color color;

    public Block(float x, float y, int size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect((int) x, (int) y, size, size);
    }

    public void update(float delta) {
        x += 200 * delta;
        y += 200 * delta;

        if(x > World.WIDTH) {
            x = -size;
        }
        if(y > World.HEIGHT) {
            y = -size;
        }
    }

}

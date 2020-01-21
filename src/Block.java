import java.awt.*;

public class Block {

    private float x, y;
    private float vx = 0;
    private float vy = 0;
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
        handleInput();

        x += vx * delta;
        y += vy * delta;

        if(x > World.WIDTH) {
            x = -size;
        }
        if(y > World.HEIGHT) {
            y = -size;
        }

        if(x < -size) {
            x = World.WIDTH;
        }
        if(y < -size) {
            y = World.HEIGHT;
        }
    }

    public void handleInput() {
        if(Input.W)
            vy = -200;
        else if(Input.S)
            vy = 200;
        else
            vy = 0;
        if(Input.A)
            vx = -200;
        else if(Input.D)
            vx = 200;
        else vx = 0;
    }

}

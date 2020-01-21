import javax.swing.*;

public class Window {

    public Window() {
        JFrame window = new JFrame("Very cool ITK graphics");
        World world = new World(800, 600);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        window.add(world);
        window.pack();
        window.setLocationRelativeTo(null);

        window.setVisible(true);

        world.start();
    }

    public static void main(String[] args) {
        Window window = new Window();
    }

}

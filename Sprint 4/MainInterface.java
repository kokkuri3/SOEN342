import javax.swing.*;
import java.awt.*;

public class MainInterface {
    public MainInterface() {
        JFrame frame = new JFrame("Main Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100, 100);
        frame.setIconImage(new ImageIcon(getClass().getResource("")).getImage());
        // Setting layout as null so we can manually set bounds of components
        frame.setLayout(new GridBagLayout());
        // Setting Visibility of frame as true
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        new LoginInterface();

    }
}

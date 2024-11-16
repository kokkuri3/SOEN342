import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdminInterface {
    public AdminInterface() {
        // admin interface that allows admin to view all users and their information
        JFrame frame = new JFrame("Admin Interface");
        frame.setSize(500, 400);
        frame.setIconImage(new ImageIcon(getClass().getResource("")).getImage());
        frame.setLayout(new GridBagLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel header = new JLabel("Admin Interface: ", SwingConstants.CENTER);
        header.setFont(new Font("Sans-Serif", Font.BOLD, 24));

        JLabel paragraph = new JLabel(
                "<html> <br> Here are all the users: <br></html>",
                SwingConstants.CENTER);

        // create a new panel with BoxLayout
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));

        // add items to panel
        panel.add(Box.createVerticalGlue());
        panel.add(header);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(paragraph);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(userPanel);
        panel.add(Box.createVerticalGlue());
        panel.add(Box.createRigidArea(new Dimension(0, 5)));

        // add the panel to frame
        frame.getContentPane().add(panel);
        // Setting Visibility of frame as true
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}

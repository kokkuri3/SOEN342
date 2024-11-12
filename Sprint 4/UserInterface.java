import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInterface {
    public UserInterface() {
        // user interface that allows user to view all offerings and enroll in them
        JFrame frame = new JFrame("User Interface");
        frame.setSize(500, 400);
        frame.setIconImage(new ImageIcon(getClass().getResource("")).getImage());
        frame.setLayout(new GridBagLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel header = new JLabel("User Interface: ", SwingConstants.CENTER);
        header.setFont(new Font("Sans-Serif", Font.BOLD, 24));

        JLabel paragraph = new JLabel(
                "<html> <br> Here are all the offerings: <br></html>",
                SwingConstants.CENTER);

        // create a new panel with BoxLayout
        JPanel offeringPanel = new JPanel();
        offeringPanel.setLayout(new BoxLayout(offeringPanel, BoxLayout.Y_AXIS));

        // add items to panel
        panel.add(Box.createVerticalGlue());
        panel.add(header);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(paragraph);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(offeringPanel);
        panel.add(Box.createVerticalGlue());
        panel.add(Box.createRigidArea(new Dimension(0, 5)));

        // add a button to go back to LoginInterface ON TOP LEFT OF PANEL
        JButton backButton = new JButton("Back");
        backButton.setBounds(0, 0, 100, 50);
        panel.add(backButton);

        // add the panel to frame
        frame.getContentPane().add(panel);
        // Setting Visibility of frame as true
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        backButton.addActionListener(e -> {
            // register button opens a new window
            frame.dispose();
            new LoginInterface();

        });
        // // read from file and display all offerings
        // try {
        // File myObj = new File("offerings.txt");
        // Scanner myReader = new Scanner(myObj);
        // while (myReader.hasNextLine()) {
        // String data = myReader.nextLine();
        // JLabel offering = new JLabel(data);
        // offeringPanel.add(offering);
        // }
        // myReader.close();
        // } catch (FileNotFoundException e) {
        // System.out.println("An error occurred.");
        // e.printStackTrace();
        // }
    }
}

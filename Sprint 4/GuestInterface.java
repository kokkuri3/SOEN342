
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GuestInterface {
    public GuestInterface() {
        // user interface that allows user to view all offerings and enroll in them
        JFrame frame = new JFrame("Guest Interface");
        frame.setSize(800, 800);
        frame.setIconImage(new ImageIcon(getClass().getResource("")).getImage());
        frame.setLayout(new GridBagLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel header = new JLabel("Guest Interface: ", SwingConstants.CENTER);
        header.setFont(new Font("Sans-Serif", Font.BOLD, 24));

        JLabel paragraph = new JLabel(
                "<html> <br> Here are all the lessons given by Instructors: <br></html>",
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

        // Display a list of all offerings in table format
        String[] columnNames = { "Instructor", "LessonType", "Capacity", "Location", "Start Time", "End Time", "Date" };
        Object[][] data = {
                // read from Sprint 4\\Lessons.txt for data

                { "John Doe", "Yoga", "10", "EV-Room A", "12PM", "3PM", "Sundays", "September 1st to November 30th" },
                { "Jane Smith", "Yoga", "20", "MB-Room 2", "6PM", "8PM", "Mondays", "January 5th to March 30th" },
                { "Alice Johnson", "Dance", "1", "LB-Room 1", "5PM", "7PM", "Wednesdays",
                        "February 1st to April 30th" },
                { "Bob Brown", "Swimming", "12", "EV-Pool", "4PM", "6PM", "Fridays", "March 1st to May 31st" },
                { "Charlie Davis", "Judo", "15", "EV-Room 7", "12PM", "3PM", "Sundays",
                        "September 1st to November 30th" },
                { "J", "Yoga", "20", "MB-Room 2", "6PM", "8PM", "Mondays", "January 5th to March 30th" }
        };
        // add to gui
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);

        JLabel paragraphInterested = new JLabel(
                "<html> <br> Intresested in a booking? Register/Log In! <br></html>",
                SwingConstants.CENTER);
        panel.add(paragraphInterested);
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

    }
}

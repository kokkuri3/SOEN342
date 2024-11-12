import javax.swing.*;
import java.awt.*;

//this opens when a button is clicked on the main interface

public class RegisterInterface {
    public RegisterInterface() {
        // registration form that asks user for name, age, email, phonenumber
        JFrame frame = new JFrame("Register");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setIconImage(new ImageIcon(getClass().getResource("")).getImage());
        // Setting layout as null so we can manually set bounds of components
        frame.setLayout(new GridBagLayout());

        // create a new panel with BoxLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // create header
        JLabel header = new JLabel("Registration: ", SwingConstants.CENTER);
        header.setFont(new Font("Sans-Serif", Font.BOLD, 24));

        // create paragraph
        JLabel paragraph = new JLabel(
                "<html> <br> Please fill out the following fields: <br></html>",
                SwingConstants.CENTER);
        // underage? enter name of guardian
        JLabel guardianLabel = new JLabel("Guardian Name: ");
        JTextField guardianName = new JTextField();
        // checkbox input for underage
        JCheckBox underageCheckBox = new JCheckBox("Underage? ");
        underageCheckBox.setBounds(100, 100, 50, 50);

        // name, age, email, phonenumber fields
        JTextField name = new JTextField();
        JTextField age = new JTextField();
        JTextField email = new JTextField();
        JTextField phonenumber = new JTextField();
        JLabel nameLabel = new JLabel("Name: ");
        JLabel ageLabel = new JLabel("Age: ");
        JLabel emailLabel = new JLabel("Email: ");
        JLabel phonenumberLabel = new JLabel("Phone Number: ");
        JButton registerButton = new JButton("Register");

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalGlue());
        panel.add(header);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(paragraph);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(nameLabel);
        panel.add(name);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(ageLabel);
        panel.add(age);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(emailLabel);
        panel.add(email);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(phonenumberLabel);
        panel.add(phonenumber);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(guardianLabel);
        panel.add(guardianName);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(underageCheckBox);
        panel.add(registerButton);
        panel.add(Box.createVerticalGlue());
        panel.add(Box.createRigidArea(new Dimension(0, 5)));

        frame.add(panel);
        frame.setVisible(true);
    }
}

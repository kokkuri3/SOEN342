import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;

//this opens when a button is clicked on the main interface

public class RegisterInterface {

    public RegisterInterface() {

        // registration form that asks user for name, age, email, phonenumber
        JFrame frame = new JFrame("Register");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // dynamic frame size
        frame.setSize(600, 500);
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
        JPasswordField password = new JPasswordField();
        JPasswordField confirmPassword = new JPasswordField();
        JLabel nameLabel = new JLabel("Name: ");
        JLabel ageLabel = new JLabel("Age: ");
        JLabel emailLabel = new JLabel("Email: ");
        JLabel phonenumberLabel = new JLabel("Phone Number: ");
        JLabel passwordLabel = new JLabel("Password: ");
        JLabel confirmPasswordLabel = new JLabel("Confirm Password: ");
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
        panel.add(passwordLabel);
        panel.add(password);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(confirmPasswordLabel);
        panel.add(confirmPassword);
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

        // when user registers, information is saved to Clients.txt in ; separated
        // format
        registerButton.addActionListener(e -> {
            if (name.getText().isEmpty() || age.getText().isEmpty() || email.getText().isEmpty()
                    || phonenumber.getText().isEmpty() || password.getPassword().length == 0) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (!(String.valueOf(password.getPassword()).equals(String.valueOf(confirmPassword.getPassword())))) {
                    JOptionPane.showMessageDialog(frame, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // if underage, guardian name must be filled
                if (underageCheckBox.isSelected() && guardianName.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in guardian name", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } // if age is less than 18, guardian name must be filled
                else if (Integer.parseInt(age.getText()) < 18 && guardianName.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in guardian name", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    // if all fields are filled, save to file
                    String data = name.getText() + ";" + age.getText() + ";" + email.getText() + ";"
                            + phonenumber.getText();
                    if (underageCheckBox.isSelected()) {
                        data += ";" + guardianName.getText();
                    }
                    try {
                        FileWriter fw = new FileWriter("Sprint 4\\Clients.txt", true);
                        System.out.println(data);
                        fw.write(data + "\n");
                        fw.close();
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                    try {
                        FileWriter fw = new FileWriter("Sprint 4\\DB.txt", true);
                        fw.write(email.getText() + ";" + String.valueOf(password.getPassword()) + "\n");
                        fw.close();
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                    JOptionPane.showMessageDialog(frame, "Registration successful", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    new LoginInterface();
                }
            }

        });// action listener

    }
}

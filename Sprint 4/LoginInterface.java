import javax.swing.*;
import java.awt.*;

public class LoginInterface {
    public LoginInterface() {
        JFrame frame = new JFrame("Login Interface");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setIconImage(new ImageIcon(getClass().getResource("")).getImage());
        // Setting layout as null so we can manually set bounds of components
        frame.setLayout(new GridBagLayout());

        // create a new panel with BoxLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // create header
        JLabel header = new JLabel("Lesson Booker", SwingConstants.CENTER);
        header.setFont(new Font("Sans-Serif", Font.BOLD, 24));

        // create paragraph
        JLabel paragraph = new JLabel(
                "<html> <br> Welcome! Sign in or Register below: <br></html>",
                SwingConstants.CENTER);

        // username and password fields
        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();
        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        // checkbox input for admin
        JCheckBox adminCheckBox = new JCheckBox("Admin? ");
        adminCheckBox.setBounds(100, 100, 50, 50);
        panel.add(adminCheckBox);

        // add items to panel
        panel.add(Box.createVerticalGlue());
        panel.add(header);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(paragraph);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(usernameLabel);
        panel.add(username);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(passwordLabel);
        panel.add(password);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(loginButton);
        panel.add(registerButton);
        panel.add(Box.createVerticalGlue());
        panel.add(Box.createRigidArea(new Dimension(0, 5)));

        // add the panel to frame
        frame.getContentPane().add(panel);
        // Setting Visibility of frame as true
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        loginButton.addActionListener(e -> {
            // if either fields are empty, clicking either button will show an error message
            if (username.getText().isEmpty() || password.getPassword().length == 0) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // if username and password are correct, open an interface
                if (username.getText().equals("admin") && String.valueOf(password.getPassword()).equals("admin")) {
                    // if admin checkbox is checked, open admin interface
                    if (adminCheckBox.isSelected()) {
                        new AdminInterface();
                    } else {
                        // error message if credentials are not correct
                        JOptionPane.showMessageDialog(frame, "Incorrect Credentials", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    // if username and password are correct, open user interface
                    if (username.getText().equals("user") && String.valueOf(password.getPassword()).equals("user")) {
                        // kill login screen and open user interface
                        frame.dispose();
                        new UserInterface();
                    } else {
                        // error message if credentials are not correct
                        JOptionPane.showMessageDialog(frame, "Incorrect Credentials", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        registerButton.addActionListener(e -> {
            // register button opens a new window
            new RegisterInterface();

        });

    }
}

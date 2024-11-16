import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

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
        JButton guestButton = new JButton("Continue as Guest");

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
        panel.add(guestButton);

        // add the panel to frame
        frame.getContentPane().add(panel);
        // Setting Visibility of frame as true
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        loginButton.addActionListener(e -> {

            try {
                Scanner myReader = new Scanner(new File("Sprint 4\\DB.txt"));
                boolean found = false;
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String[] credentials = data.split(";");
                    if (username.getText().equals(credentials[0])
                            && String.valueOf(password.getPassword()).equals(credentials[1])) {
                        found = true;

                        // if admin checkbox is checked, open admin interface
                        if (adminCheckBox.isSelected()) {
                            frame.dispose();
                            new AdminInterface();
                        } else {
                            frame.dispose();
                            new UserInterface();
                        }
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password", "Login Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                myReader.close();
                myReader.close();
            } catch (FileNotFoundException e1) {
                System.out.println("An error occurred.");
                e1.printStackTrace();
            }
        });

        registerButton.addActionListener(e -> {
            // register button opens a new window
            new RegisterInterface();
        });

        guestButton.addActionListener(e -> {
            // guest button opens a new window
            frame.dispose();
            new GuestInterface();
        });
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Main Page");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton studentButton = new JButton("Student Space");
        JButton adminButton = new JButton("Admin Space");

        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current frame
                new StudentFrame();
            }
        });

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current frame
                new AdminLoginPage();
            }
        });

        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(createPanelWithBackground(studentButton, Color.GREEN)); // Set background color for student button
        panel.add(createPanelWithBackground(adminButton, Color.BLUE));   // Set background color for admin button

        add(panel);

        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    private JPanel createPanelWithBackground(Component component, Color color) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(color);
        panel.add(component, BorderLayout.CENTER);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}

class StudentFrame extends JFrame {
    public StudentFrame() {
        setTitle("Student Page");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField nameField = new JTextField(20);
        JTextField rollNumberField = new JTextField(20);
        JButton submitButton = new JButton("Submit");
        JButton backButton = new JButton("Back");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic to process student data
                // For now, we'll just display a message
                JOptionPane.showMessageDialog(null, "Student data submitted!");
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current frame
                new MainFrame(); // Open the main page
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Name: "));
        panel.add(nameField);
        panel.add(new JLabel("Roll Number: "));
        panel.add(rollNumberField);
        panel.add(submitButton);
        panel.add(backButton);

        add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class AdminLoginPage extends JFrame {
    public AdminLoginPage() {
        setTitle("Admin Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        JButton backButton = new JButton("Back");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic to validate admin credentials
                // For now, we'll just display a message
                JOptionPane.showMessageDialog(null, "Admin login successful!");
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current frame
                new MainFrame(); // Open the main page
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Username: "));
        panel.add(usernameField);
        panel.add(new JLabel("Password: "));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(backButton);

        add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

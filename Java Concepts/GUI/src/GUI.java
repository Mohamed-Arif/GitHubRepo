import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI implements ActionListener
{
	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton loginButton;
	private static JLabel message;	

    public static void main (String [] args)
    {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(panel);

        panel.setLayout(null);

        userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);       

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.addActionListener(new GUI());
        panel.add(loginButton);

        message = new JLabel("");
        message.setBounds(10, 110, 300, 25);
        panel.add(message);
        
        frame.setVisible(true);
    
    }
    
   
	@Override
	public void actionPerformed(ActionEvent e) {
		String username = userText.getText();
		String password = passwordText.getText();
		
		if(username.equals("Arif") && password.equals("p@ssw0rd"))
		{
			message.setText("Login Successful!");
		} else
		{
			message.setText("Check Login Details");
		}
		
	}
    
}
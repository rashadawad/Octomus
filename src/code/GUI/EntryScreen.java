package code.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class EntryScreen extends JPanel {

	protected JLabel userNameLabel;
	protected JTextField username;
	protected JLabel passwordLabel;
	protected JPasswordField password;
	protected JButton login;
	protected MediaTracker tracker;
	protected Image pic, containerPic;

	
	public EntryScreen() {

		super();
		userNameLabel = new JLabel("Enter username :");
		username = new JTextField("");
		passwordLabel = new JLabel("Password");
		password = new JPasswordField("");
		login = new JButton("Log in");

		login.setBorderPainted(true);
		Color loginButtonBg = new Color(0, 153, 153);
		login.setBackground(loginButtonBg);
		login.setForeground(Color.white);

		// gray #F2F2F2
//		Color textFieldBg = new Color(243, 243, 243);
		Color textFieldBg = new Color(204, 255, 229);
		username.setBackground(textFieldBg);
		password.setBackground(textFieldBg);

		userNameLabel.setForeground(Color.blue);
		passwordLabel.setForeground(Color.blue);

		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JButton b = (JButton) e.getSource();
				b.setText("Clicked");
			}
		});

		this.add(userNameLabel);
		this.add(username);
		this.add(passwordLabel);
		this.add(password);
		this.add(login);

		this.setLayout(null);
		//userNameLabel.setBounds(130, 400, 100, 15);
		username.setBounds(130, 460, 120, 20);
		// passwordLabel.setBounds(140, 470, 100, 15);
		password.setBounds(130, 510, 120, 20);
		login.setBounds(150, 550, 80, 20);
		// repaint();
	}

	

	public void paint(Graphics g) {

		

		tracker=new MediaTracker(this);
		containerPic = createImage(376, 682);

		pic = getToolkit().getImage("C:\\Users\\Areen\\Desktop\\logo.jpg");
		

		 tracker.addImage(pic, 0);

		 try {
			tracker.waitForID(0);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		containerPic.getGraphics().drawImage(pic, 0, 0, null);
		this.setSize(376, 682);
		g.drawImage(containerPic, 0, 0, null);
//		this.setLayout(null);
//		userNameLabel.setBounds(130, 400, 100, 15);
		g.drawString("Enter username: ", 140, 450);
		//userNameLabel.repaint(130, 440, 100, 15);//paintImmediately(130, 440, 100, 15);//paint(g);
		username.repaint();
		//passwordLabel.repaint();
		g.drawString("Enter password: ", 140, 500);
		password.repaint();
		login.repaint();
	}
	/**
	 * Method for checking the details entered by the user.
	 * @return  true in case of correct details other false.
	 */
	public boolean confirmEntry()
	{
		if(username.getText().equals("octomus") && password.getText().equals("octomus"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public void wrongConfirmationResult()
	{
		Color backgroundColor=new Color(252,186,186);
		username.setBackground(backgroundColor);
		password.setBackground(backgroundColor);
		
		this.paintAll(this.getGraphics());
	}
	public JButton getLogin()
	{
		return login;
	}
}

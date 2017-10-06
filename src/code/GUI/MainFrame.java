package code.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;



public class MainFrame extends JFrame {

	protected EntryScreen entryPanel;
	
	protected SecondScreen secondScreen;
	
	
	public MainFrame()
	{
		super("Octomus");
		entryPanel = new EntryScreen();
		setActionlistnerToLoginButton();
		this.setLayout(null);
		setBounds(500, 10, 380, 720);
		this.getContentPane().add(entryPanel);
		entryPanel.setBounds(0, 0, 380, 709);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setFocusable(true);
	}
	
	public void setActionlistnerToLoginButton(){
		entryPanel.getLogin().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JButton b=(JButton)e.getSource();
				b.setText("Clicked");
				moveToSecondScreen();
				
			}

			
		});
	}
	
	
	private void moveToSecondScreen()
	{
		System.out.println("move To Second Screen");
		this.getContentPane().removeAll();
		
		secondScreen = new SecondScreen();
		this.getContentPane().add(secondScreen);
		
		this.setLayout(null);
		this.secondScreen.setBounds(0, 0, 376, 500);
		this.getContentPane().paintAll(this.getContentPane().getGraphics());
		
	}
	
	
	public static void main(String[] args)  
	{

		new MainFrame();
	}
}
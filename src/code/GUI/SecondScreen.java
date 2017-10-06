package code.GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class SecondScreen extends JPanel
{

	
	protected Image pic, containerPic;
	protected MediaTracker tracker;

	public SecondScreen() {

		super();
		add(new JButton("Second screen"));
		JToolBar toolBar = new JToolBar("options");
		this.add(toolBar);

		paintAll(this.getGraphics());
	}

	

	public void paint(Graphics g) {

		

		tracker =new MediaTracker(this);
		containerPic = createImage(376, 404);
		pic = getToolkit().getImage("C:\\Users\\Areen\\Desktop\\icons.jpg");
		containerPic.getGraphics().drawImage(pic, 0, 0, null);
		tracker.addImage(pic, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		this.setSize(376, 550);
		g.drawImage(containerPic, 0, 150, null);
		
		System.out.println("Second screen paint finished");
	}

	
}

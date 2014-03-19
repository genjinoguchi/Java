import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Animation{
	MyPanel p;
	Container background;

	public void go(){
		JFrame frame = new JFrame("Animation");
		frame.setSize(500,500);
		frame.setLocation(30,30);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());

		p = new MyPanel();
		background = frame.getContentPane();
		background.add(BorderLayout.CENTER, p);
		p.repaint();
		frame.repaint();
	}

	public static class MyPanel extends JPanel{

		public void paintComponent(Graphics g){
			Graphics2D g2 = (Graphics2D)g;

			g2.setColor(Color.green);
			g2.fillRect(0,0,500,500);
		}

	}


	public static void main(String[] args) {
		Animation a = new Animation();
		a.go();
	}
		

}
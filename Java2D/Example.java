import javax.swing.*;
import java.awt.*;

public class Example {
	int x = 70, y=70;

	public static void main(String[] args) {
		Example gui = new Example ();
		gui.go();
	}

	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyDrawPanel drawPanel = new MyDrawPanel();

		frame.getContentPane().add(drawPanel);
		frame.setSize(300,300);
		frame.setVisible(true);

		for( int i=0;i<130;i++){
			x++;
			y++;
			drawPanel.repaint();

			try{
				Thread.sleep(50);
			}catch(Exception e){}
		}
	}

	class MyDrawPanel extends JPanel{
		public void paintComponent(Graphics g){
			Graphics2D g2 = (Graphics2D)g;

			g.setColor(Color.green);
			g.fillOval(x,y,40,40);
		}
	}

}
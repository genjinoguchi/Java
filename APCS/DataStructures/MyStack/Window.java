import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window{
	private JFrame frame;
	private Container background;
	private DrawPanel panel;
	private LetteringLabel lettering;

	public Window() {
		init();



	}

	public void init() {
		frame = new JFrame();
		frame.setTitle("Notepad");
		frame.setSize(800,600);
		frame.setResizable(true);
		frame.setLocation(50,50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		background = frame.getContentPane();

		panel = new DrawPanel();
		background.add(panel,BorderLayout.CENTER);


	}

	private class DrawPanel extends JPanel implements KeyListener {
		public DrawPanel() {

		}

		public void keyReleased(KeyEvent e) {

		}
		public void keyTyped(KeyEvent e){

		}
		public void keyPressed(KeyEvent e){

		}
	}

	



}
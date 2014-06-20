import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements KeyListener{
	private Container background;
	private DrawPanel panel;
	private LetteringLabel lettering;

	public Window() {
		init();
		addKeyListener(this);
	}

	public void init() {
		setTitle("Notepad");
		setSize(800,600);
		setResizable(true);
		setLocation(50,50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setVisible(true);
		background = getContentPane();

		panel = new DrawPanel();
		background.add(panel,BorderLayout.CENTER);
	}

	public Window getSelf(){
		return this;
	}

	public void keyReleased(KeyEvent e) {
		System.out.println(e.getKeyCode());
	}
	public void keyTyped(KeyEvent e){
		System.out.println(e.getKeyCode());
	}
	public void keyPressed(KeyEvent e){
		System.out.println(e.getKeyCode());
	}

}
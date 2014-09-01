//To do : maybe turn everything to static, maybe not.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent.*;

public class Window extends JFrame implements KeyListener{
	private Container background;
	private DrawPanel panel;
	private LetteringLabel lettering;
	private JLabel testLabel;
	private int cursorLocation;
	private boolean keyPressed;

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

		testLabel = new JLabel("Hello world");
		panel.add(testLabel);

		cursorLocation = 1;
	}

	public void displaceCursor(int i){
		cursorLocation += i;
	}
	public void placeCursor(int i){
		cursorLocation = i;
	}
	public int getCursorLocation(){
		return cursorLocation;
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_CONTROL ||
			e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
			keyPressed = false;
		}
	}
	public void keyTyped(KeyEvent e){
		if(!keyPressed){
			ActionManager.processInput(String.valueOf(e.getKeyChar()),cursorLocation-1);
			cursorLocation++;
		}
		//testLabel.set(ActionManager.processActions());
		System.out.println(ActionManager.processActions());
	}
	public void keyPressed(KeyEvent e){

		if(e.isControlDown()){
			keyPressed = true;
			if (e.getKeyCode() == KeyEvent.VK_Z) {
				ActionManager.undo();
			}
			if (e.getKeyCode() == KeyEvent.VK_Y) {
				ActionManager.redo();
			}
		}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
			keyPressed = true;
			ActionManager.insertUndoableAction(cursorLocation-2,true,"");
			if(cursorLocation>1){
				cursorLocation--;
			}
		}
	}

}
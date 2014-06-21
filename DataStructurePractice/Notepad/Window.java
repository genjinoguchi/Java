//To do : maybe turn everything to static, maybe not.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent.*;

public class Window extends JFrame implements KeyListener{
	private Container background;
	private DrawPanel panel;
	private LetteringLabel lettering;
	private int cursorLocation;

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
		if(e.getKeyCode()==KeyEvent.VK_CONTROL){
			ActionManager.toggleCtrl(false);
		}
	}
	public void keyTyped(KeyEvent e){
		ActionManager.processInput(Character.toString(e.getKeyChar()),cursorLocation);
	}
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_CONTROL){
			ActionManager.toggleCtrl(true);
		}
		if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
			ActionManager.insertUndoableAction(cursorLocation-1,true,"");
			displaceCursor(-2);
		}
	}

	/*
	Suggestion from Stackoverflow
	public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_C) {

                JOptionPane.showMessageDialog(this, "ctrl + c");

            } else if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_X) {

                JOptionPane.showMessageDialog(this, "ctrl + x");

            } else if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {

                JOptionPane.showMessageDialog(this, "ctrl + v");

            }
        }
        */

}
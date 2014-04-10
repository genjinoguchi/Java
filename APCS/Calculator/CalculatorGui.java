import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGui implements ActionListener{
	private JFrame frame = new JFrame("Welcome to reverse polish calculator");
	private Container background;
	private static int sizex = 500,sizey = 150;
	private JLabel display = new JLabel("0.000");
	private String input = "";
	private JButton[] operations = {
		new JButton("+"),
		new JButton("-"),
		new JButton("*"),
		new JButton("/"),
		new JButton("0"),
		new JButton("1"),
		new JButton("2"),
		new JButton("3"),
		new JButton("4"),
		new JButton("5"),
		new JButton("6"),
		new JButton("7"),
		new JButton("8"),
		new JButton("9"),
		new JButton("Enter"),
					};

	public void gui(){
		frame.setSize(sizex, sizey);
		frame.setLocation(50,50);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		background = frame.getContentPane();
		background.setLayout(new GridLayout(0,4));

		background.add(display);
		for(int x=0;x<operations.length;x++){
			background.add(operations[x]);
			operations[x].addActionListener(this);
		}
	}

	public void actionPerformed(ActionEvent e){
		for(int x=0;x<operations.length;x++){
			if(e.getSource()==operations[x]){
				
			}
		}
	}

	public static void main(String[] args) {
		CalculatorGui cg = new CalculatorGui();
		cg.gui();
	}
	
}
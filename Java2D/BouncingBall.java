import javax.swing.*;
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.event.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class BouncingBall extends JFrame{

	private Container background;
	private JPanel myPanel;
	private static int w=500,h=500;

	private static boolean test = false;

	public static MyPanel p;

	public BouncingBall(String s){
		super(s);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(700,700);
		this.setLocation(50,10);

		p = new MyPanel();

		background = this.getContentPane();
		background.add(p, BorderLayout.CENTER);
		background.add(new SwitchButton(), BorderLayout.WEST);

		this.setVisible(true);

	}

	public static class MyPanel extends JPanel{
		private static int radius, xpos, ypos, gravity, speed;

		private static BufferedImage img;

		public MyPanel(){
			super();
			radius = 50;
			xpos = 50;
			ypos = 50;
		}

		public MyPanel(int r, int px, int py, int g){
			super();
			radius = r;
			xpos = px;
			ypos = py;
			gravity = g;
			bounce();
		}

		public void paint(Graphics g){
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON)
			;  /* Just take this for granted for now.*/
			//Shape rect = new Rectangle2D.Float(10,20,120,150);
			//retrieveImage("blackKing.png");
			//g.drawImage(img,img.getWidth(null),img.getHeight(null),null);

			//g.setColor(Color.orange);
			//g.fillRect(0,0,300,300);
			g.setColor(Color.red);
			/*
			if (ypos<-400){
				speed = -speed;
			}
			speed -= gravity;
			ypos += speed;
			*/
			g.fillOval(xpos-radius, ypos-radius, xpos+radius, ypos+radius );
			if(BouncingBall.test){
				g.fillOval(300,300, 400,400);
			}

		}

		public static void retrieveImage(String name){
			try{
				img = ImageIO.read(new File(name));
			}catch(IOException e){

				e.printStackTrace();
			}
		}

		public Dimension getPreferredSize(){
			if(img==null){
				return new Dimension(500,500);
			}else{
				return new Dimension(img.getWidth(null), img.getHeight(null));
			}
		}

		public void bounce(){
			while(1==1){
				try{
					Thread.sleep(40);
				}catch(Exception e){}
				repaint();
			}
		}
	}

	public static class SwitchButton extends JButton implements ActionListener{


		public void actionPerformed(ActionEvent e){
			BouncingBall.test = !BouncingBall.test;
			BouncingBall.p.repaint();
		}

	}


	public static void main(String[]args){
		BouncingBall frame = new BouncingBall("Bouncing Ball");
		frame.pack();
		frame.setVisible(true);

	}

}
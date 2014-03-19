import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BouncingBall1 implements ActionListener{
	private double bx, by;
	private int sizex=1500, sizey=800;
	private double g=.05;
	private Container background;
	Ball redBall, greenBall;
	boolean inRange = true;

	public BouncingBall1(double bx, double by){
		this.bx = bx;
		this.by = by;
		
	}

	public void go(){
		JFrame frame = new JFrame("Bouncing Ball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(sizex,sizey);
		frame.setVisible(true);
		frame.setLocation(50,50);

		redBall = new Ball(Color.red);
		greenBall = new Ball(Color.green);
		redBall.speedx = 3;
		greenBall.speedx = -5;

		background = frame.getContentPane();
		background.add(BorderLayout.CENTER, redBall);
		//background.add(BorderLayout.CENTER, greenBall);

		while(1==1){

			try{
				Thread.sleep(3);
			}catch(Exception e){}
			bounce(redBall);
		}
	}

	public void bounce(Ball b){

		by+=b.speedy+0.03;
		bx+=b.speedx;
		b.speedy += g;
		if((by>= 750 || by<=50) && inRange){
			b.speedy *= -1;
			inRange = false;
		}
		else{
			inRange = true;
		}
		if(bx>=1450 || bx<=50){
			b.speedx *= -1;
		}

		b.repaint();

		//redBall.speed+=0.5;
	}

	public void actionPerformed(ActionEvent e){}

	class Ball extends JPanel{
		Color color;
		double speedy, speedx;

		public Ball(Color c){
			color = c;
			setOpaque(true);
		}
		@Override
		public void paintComponent(Graphics g){
			int red = (int) (Math.random() * 255);
			int green = (int) (Math.random() * 255);
			int blue = (int) (Math.random() * 255);

			//super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;

			g2.setColor(new Color(red, green, blue));
			g2.fillOval((int)Math.round(bx),(int)Math.round(by),10,10);
		}
	}

	public static void main(String[] args) {
		BouncingBall1 frame = new BouncingBall1(250,250);
		frame.go();

	}



}
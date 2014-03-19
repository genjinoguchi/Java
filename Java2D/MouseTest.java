import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseTest{

	MouseTestPanel p;
	Container background;
	private final int h=400,L=400;

	public void go(){
		JFrame frame = new JFrame("Mouse Tester");
		frame.setSize(h,L);
		frame.setLocation(20,20);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		background = frame.getContentPane();

		p = new MouseTestPanel();
		background.add(BorderLayout.CENTER, p);

		frame.setVisible(true);

		p.drawRectangle(50);
		runDelay(50);
		p.drawRectangle(60);runDelay(50);
		p.drawRectangle(70);runDelay(50);
		p.drawRectangle(80);runDelay(50);
		p.drawRectangle(90);runDelay(50);
		p.drawRectangle(100);runDelay(50);
		p.drawRectangle(110);runDelay(50);
		p.drawRectangle(120);runDelay(50);
		p.drawRectangle(130);

	}

	public static void runDelay(int millis){
		try{
			Thread.sleep(millis);
		}catch(Exception e){};
	}

	private class MouseTestPanel extends JPanel implements MouseListener{
		BlankArea blankArea;
		private int px;

		public MouseTestPanel(){
			super();
			addMouseListener(this);
			//blankArea = new blankArea();
		}

		
		public void mousePressed(MouseEvent e) {
			runAnimation();
	    }

	    public void mouseReleased(MouseEvent e) {
	    }

	    public void mouseEntered(MouseEvent e) {
	    }

	    public void mouseExited(MouseEvent e) {
	    }

	    public void mouseClicked(MouseEvent e) {}
	    

	    public void runAnimation(){
	    	
	    	for(int x=0;x<200;x=x+2){
	    		drawRectangle(x);
	    		runDelay(20);
	    		System.out.println(x);
	    	}
	    }

	    public void drawRectangle(int x){
	    	px = x;
	    	super.repaint();

	    }

	    public void paintComponent(Graphics g){
	    	Graphics2D g2 = (Graphics2D)g;

	    	g2.setColor(Color.blue);
	    	g2.fillRect(0,0,L,h);
	    	g2.setColor(Color.green);
	    	g2.fillRect(0,0,px,h);

	    }

	}

	class BlankArea extends JLabel {
	    Dimension minSize = new Dimension(100, 50);
	 
	    public BlankArea(Color color) {
	        setBackground(color);
	        setOpaque(true);
	        setBorder(BorderFactory.createLineBorder(Color.black));
	    }
	 
	    public Dimension getMinimumSize() {
	        return minSize;
	    }
	 
	    public Dimension getPreferredSize() {
	        return minSize;
	    }
	}

	public static void main(String[] args) {
		MouseTest mt = new MouseTest();
		mt.go();
	}

}
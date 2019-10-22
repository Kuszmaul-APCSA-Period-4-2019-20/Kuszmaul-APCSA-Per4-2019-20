package hivolts;
import java.awt.*;  
import java.awt.event.*;  
import java.util.concurrent.ThreadLocalRandom;

public class keylistener extends Frame implements KeyListener{  

	/* Setting up output label box */
	/* https://www.javatpoint.com/java-keylistener */
	Label l;  
	TextArea area;  

	keylistener(){  

		l=new Label();  
		l.setBounds(20,50,200,20);  
		area=new TextArea();  
		area.setBounds(20,80,300, 300);  
		area.addKeyListener(this);  

		add(l);add(area);  
		setSize(400,400);  
		setLayout(null);  
		setVisible(true);  
	}  

	/* setting up global movement variable */
	//nextInt is normally exclusive of the top value,
	//so add 1 to make it inclusive
	//*50 to ensure that it is a multiple of 50
	static int randomNumx = (ThreadLocalRandom.current().nextInt(1, 10 + 1))*50;
	static int randomNumy = (ThreadLocalRandom.current().nextInt(1, 10 + 1))*50+30;
	
	public static int x = randomNumx;
	public static int y = randomNumy;
	public static int jumpstatus = 0;
	gameplay gameplay = new gameplay();

	//keypress detection | x values for movement: 1 is up, -1 is down, 2 is right, -2 is left, 0 is nonmoving
	public void keyPressed(KeyEvent e) { 

		l.setText("Key Pressed");

		int key = e.getKeyCode();
		//below is arrow key movement keyscan
		if (key == KeyEvent.VK_LEFT) {
			x -= 50;
			l.setText("left pressed " + x);
		}

		if (key == KeyEvent.VK_RIGHT) {
			x += 50;
			l.setText("right pressed " + x);
		}

		if (key == KeyEvent.VK_UP) {
			y -= 50;
			l.setText("up pressed " + y);
		}

		if (key == KeyEvent.VK_DOWN) {
			y += 50;
			l.setText("down pressed " + y);
		}
		//below is jumping keyscan
		if (key == KeyEvent.VK_J) {
			int[] jump = gameplay.jumpCoords();
			keylistener.x = jump[0];
			keylistener.y = jump[1];
			l.setText("JUMPING... ");
		}
		//below is letter movement keyscan
		if (key == KeyEvent.VK_A) {
			x -= 50;
			l.setText("A pressed " + x);
		}
		if (key == KeyEvent.VK_D) {
			x += 50;
			l.setText("D pressed " + x);
		}
		if (key == KeyEvent.VK_W) {
			y -= 50;
			l.setText("W pressed " + y);
		}
		if (key == KeyEvent.VK_X) {
			y += 50;
			l.setText("X pressed " + y);
		}
		//below is diagonal movement keyscan
		if (key == KeyEvent.VK_Q) {
			x -= 50;
			y-= 50;
			l.setText("Q pressed " + x + " " + y);
		}
		if (key == KeyEvent.VK_E) {
			x += 50;
			y-= 50;
			l.setText("E pressed " + x + " " + y);
		}
		if (key == KeyEvent.VK_Z) {
			x -= 50;
			y+= 50;
			l.setText("Z pressed " + x + " " + y);
		}
		if (key == KeyEvent.VK_C) {
			x += 50;
			y+= 50;
			l.setText("C pressed " + x + " " + y);
		}
		//below is sit still keyscan
		if (key == KeyEvent.VK_S) {
			//do something | move to next turn
		}
	}  

	public void keyReleased(KeyEvent e) {  
		l.setText("Player Released @ x: " + x + " y: " + y);
		jumpstatus = 0;
		//x=0;
		//l.setText(Integer.toString(x));
	}  

	//doesn't work for some reason
	public void keyTyped(KeyEvent e) {  
		int key = e.getKeyCode();

		
	}  

	public static void main(String[] args) {  
		new keylistener();  
	}  

	/*
    public static int returnvalues(KeyEvent x) {
    	keylistener y = new keylistener();
    	y.keyPressed(x);
    	y.l.setText("x=1");
    }
	 */

}  
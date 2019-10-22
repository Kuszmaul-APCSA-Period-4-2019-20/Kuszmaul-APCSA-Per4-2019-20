package hivolts;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Board extends JFrame implements ActionListener{

	public Board () {
		init();
	}

	//initial frame size
	public void init() {
		setSize(600, 630);
		setBackground(Color.WHITE);
		//actionPerformed(null);
		//repaint(keylistener.x, keylistener.y, 50, 50);
		refreshScreen();
	}

	//random stuff that goes in class body, its put here so that it runs after init
	private final Color FENCE = new Color(0xd6d1c8);
	//below is fence setup
	gameplay gameplay = new gameplay();
	int[] fencexcords = gameplay.fenceCoords("xcord");
	int[] fenceycords = gameplay.fenceCoords("ycord");
	//System.out.println("board class xcord: " + Arrays.toString(xcords));
	//System.out.println("board class ycord: " + Arrays.toString(ycords));
	ArrayList<Integer> mihox = gameplay.mihoCoords("mihox");
	ArrayList<Integer> mihoy = gameplay.mihoCoords("mihoy");
	
	int numbermihoalive = 12;
	int gamestatus = 0;
	//------------------------------------------------------------------------------

	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0,30,600,600);
		g.setColor(Color.white);
		for(int i = 0; i < 12; i++){
			for(int m = 0; m < 12; m ++){
				g.drawRect((i)* 50, (m)*50+30, 50,50);
			}
		}

		//below is fence setup
		g.setColor(Color.YELLOW);
		for(int i = 0; i < 12; i++) {
			g.fillRect(i*50, 30, 50, 50);
		}
		for(int i = 0; i < 12; i++) {
			g.fillRect(i*50, 580, 50, 50);
		}
		for(int i = 1; i < 11; i++) {
			g.fillRect(0, i*50+30, 50, 50);
		}
		for(int i = 1; i < 11; i++) {
			g.fillRect(550, i*50+30, 50, 50);
		}

		//below is player setup
		g.setColor(Color.RED);
		g.fillRect(keylistener.x,keylistener.y,50,50);

		//below is debug to check if paint is updating
		//System.out.println(2);

		//below is inside fence setup
		g.setColor(Color.YELLOW);
		for(int i = 0; i < 20; i++) {
			g.fillRect(fencexcords[i], fenceycords[i], 50, 50);
		}

		//below is miho setup
		g.setColor(Color.BLUE);
		for(int i = 0; i < numbermihoalive; i++) {
			g.fillRect((int)mihox.get(i), (int)mihoy.get(i), 50, 50);
		}
		//System.out.println("miho xcord: " + Arrays.toString(mihox));
		//System.out.println("miho ycord: " + Arrays.toString(mihoy));

		//below is check to see if the player got nae nae'd
		if(gamestatus == 1) {
			g.setColor(Color.BLACK);
			g.fillRect(0,30,600,600);
			keylistener keylistener = new keylistener();
			keylistener.l.setText("YOU LOSE");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

	Timer timer;
	public void refreshScreen() {
		timer = new Timer(0, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();

				//checks for if player hits side fence
				if(keylistener.x>500 || keylistener.x<50) {
					gamestatus = 1;
					timer.stop();
				}
				if(keylistener.y>530 || keylistener.y<80) {
					gamestatus = 1;
					timer.stop();
				}

				//checks for if player hits gameplay fence
				for(int i=0; i<20; i++) {
					for(int u=0; u<20; u++) {
						if(keylistener.x == fencexcords[i] && keylistener.y == fenceycords[i]) {
							gamestatus = 1;
							timer.stop();
						}
					}
				}
				
				//checks to see if it should jump the player
				/*
				if(keylistener.jumpstatus == 1) {
					int[] jump = gameplay.jumpCoords();
					keylistener.x = jump[0];
					keylistener.y = jump[1];
				}
				*/
				//------------------------------------------
				
				//checks to see if player got nae nae'd by miho
				for(int i=0; i<12; i++) {
					if(mihox.get(i) == keylistener.x && mihoy.get(i) == keylistener.y) {
						gamestatus = 1;
						timer.stop();
					}
				}
				
				//checks to see if miho got nae nae'd by fence
				for(int i=0; i<12; i++) {
					if(mihox.get(i) == fencexcords[i] && mihoy.get(i) == fenceycords[i]) {
						System.out.println("Miho at X: " + mihox.get(i) + " Y: " + mihoy.get(i) + " has perished.");
						mihox.remove(i);
						mihoy.remove(i);
						numbermihoalive -= 1;
					}
				}
				//more to come

			}
		});
		timer.setRepeats(true);
		// Aprox. 60 FPS is 17 ms (1000/60 = 16.67)
		timer.setDelay(17);
		timer.start();
	}

}

package hivolts;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;


//TODO: Current error: at hivolts.gameplay.mihoCoords(gameplay.java:94)
//					   at hivolts.gameplay.mihoCoords(gameplay.java:102)


public class gameplay{

	int[] fencex = new int[20];
	int[] fencey = new int[20];
	int[] jump = new int[2];
	//ArrayList<Integer> arrL = new ArrayList<Integer>(2);
	//int[] mihox = new int[12];
	//int[] mihoy = new int[12];
	
	//don't need to specify size, but I did anyways (12)
	ArrayList<Integer> mihox = new ArrayList<Integer>(12);
	ArrayList<Integer> mihoy = new ArrayList<Integer>(12);
	
	public gameplay () {
		//nothing here yet
	}

	public int[] fenceCoords(String g) {
		//TODO: below is to ensure that fence does not spawn on player; needs testing.
		//TODO: I think rn some of the mihos are overlapping with fences, need to fix
		for(int i=0; i<20; i++) {
			fencex[i] = ThreadLocalRandom.current().nextInt(1, 10 + 1)*50;
		}
		for(int i=0; i<20; i++) {
			fencey[i] = ThreadLocalRandom.current().nextInt(1, 10 + 1)*50+30;
		}
		for(int i=0; i<20; i++) {
			for(int u=0; u<20; u++) {
				if(fencex[i] == keylistener.x && fencey[i] == keylistener.y) {
					fenceCoords(g);
				}
			}
		}
		if(g == "xcord") {
			return fencex;
		}
		if(g == "ycord") {
			return fencey;
		}
		return fencex;
		/*
		if(g == "xcord") {
			for(int i=0; i<20; i++) {
				fencex[i] = ThreadLocalRandom.current().nextInt(1, 10 + 1)*50;
			}
			return fencex;
		}
		if(g == "ycord") {
			for(int i=0; i<20; i++) {
				fencey[i] = ThreadLocalRandom.current().nextInt(1, 10 + 1)*50+30;
			}
			return fencey;
		}
		return fencex;
		*/
	}
	
	public int[] jumpCoords() {
		jump[0] = ThreadLocalRandom.current().nextInt(1, 10 + 1)*50;
		jump[1] = ThreadLocalRandom.current().nextInt(1, 10 + 1)*50+30;
		for(int i=0; i<20; i++) {
			for(int u=0; u<20; u++) {
				if(jump[0] == fencex[i] && jump[1] == fencey[i]) {
					jumpCoords();
				}
			}
		}
		
		return jump;
	}
	
	public ArrayList<Integer> mihoCoords(String g) {
		if(g == "mihox") {
			for(int i=0; i<12; i++) {
				mihox.add(ThreadLocalRandom.current().nextInt(1, 10 + 1)*50);
			}
			return mihox;
		}
		//after constructing y coords, checks to see if both match with fences
		//if they do, it reconstructs y coords only until they don't
		if(g == "mihoy") {
			for(int i=0; i<12; i++) {
				mihoy.add(ThreadLocalRandom.current().nextInt(1, 10 + 1)*50+30);
			}
			mihoCoords("checkandreturn");
		}
		//only returns ycoords, xcoords in above if statement
		//TODO: check for all values of fence list
		//TODO: right now the recursion kills it
		if(g == "checkandreturn") {
			for(int i=0; i<12; i++) {
				for(int u=0; u<12; u++) {
					if(mihox.get(i) == fencex[i] && mihoy.get(i) == fencey[i]) {
						mihoCoords("mihoy");
					}
				}
			}
			for(int i=0; i<12; i++) {
				for(int u=0; u<12; u++) {
					if(mihox.get(i) == fencex[i+8] && mihoy.get(i) == fencey[i+8]) {
						mihoCoords("mihoy");
					}
				}
			}
			return mihoy;
		}
		
		//default return state
		return mihoy;
	}
	
	

}

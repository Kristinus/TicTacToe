package main;

import java.awt.Point;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main implements Runnable {

	public final static int X = 1;
	public final static int O = 2;

	public int currentSym = this.X;
	private MainGUI gui;
	private MainComponent component;
	private int[][] game;
	private int cWidth;
	private int cHeight;
	private boolean winBool;

	public Main () {
		this.winBool = false;
		this.game = new int[5][5];
		for(int i=0; i<5; i++) {
			game[i][0] = -1;
			game[0][i] = -1;
			game[4][i] = -1;
			game[i][4] = -1;
		}
	}


	public void setGUI(MainGUI gui) {
		this.gui = gui;
		this.component = gui.getComponent();
		new Thread(this).start();
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!winBool) {
			component.repaint();
		}
	}

	public int[][] getGame() {
		return game;
	}
	
	private boolean isTied() {
		for (int i=1; i<4; i++) {
			for(int j=1; j<4; j++) {
				if (game[i][j]==0)
					return false;
			}
		}
		return true;
	}

	private boolean isWin(int sym) {
		// Check each column
		for (int i=1; i<4; i++) {
			if (game[1][i]==sym && game[2][i]==sym && game[3][i]==sym) {
				return true;
			}
		}
		// Check each row
		for (int i=1; i<4; i++) {
			if (game[i][1]==sym && game[i][2]==sym && game[i][3]==sym) {
				return true;
			}
		}
		// Check for diagonals
		if (game[1][1]==sym && game[2][2]==sym && game[3][3]==sym) {
			return true;
		} else if (game[3][1]==sym && game[2][2]==sym && game[1][3]==sym) {
			return true;
		}
		return false;
	}

	public void setPosn(int sym, Point location) {
		int x = (int)location.getX();
		int y = (int)location.getY();
		int cWidth = component.getWidth()/5;
		int cHeight = component.getHeight()/5;
		setPosn(sym, x/cWidth, y/cHeight);
	}
	
	public void setPosn(int sym, int x, int y) {
		game[x][y] = sym;
		this.winBool = isWin(currentSym);
		
		if (currentSym==X){
			if (winBool)
				new MessageDialog((JFrame)SwingUtilities.getWindowAncestor(gui), "Winner: X");
			currentSym=O;
		} else {
			if (winBool)
				new MessageDialog((JFrame)SwingUtilities.getWindowAncestor(gui), "Winner: O");
			currentSym=X;
		}
		if (isTied())
			new MessageDialog((JFrame)SwingUtilities.getWindowAncestor(gui), "No one Wins!");
	}

	public boolean isAvailable(Point location) {
		int x = (int)location.getX();
		int y = (int)location.getY();
		int cWidth = component.getWidth()/5;
		int cHeight = component.getHeight()/5;
		
		return isAvailable(x/cWidth, y/cHeight);
	}

	public boolean isAvailable(int x, int y) {
		if (game[x][y]==0)
			return true;
		return false;
	}

	public int getCurrentSym() {
		return currentSym;
	}
	
	public MainGUI getGUI() {
		return gui;
	}
}

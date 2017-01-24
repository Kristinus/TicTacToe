package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

public class MainComponent extends JComponent {
	private Main main;
	private int[][] game;
	private int cWidth;
	private int cHeight;
	private Graphics2D d;
	
	public MainComponent(Main main) {
		super();
		this.main = main;
		this.setPreferredSize(new Dimension(500,500));
	}
	
	private void getVariables() {
		game = main.getGame();
		cWidth = this.getWidth()/5;
		cHeight = this.getHeight()/5;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.d = (Graphics2D) g;

		d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

		this.getVariables();
		
		for (int i=1; i<5; i++) {
			d.drawLine(cWidth*i, cHeight, cWidth*i, cHeight*4);
			d.drawLine(cWidth, cHeight*i, cWidth*4, cHeight*i);
		}
		for(int x=1; x<5; x++) {
			for (int y=1; y<5; y++) {
				if (game[x][y]== Main.X) {
					this.drawX(x, y);
				} else if(game[x][y]==Main.O){
					this.drawO(x,y);
				}
			}
		}
	}
	
	private void drawX(int x, int y) {
		d.drawLine(cWidth*(x), cHeight*(y), cWidth*(x+1), cHeight*(y+1));
		d.drawLine(cWidth*(x+1), cHeight*(y), cWidth*(x), cHeight*(y+1));
	}
	
	private void drawO(int x, int y) {
		d.drawOval(cWidth*(x), cHeight*(y), cWidth, cHeight);
	}
}

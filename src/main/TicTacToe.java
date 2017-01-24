package main;

import javax.swing.JFrame;


public class TicTacToe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Tic Tac Toe");
		Main main = new Main();
		MainGUI contentPane = new MainGUI(main);
		
		//Sets the frame to appear visually
		frame.setContentPane(contentPane);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		frame.pack();
		
		frame.setLocationRelativeTo(null);
	}

}

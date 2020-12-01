package main;

import javax.swing.JFrame;

import main.Game;
public class GameMain {
	public static void main(String[] args) {
		JFrame window = new JFrame("shooter");
		window.setContentPane(new Game());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
	}
}

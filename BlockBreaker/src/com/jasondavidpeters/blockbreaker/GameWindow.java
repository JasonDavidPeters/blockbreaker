package com.jasondavidpeters.blockbreaker;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GameWindow extends Canvas {
	private static final long serialVersionUID = 1L;
	private static final String GAME_TITLE = "Block Breaker";
	public static final int WIDTH = 480;
	public static final int HEIGHT = 240;
	public static final int SCALE = 2;

	public GameWindow() {
		JFrame frame = new JFrame(GAME_TITLE);
		frame.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.add(this);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}

}

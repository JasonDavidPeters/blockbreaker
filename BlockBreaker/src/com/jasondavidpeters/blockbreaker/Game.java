package com.jasondavidpeters.blockbreaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

	private Thread thread;
	private boolean running;

	private GameWindow gameWindow;

	public Game() {
		gameWindow = new GameWindow();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.run();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long timer = System.currentTimeMillis();
		long before = System.nanoTime();
		long now = 0;
		double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int ticks = 0;
		int frames = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - before) / ns;
			before = now;
			while (delta >= 1) {
				delta -= 1;
				tick();
				ticks++;
			}
			if ((System.currentTimeMillis() - timer) >= 1000) {
				System.out.println("ticks:" + ticks + " frames: " + frames);
				timer = System.currentTimeMillis();
				ticks = 0;
				frames = 0;
			}
			frames++;
			render();
		}
	}

	public void tick() {

	}

	public void render() {
		BufferStrategy bs = gameWindow.getBufferStrategy();
		if (bs == null) {
			gameWindow.createBufferStrategy(3);
			bs = gameWindow.getBufferStrategy();
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, GameWindow.WIDTH * GameWindow.SCALE, GameWindow.WIDTH * GameWindow.SCALE);
		bs.show();
		g.dispose();
	}
}

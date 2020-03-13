package com.jasondavidpeters.blockbreaker.world;

import java.awt.Color;
import java.awt.Graphics;

import com.jasondavidpeters.blockbreaker.GameWindow;
import com.jasondavidpeters.blockbreaker.entity.Player;
import com.jasondavidpeters.blockbreaker.input.Keyboard;

public class Level {

	private Player player;
	private Keyboard keyboard;
	public Level(GameWindow gw) {
		keyboard = new Keyboard();
		player = new Player(GameWindow.WIDTH, (GameWindow.HEIGHT*GameWindow.SCALE)-100, 50,1, Color.WHITE,10);
		gw.addKeyListener(keyboard);
	}

	public void tick() {
		player.tick();
		keyboard.tick();
		if (keyboard.left) player.setX(player.getX()-player.getSpeed());
		if (keyboard.right) player.setX(player.getX()+player.getSpeed());
	}

	public void render(Graphics g) {
		player.render(g);
	}

}

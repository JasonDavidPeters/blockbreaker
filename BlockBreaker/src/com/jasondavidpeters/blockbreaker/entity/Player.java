package com.jasondavidpeters.blockbreaker.entity;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

	private int x, y, width, height, speed;
	private Color c;

	public Player(int x, int y, int width, int height, Color c, int speed) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.c = c;
		this.speed = speed;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpeed() {
		return this.speed;
	}

	public Color getColor() {
		return this.c;
	}
}

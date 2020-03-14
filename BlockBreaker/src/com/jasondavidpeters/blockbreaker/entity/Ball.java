package com.jasondavidpeters.blockbreaker.entity;

import java.awt.Color;

public class Ball {

	private boolean[] direction = new boolean[6];
	private Color c;
	private int x, y, width, height, speed;

	public Ball(int x, int y, int width, int height, int speed) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
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

	public void setDirection(String dir) {
		/*
		 * 0 = up, 1 = down, 2 = left, 3 = right
		 */
		if (dir.equalsIgnoreCase("down")) {
			direction[1] = true;
			direction[0] = direction[2] = direction[3] = direction[4] = direction[5] = false;
		}
		if (dir.equalsIgnoreCase("up")) {
			direction[0] = true;
			direction[1] = direction[2] = direction[3] = direction[4] = direction[5] = false;
		}
		if (dir.equalsIgnoreCase("upright")) {
			direction[2] = true;
			direction[0] = direction[1] = direction[3] = direction[4] = direction[5] = false;
		}
		if (dir.equalsIgnoreCase("upleft")) {
			direction[3] = true;
			direction[0] = direction[1] = direction[2] = direction[4] = direction[5] = false;
		}
		if (dir.equalsIgnoreCase("downright")) {
			direction[4] = true;
			direction[0] = direction[1] = direction[2] = direction[3] = direction[5] = false;
		}
		if (dir.equalsIgnoreCase("downleft")) {
			direction[5] = true;
			direction[0] = direction[1] = direction[2] = direction[4] = direction[3] = false;
		}
	}

	public boolean[] getDirection() {
		return direction;
	}

}

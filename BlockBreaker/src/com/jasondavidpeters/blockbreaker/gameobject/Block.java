package com.jasondavidpeters.blockbreaker.gameobject;

import java.awt.Color;

public class Block {

	private int x, y, width, height;
	private Color c;
	private boolean isAlive;

	public Block(int x, int y, int width, int height, Color c) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.c = c;
		isAlive=true;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public Color getColor() {
		return this.c;
	}
	public boolean isAlive() {
		return this.isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive=isAlive;
	}

	public void setX(int i, int j) {
		this.x=i;this.y=j;
		
	}

}

package com.jasondavidpeters.blockbreaker.world;

import java.awt.Color;
import java.awt.Graphics;

import com.jasondavidpeters.blockbreaker.GameWindow;
import com.jasondavidpeters.blockbreaker.entity.Ball;
import com.jasondavidpeters.blockbreaker.entity.Player;
import com.jasondavidpeters.blockbreaker.input.Keyboard;

public class Level {

	private Player player;
	private Ball ball;
	private Keyboard keyboard;

	private boolean gameStart;
	private boolean setDir;

	public Level(GameWindow gw) {
		keyboard = new Keyboard();
		ball = new Ball((GameWindow.WIDTH * GameWindow.SCALE) / 2, GameWindow.HEIGHT, 15, 15, 5);
		player = new Player((GameWindow.WIDTH * GameWindow.SCALE) / 2, (GameWindow.HEIGHT * GameWindow.SCALE) - 100, 75, 1, Color.WHITE, 2);
		gw.addKeyListener(keyboard);
	}

	private void ballCollision() {
		/*
		 * if ball.getHeight >= player.getHeight() && ball.getX() >=
		 * player.getX()+player.getWidth() || ball.getX() <=
		 * player.getX()-player.getWidth()
		 */

		if ((ball.getY() + (ball.getHeight() / 2)) >= player.getY() && (ball.getY() - (ball.getHeight() / 2)) <= player.getY()) { // ball is at same level as player
			if (ball.getX() >= (player.getX() + (player.getWidth() / 2) - ball.getWidth()) && ball.getX() <= player.getX() + (player.getWidth() / 3) * 2) { // ball hits middle of player
				changeDirection();
			}

			// Ball colliding with left side of player
			if (ball.getX() >= player.getX() && ball.getX() <= player.getX() + (player.getWidth() / 2)) {
				ball.setDirection("upleft");
			}
		}
		// Ball colliding with right side of player

		if (ball.getY() - ball.getHeight() / 2 <= 0 || ball.getY() + ball.getHeight() / 2 >= (GameWindow.HEIGHT * GameWindow.SCALE) - ball.getHeight()*2) {
			changeDirection();
		}
		if (ball.getX() >= (GameWindow.WIDTH * GameWindow.SCALE)) {
			// if its moving upwards then keep it going upwards

			if (ball.getDirection()[2])
				ball.setDirection("upleft");
			else
				ball.setDirection("downleft");
		}
		if (ball.getX() <= 0) {
			if (ball.getDirection()[3])
				ball.setDirection("upright");
			else
				ball.setDirection("downright");
		}

	}

	private void reset() {

	}

	private void changeDirection() {
		/*
		 * 0 = up, 1 = down, 2 = upright, 3 = upleft 4 = downright 5 = downleft
		 */
		if (ball.getDirection()[0] == true) {
			ball.setDirection("down");
		} else if (ball.getDirection()[1] == true) {
			ball.setDirection("up");
		} else if (ball.getDirection()[2] == true) {
			ball.setDirection("downright");
		} else if (ball.getDirection()[3] == true) {
			ball.setDirection("downleft");
		} else if (ball.getDirection()[4] == true) {
			ball.setDirection("upright");
		} else if (ball.getDirection()[5] == true) {
			ball.setDirection("upleft");
		}
	}

	public void tick() {
		keyboard.tick();
		if (keyboard.left || keyboard.right)
			gameStart = true;
		if (keyboard.left)
			player.setX(player.getX() - player.getSpeed());
		if (keyboard.right)
			player.setX(player.getX() + player.getSpeed());
		if (gameStart) {
			if (!setDir) {
				ball.setDirection("down"); // initial direction of ball
				setDir = true;
			}
			/*
			 * 0 = up, 1 = down, 2 = upleft, 3 = upright 4 = downleft 5 = downright
			 */
			if (ball.getDirection()[0] == true) {
				ball.setY(ball.getY() - ball.getSpeed()); // up
				ball.setX(ball.getX());
			} else if (ball.getDirection()[1] == true) {
				ball.setY(ball.getY() + ball.getSpeed()); // down
				ball.setX(ball.getX());
			} else if (ball.getDirection()[2] == true) { // up-right
				ball.setX(ball.getX() + ball.getSpeed() % 2);
				ball.setY(ball.getY() - ball.getSpeed());
			} else if (ball.getDirection()[3] == true) { // up-left
				ball.setX(ball.getX() - ball.getSpeed() % 2);
				ball.setY(ball.getY() - ball.getSpeed());
			} else if (ball.getDirection()[4] == true) { // down-right
				ball.setX(ball.getX() + ball.getSpeed() % 2);
				ball.setY(ball.getY() + ball.getSpeed());
			} else if (ball.getDirection()[5] == true) { // down-left
				ball.setY(ball.getY() + ball.getSpeed());
				ball.setX(ball.getX() - ball.getSpeed() % 2);
			}
		}
		ballCollision();
		/*
		 * Logic of ball- facingdirection = south y++;, north y-- if ball hits player on
		 * left side then x-- if ball hits player on right side then x++
		 */
	}

	public void render(Graphics g) {
		g.setColor(player.getColor());
		g.fillRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
		g.setColor(ball.getColor());
		g.fillOval(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
	}

}

package Pong;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	double x, y, xVel, yVel;

	public Ball() {
		x = 360;
		y = 240;
		xVel = getRandomSpeed() * getRandomDirection();//-2;
		yVel = getRandomSpeed() * getRandomDirection();//1;
	}

	public double getRandomSpeed() {
		return (Math.random() * 3 + 2);
	}

	public double getRandomDirection() {
		int rand = (int) (Math.random() * 2);
		return (rand == 1) ? 1 : -1;
	}

	public void move() {
		x += xVel;
		y += yVel;

		// refraction model
		if (y < 10)
			yVel = -yVel;
		if (y > 490)
			yVel = -yVel;
	}

	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval((int) x - 10, (int) y - 10, 20, 20);
	}

	public void checkPaddleCollision(Paddle p1, Paddle p2) {
		if (x <= 50) {
			if (y >= p1.getY() && y <= (p1.getY() + 80))
				xVel = -xVel;
		} else if (x >= 650) {
			if (y >= p2.getY() && y <= (p2.getY() + 80))
				xVel = -xVel;
		}
	}

	public int getX() {
		return (int) x;
	}

	public int getY() {
		return (int) y;
	}

}

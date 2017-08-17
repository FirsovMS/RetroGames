package Pong;

import java.awt.Color;
import java.awt.Graphics;

public class AIPaddle implements Paddle {

	public int Score;
	// global parameters
	final double GRAVITY = 0.94;
	double y, yVel;
	boolean upAccel, downAccel;
	int player, x;
	Ball b1;

	public AIPaddle(int player, Ball b) {
		this.Score = 0;
		upAccel = false; downAccel = false;
		b1 = b;
		y = 210; yVel = 0;
		if(player == 0) {
			x = 20;
		}else {
			x = 660;
		}
	}

	// draw human paddle
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, (int)y, 20, 60);
	}

	public void move() {
		y = b1.getY() - 40;
		
		//border 
		if(y < 0)
			y = 0;
		if (y > 440)
			y = 440;
	}
	
	public int getY() {
		return (int)y;
	}

}

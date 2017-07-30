package Pong;

import java.awt.Color;
import java.awt.Graphics;

public class HumanPaddle implements Paddle {

	// global parameters
	final double GRAVITY = 0.94;
	double y, yVel;
	boolean upAccel, downAccel;
	int player, x;

	public HumanPaddle(int player) {
		upAccel = false; downAccel = false;
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
		if(upAccel) {
			yVel -= 1;
		}else if(downAccel) {
			yVel += 1;
		}else if(!upAccel && !downAccel) {
			yVel *= GRAVITY;
		}
		//speed velocity
		if(yVel >= 5)
			yVel = 5;
		else if(yVel <= -5)
			yVel = -5;
		
		y += yVel;
		
		//border 
		if(y < 0)
			y = 0;
		if (y > 440)
			y = 440;
	}
	
	
	//setter and getters
	public void setUpAccel(boolean input) {
		upAccel = input;
	}
	
	public void setDownAccel(boolean input) {
		downAccel = input;
	}

	public int getY() {
		return (int)y;
	}

}

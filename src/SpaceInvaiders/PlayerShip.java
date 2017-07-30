package SpaceInvaiders;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlayerShip implements ShipInterface {

	// Player fields
	private int x, xVel;
	final private int y = 370;
	private boolean leftAccel, rightAcell;
	private double GRAVITY = 0.75;

	public PlayerShip() {
		x = 190;
		xVel = 0;
		leftAccel = false;
		rightAcell = false;
	}

	public void draw(Graphics g) {
		// g.setColor(Color.WHITE);
		// g.fillRect(x, (int)y, 20, 20);
		g.drawImage(Sprite.loadSprite("player.png"), x, y, null);
	}

	public void move() {
		if (leftAccel) { 
			xVel -= 1;
		} else if (rightAcell) {
			xVel += 1;
		} else if (!leftAccel && !rightAcell) { //stopping 
			xVel *= GRAVITY;
		}
		x += (int)xVel;
	}
	
	public void fire() {
		
		
	}

	// sett Accel
	public void setLeftAccel(boolean input) {
		this.leftAccel = input;
	}

	public void setRightAccel(boolean input) {
		this.rightAcell = input;
	}

	public int getX() {
		return this.x;
	}
}

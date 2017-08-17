package SpaceInvaiders;

import java.awt.Graphics;

public class PlayerShip implements ShipInterface {

	// Player fields
	private int x, xVel;
	final private int y = 370;
	private boolean leftAccel, rightAcell;
	private double GRAVITY = 0.75;
	private Sprite spriteSpaceShip;

	public PlayerShip() {
		x = 190;
		xVel = 0;
		leftAccel = false;
		rightAcell = false;
		spriteSpaceShip = new Sprite("player.png");
	}

	public void draw(Graphics g) {
		spriteSpaceShip.draw(g, x, y);
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
		new FireSprite(this);		
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

	public int getY() {
		return this.y;
	}
}

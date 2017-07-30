package SpaceInvaiders;

import java.awt.Graphics;

public interface ShipInterface {
	public void draw(Graphics g);
	public void move();
	public int getX();
	public void fire();
}

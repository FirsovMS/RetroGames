package SpaceInvaiders;

import java.awt.Color;
import java.awt.Graphics;

public class FireSprite {

	private int x, y;
	private final int width = 5, height = 10;

	public FireSprite(Enemy enemy) {
		x = enemy.getX();
		y = enemy.getY();
	}

	public FireSprite(PlayerShip player) {
		x = player.getX();
		y = player.getY();
	}

	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawRect(x, y, width, height);
	}

	public void checkEnemyCollision(Enemy enemy) {

	}

	public void checkEnemyCollision(PlayerShip playerShip) {

	}

	public void move() {
		y += 1;
	}
}
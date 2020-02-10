package games.com.assets.SpaceInvaiders;

import java.awt.*;

public class FireSprite {

    private final int width = 5, height = 10;
    private int x, y;

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
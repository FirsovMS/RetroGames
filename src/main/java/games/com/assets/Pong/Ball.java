package games.com.assets.Pong;

import java.awt.*;

public class Ball {
    private static final int radius = 10;
    private static final int x_offset = 50;

    private static final int min_speed = 2;
    private static final int max_speed = 5;

    private final int window_width;
    private final int window_height;

    private double x, y, xVel, yVel;

    public Ball(int width, int height) {
        window_width = width;
        window_height = height;

        x = window_width / 2;
        y = window_height /2;
        xVel = getRandomSpeed() * getRandomDirection();//-2;
        yVel = getRandomSpeed() * getRandomDirection();//1;
    }

    public double getRandomSpeed() {
        return (Math.random() * (max_speed - min_speed) + min_speed);
    }

    public double getRandomDirection() {
        int rand = (int) (Math.random() * 2);
        return (rand == 1) ? 1 : -1;
    }

    public void move() {
        x += xVel;
        y += yVel;

        // refraction model
        if (y < radius || y > window_height - 3 * radius) {
            yVel = -yVel;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        final int maxSize =  2 * radius;
        g.fillOval((int) x - radius, (int) y - radius, maxSize, maxSize);
    }



    public void checkPaddleCollision(Paddle p1, Paddle p2) {
        if (x <= x_offset) {
            if (y >= p1.getY() && y <= (p1.getY() + p1.getSizeX()))
                xVel = -xVel;
        } else if (x >= window_width - x_offset) {
            if (y >= p2.getY() && y <= (p2.getY() + p1.getSizeX()))
                xVel = -xVel;
        }
    }

    public int getX() {
        return (int) x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return (int) y;
    }

    public void setY(int y) {
        this.y = y;
    }

}

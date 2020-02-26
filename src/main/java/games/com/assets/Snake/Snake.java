package games.com.assets.Snake;

import javafx.util.Pair;

import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Snake {
    private static final int cellSize = 10;
    private static final int startsize = 20;
    private final int startPositionX;
    private final int startPositionY;
    private final int window_width;
    private final int window_height;

    List<Point> snakePoints;
    int xDir, yDir; // Direction velocities
    boolean isMoving, elongate;

    public Snake(int width, int height) {
        window_width = width;
        window_height = height;

        int[] positions = getStartPositionCoordinate();
        startPositionX = positions[0];
        startPositionY = positions[1];

        snakePoints = new ArrayList<Point>();
        xDir = 0;
        yDir = 0;
        isMoving = false;
        elongate = false;
        snakePoints.add(new Point(startPositionX, startPositionY));
        for (int i = 1; i < startsize; i++) {
            snakePoints.add(new Point(startPositionX - i * cellSize / 2, startPositionY));
        }
    }

    private int[] getStartPositionCoordinate() {
        Random random = new Random();
        return new int[] {
                random.nextInt(window_width - startsize) + startsize / 2,
                random.nextInt(window_height - startsize) + startsize / 2
        };
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        for (Point p : snakePoints) {
            g.fillRect(p.getX(), p.getY(), cellSize, cellSize);
        }
    }

    public void move() {
        if (isMoving) {
            Point temp = snakePoints.get(0);
            Point last = snakePoints.get(snakePoints.size() - 1);
            Point nextStart = new Point(temp.getX() + xDir * cellSize / 2, temp.getY() + yDir * cellSize / 2);
            // gives a new Points
            for (int i = snakePoints.size() - 1; i >= 1; --i) {
                snakePoints.set(i, snakePoints.get(i - 1));
            }
            snakePoints.set(0, nextStart);
            if (elongate) {
                snakePoints.add(last);
                elongate = false;
            }
        }
    }

    public boolean snakeCollision() {
        int x = this.getX();
        int y = this.getY();
        for (int i = 1; i < snakePoints.size(); i++) {
            if (snakePoints.get(i).getX() == x && snakePoints.get(i).getY() == y)
                return true;
        }
        return false;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setIsMoving(boolean b) {
        this.isMoving = b;
    }

    // Directions set and get methods
    public int getXDir() {
        return xDir;
    }

    public void setXDir(int x) {
        this.xDir = x;
    }

    public int getYDir() {
        return yDir;
    }

    public void setYDir(int y) {
        this.yDir = y;
    }

    // X positiion of head of snake
    public int getX() {
        return snakePoints.get(0).getX();
    }

    // Y positiion of head of snake
    public int getY() {
        return snakePoints.get(0).getY();
    }

    public void setElongate(boolean b) {
        elongate = b;
    }

    public int getCellRadius() {
        return cellSize / 2;
    }
}

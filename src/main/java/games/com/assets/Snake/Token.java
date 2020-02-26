package games.com.assets.Snake;

import java.awt.*;

public class Token {
    private static final int cellSize = 20;

    private final int width;
    private final int height;
    private int x, y, score;
    private Snake snake;

    public Token(Snake snake, int width, int height) {
        this.width = width;
        this.height = height;
        this.snake = snake;

        changePosition();
    }

    public int getScore() {
        return score;
    }

    public void changePosition() {
        x = (int) (Math.random() * width);
        y = (int) (Math.random() * height);
    }

    public boolean snakeCollision() {
        int snakeX = snake.getX() + 2;
        int snakeY = snake.getY() + 2;
        if ((snakeX >= (x - 1) && snakeX <= (x + cellSize + 1)) && (snakeY >= (y - 1) && snakeY <= (y + 1 + cellSize))) {
            changePosition();
            ++score;
            snake.setElongate(true);
            return true;
        }
        return false;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, cellSize, cellSize);
    }
}

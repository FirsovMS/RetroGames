package Snake;

import java.awt.Color;
import java.awt.Graphics;

public class Token {

	private int x, y, scoore;
	private Snake snake;

	public Token(Snake s) {
		changePosition();
		this.snake = s;
	}

	public int getScore() {
		return scoore;
	}

	public void changePosition() {
		x = (int) (Math.random() * 395);
		y = (int) (Math.random() * 395);
	}

	public boolean snakeCollision() {
		int snakeX = snake.getX() + 2;
		int snakeY = snake.getY() + 2;
		if ((snakeX >= x - 1 && snakeX <= (x + 7)) && (snakeY >= y - 1 && snakeY <= (y + 7))) {
			changePosition();
			++scoore;
			snake.setElongate(true);
			return true;
		}
		return false;
	}

	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 6, 6);
	}
}

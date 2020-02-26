package games.com.assets.Snake;

import games.com.assets.BaseGame;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collection;

@SuppressWarnings("serial")
public class SnakeGame extends BaseGame {
    private Graphics gfx;
    private Image img;
    private Thread thread;
    private Snake snake;
    private boolean gameOver;
    private Token token;

    public SnakeGame(int width, int height ){
        super(width, height);
    }

    public void init() {
        // graphical syst
        this.resize(width, height);
        img = createImage(width, height);
        gfx = img.getGraphics();

        this.addKeyListener(this);
        // game objects
        gameOver = false;
        snake = new Snake(width, height);
        token = new Token(snake, width, height);
        // threading system
        thread = new Thread(this);
        thread.start();
    }

    public void paint(Graphics g) {
        gfx.setColor(Color.black);
        gfx.fillRect(0, 0, width, height);

        if (!gameOver) {
            snake.draw(gfx);
            token.draw(gfx);
        } else {
            gfx.setColor(Color.RED);
            String[] msg = { "Game Over", String.format("Score is %d", token.getScore()) };
            drawMessages(msg);
        }
        g.drawImage(img, 0, 0, null);
    }

    private void drawMessages(String[] messages) {
        int y = height / 2;
        final int x = width / 2;
        for (String msg: messages) {
            gfx.drawString(msg, x, y += 20);
        }
    }

    public void update(Graphics g) {
        this.paint(g);
    }

    public void repaint(Graphics g) {
        this.paint(g);
    }

    // the thread run
    public void run() {
        while (true){
            if (!gameOver) {
                snake.move();
                this.checkGameOver();
                this.token.snakeCollision();
            }
            this.repaint();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private final int borderSize = 10;

    public void checkGameOver() {
        final int radius = snake.getCellRadius();
        gameOver = ((snake.getX() < 0 || snake.getX() > width - borderSize - radius)
                || (snake.getY() < 0 || snake.getY() > height - borderSize - radius))
                || (snake.snakeCollision());
    }

    // Motion triggers
    public void keyPressed(KeyEvent e) {
        if (!snake.isMoving()) {
            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_RIGHT
                    || e.getKeyCode() == KeyEvent.VK_DOWN) {
                snake.setIsMoving(true);
            }
        }
        // directions
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (snake.getYDir() != 1) {
                    snake.setYDir(-1);
                    snake.setXDir(0);
                }
                break;
            case KeyEvent.VK_DOWN:
                if (snake.getYDir() != -1) {
                    snake.setYDir(1);
                    snake.setXDir(0);
                }
                break;
            case KeyEvent.VK_LEFT:
                if (snake.getXDir() != 1) {
                    snake.setXDir(-1);
                    snake.setYDir(0);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (snake.getXDir() != -1) {
                    snake.setXDir(1);
                    snake.setYDir(0);
                }
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }
}

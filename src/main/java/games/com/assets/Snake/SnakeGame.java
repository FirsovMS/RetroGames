package games.com.assets.Snake;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class SnakeGame extends Applet implements Runnable, KeyListener {

    Graphics gfx;
    Image img;
    Thread thread;
    Snake snake;
    boolean gameOver;
    Token token;

    public void init() {
        // graphical syst
        this.resize(400, 400);
        img = createImage(400, 400);
        gfx = img.getGraphics();

        this.addKeyListener(this);
        // game objects
        gameOver = false;
        snake = new Snake();
        token = new Token(snake);
        // threading system
        thread = new Thread(this);
        thread.start();
    }

    public void paint(Graphics g) {
        gfx.setColor(Color.black);
        gfx.fillRect(0, 0, 400, 400);

        if (!gameOver) {
            snake.draw(gfx);
            token.draw(gfx);
        } else {
            gfx.setColor(Color.RED);
            gfx.drawString("Game Over", 180, 150);
            gfx.drawString("Scoore: " + token.getScore(), 180, 170);
        }
        g.drawImage(img, 0, 0, null);
    }

    public void update(Graphics g) {
        this.paint(g);
    }

    public void repaint(Graphics g) {
        this.paint(g);
    }

    // the thread run
    public void run() {
        for (; ; ) {
            if (!gameOver) {
                snake.move();
                this.checkGameOver();
                this.token.snakeCollision();
            }
            this.repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void checkGameOver() {
        if ((snake.getX() < 0 || snake.getX() > 396) || (snake.getY() < 0 || snake.getY() > 396)) {
            gameOver = true;
        }
        if (snake.snakeCollision()) {
            gameOver = true;
        }
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

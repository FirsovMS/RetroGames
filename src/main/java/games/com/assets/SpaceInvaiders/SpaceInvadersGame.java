package games.com.assets.SpaceInvaiders;

import games.com.assets.BaseGame;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class SpaceInvadersGame extends BaseGame {
    // Game Env
    private Graphics gfx;
    private Image img;
    private Thread thread;
    boolean gameStarted;
    // Game objects
    private PlayerShip player;

    public SpaceInvadersGame(int width, int height) {
        super(width, height);
    }

    // entry point
    public void init() {
        this.resize(width, height); // set window size
        gameStarted = false;
        // create buffered image
        img = createImage(width, height);
        gfx = img.getGraphics();
        this.addKeyListener(this);
        // create game objects
        player = new PlayerShip();
        // run new thread for executing process
        thread = new Thread(this);
        thread.start();
    }

    public void paint(Graphics g) {
        gfx.setColor(Color.black);
        gfx.fillRect(0, 0, width, height);
        // draw game objects
        player.draw(gfx);

        if (!gameStarted) {
            gfx.setColor(Color.green);
            gfx.drawString("Space Invaders", 150, 180);
            gfx.drawString("Press ENTER to Start", 140, 200);
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
       while (true) {
            // move game objects
            if (gameStarted) {
                player.move();
            }
            this.repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Key triggers
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                player.setLeftAccel(true);
                break;

            case KeyEvent.VK_RIGHT:
                player.setRightAccel(true);
                break;
            // run game onclick ENTER
            case KeyEvent.VK_ENTER:
                gameStarted = true;
                break;
            //press Fire
            case KeyEvent.VK_SPACE:
                System.out.println("Fire");
                player.fire();
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                player.setLeftAccel(false);
                break;

            case KeyEvent.VK_RIGHT:
                player.setRightAccel(false);
                break;
        }
    }

    public void keyTyped(KeyEvent arg0) {

    }
}

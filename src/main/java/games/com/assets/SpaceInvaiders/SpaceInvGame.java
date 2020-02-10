package games.com.assets.SpaceInvaiders;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class SpaceInvGame extends Applet implements Runnable, KeyListener {

    private final int WIDTH = 400, HEIGTH = 400;
    // Game Env
    Graphics gfx;
    Image img;
    Thread thread;
    boolean gameStarted;
    // Game objects
    PlayerShip player;

    // entry point
    public void init() {
        this.resize(WIDTH, HEIGTH); // set window size
        gameStarted = false;
        // create buffered image
        img = createImage(WIDTH, HEIGTH);
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
        gfx.fillRect(0, 0, WIDTH, HEIGTH);
        // draw game objects
        player.draw(gfx);

        if (!gameStarted) {
            gfx.setColor(Color.green);
            gfx.drawString("Space Invaiders", 150, 180);
            gfx.drawString("Push ENTER to Start", 140, 200);
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

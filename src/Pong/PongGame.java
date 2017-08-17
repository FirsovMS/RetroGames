package Pong;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class PongGame extends Applet implements Runnable, KeyListener {

	// screen size params
	private int time = 16;
	final int WIDTH = 700, HEIGHT = 500;
	Thread thread;
	HumanPaddle p1;
	AIPaddle p2;
	Ball ball;
	boolean gameStarted;
	boolean gameOver;
	// disable blinking
	Graphics gfx;
	Image img;

	// main method,as entry point
	public void init() {
		this.resize(WIDTH, HEIGHT);
		this.gameOver = false;
		gameStarted = false;
		this.addKeyListener(this);

		ball = new Ball();
		p1 = new HumanPaddle(0);
		p2 = new AIPaddle(1, ball);

		img = createImage(WIDTH, HEIGHT);
		gfx = img.getGraphics();

		thread = new Thread(this);
		thread.start();
	}

	// draw buuffered image on the screen
	public void paint(Graphics g) {
		gfx.setColor(Color.BLACK);
		// game out
		gfx.fillRect(0, 0, WIDTH, HEIGHT);
		// Start game condition
		if (!gameStarted) {
			gfx.setColor(Color.WHITE);
			gfx.drawString("Tennis", 340, 100);
			gfx.drawString("Press Enter to Begin", 310, 130);
		} else {
			// drawing a models
			p1.draw(gfx); // draw player model
			ball.draw(gfx);
			p2.draw(gfx);
			// draw score
			gfx.setColor(Color.WHITE);
			gfx.setFont(new Font("TimesRoman", Font.PLAIN, 22));
			gfx.drawString(String.valueOf(p1.Score), 100, 20);
			gfx.drawString(String.valueOf(p2.Score), 600, 20);
			// Score control
			if (ball.getX() < -10) {
				if (p1.Score > 10) {
					gfx.drawString("You Win!", 340, 240);
				} else {
					++p1.Score;
					this.timeSub(time);					
					ball.setX(340);
					ball.setY(240);
				}
			} else if (ball.getX() > 710) {
				
				if (p2.Score > 10) {
					gfx.drawString("AI Win!", 340, 240);
				}else {
					++p2.Score;
					this.timeSub(time);
					ball.setX(340);
					ball.setY(240);
				}
				
			}
		}
		g.drawImage(img, 0, 0, this);
	}

	// refresh the screen
	public void update(Graphics g) {
		this.paint(g);
	}

	// run this process as parallel thread
	public void run() {
		for (;;) {
			if (gameStarted) {
				p1.move();
				p2.move();
				ball.move();
				ball.checkPaddleCollision(p1, p2);
			}
			this.repaint();// repaint out sheme
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// at the next - Key Listener
	// after key pressed we analyze
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(true);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(true);
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER)
			gameStarted = true;
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(false);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(false);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
	public void timeSub(int t) {
		if(time >= 5) {
			--time;
		}
	}
}

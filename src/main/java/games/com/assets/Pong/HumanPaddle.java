package games.com.assets.Pong;

import java.awt.*;

public class HumanPaddle implements Paddle {
    private static final int startPositionY = 30;
    private static final int startPositionX = 20;
    // global parameters
    private static final double GRAVITY = 0.94;
    private final int windowHeight;
    private double y, yVel;
    private boolean upAccel, downAccel;
    private int player, x;

    public int Score;

    public HumanPaddle(int player, int windowWidth, int windowHeight) {
        this.windowHeight = windowHeight;
        Score = 0;
        upAccel = false;
        downAccel = false;
        y = 210;
        yVel = 0;
        if (player == 0) {
            x = startPositionX;
        } else {
            x = windowWidth - 2 * startPositionX;
        }
    }

    @Override
    public int getSizeX() {
        return 2 * startPositionX;
    }

    // draw human paddle
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, (int) y, startPositionX, 60);
    }

    public void move() {
        if (upAccel) {
            yVel -= 1;
        } else if (downAccel) {
            yVel += 1;
        } else if (!upAccel && !downAccel) {
            yVel *= GRAVITY;
        }
        //speed velocity
        if (yVel >= 5)
            yVel = 5;
        else if (yVel <= -5)
            yVel = -5;

        y += yVel;

        //border
        if (y < 0) {
            y = 0;
        }
        if (y > windowHeight - 2 * startPositionY) {
            y = windowHeight - 2 * startPositionY;
        }
    }


    //setter and getters
    public void setUpAccel(boolean input) {
        upAccel = input;
    }

    public void setDownAccel(boolean input) {
        downAccel = input;
    }

    public int getY() {
        return (int) y;
    }

}

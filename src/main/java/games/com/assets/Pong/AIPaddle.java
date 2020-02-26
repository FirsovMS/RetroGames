package games.com.assets.Pong;

import java.awt.*;

public class AIPaddle implements Paddle {
    private final int coord_offset = 20;

    private final int window_width;
    private final int window_height;
    private final double gravity = 0.94;

    private double y, yVel;
    private boolean upAccel, downAccel;
    private int player, x;
    private Ball b1;

    public int Score;

    public AIPaddle(int player, Ball b, int width, int height) {
        window_width = width;
        window_height = height;

        Score = 0;
        upAccel = false;
        downAccel = false;
        b1 = b;
        y = height / 2;
        yVel = 0;

        if (player == 0) {
            x = coord_offset;
        } else {
            x = width - 3 * coord_offset;
        }
    }

    @Override
    public int getSizeX() {
        return 2 * coord_offset;
    }

    // draw human paddle
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, (int) y, 20, 60);
    }

    public void move() {
        y = b1.getY() - 40;

        //border
        if (y < 0) {
            y = 0;
        }
        if (y > window_height - 2 * coord_offset) {
            y = window_height - coord_offset;
        }
    }

    public int getY() {
        return (int) y;
    }

}

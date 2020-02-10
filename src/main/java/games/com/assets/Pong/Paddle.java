package games.com.assets.Pong;

import java.awt.*;

public interface Paddle {
    void draw(Graphics g);

    void move();

    int getY();
}

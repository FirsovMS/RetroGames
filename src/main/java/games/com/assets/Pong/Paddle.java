package games.com.assets.Pong;

import java.awt.*;

public interface Paddle {
    int getSizeX();

    void draw(Graphics g);

    void move();

    int getY();
}

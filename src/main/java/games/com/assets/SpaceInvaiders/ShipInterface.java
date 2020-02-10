package games.com.assets.SpaceInvaiders;

import java.awt.*;

public interface ShipInterface {
    void draw(Graphics g);

    void move();

    int getX();

    int getY();

    void fire();
}

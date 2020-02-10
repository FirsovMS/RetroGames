package games.com.assets.SpaceInvaiders;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Sprite {

    private Image image;

    public Sprite(String fileName) {
        try {
            this.image = ImageIO.read(SpaceInvGame.class.getResourceAsStream(fileName));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public int getWidth() {
        return image.getWidth(null);
    }

    public int getHeight() {
        return image.getHeight(null);
    }

    public void draw(Graphics g, int x, int y) {
        g.drawImage(image, x, y, null);
    }
}

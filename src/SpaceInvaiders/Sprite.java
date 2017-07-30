package SpaceInvaiders;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	public static Image loadSprite(String fileName) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(SpaceInvGame.class.getResourceAsStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
}

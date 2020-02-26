package games.com.assets;

import java.applet.Applet;
import java.awt.event.KeyListener;

public abstract class BaseGame extends Applet implements Runnable, KeyListener {
    protected static final int time = 1000 / 60; // 1000 ms % 60 frames

    protected final int width;
    protected final int height;

    public BaseGame(int width, int height) {
        super();

        this.width = width;
        this.height = height;

        this.setSize(width, height);
    }
}

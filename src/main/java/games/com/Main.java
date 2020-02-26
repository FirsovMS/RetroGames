package games.com;

import games.com.assets.Pong.PongGame;
import games.com.assets.Snake.SnakeGame;
import games.com.assets.SpaceInvaiders.SpaceInvadersGame;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.util.Scanner;

public class Main {
    private static final String exitCommand = "Q";

    private static final String helloMessage = "Select and run game from the list: \n" +
            "1: Ping-Pong \n" +
            "2: Snake \n" +
            "3: SpaceInvaders \n" +
            exitCommand + "(" + exitCommand.toLowerCase() + ")" + " - to exit";

    public static void main(String[] args) {
        try (Scanner stdin = new Scanner(System.in)) {
            while (true) {
                System.out.println(helloMessage);


                String input = stdin.next().replaceAll("\\s+", "");
                if (!input.isEmpty()) {
                    if (input.equalsIgnoreCase(exitCommand)) {
                        break;
                    }

                    int number = Integer.parseInt(input);
                    switch (number) {
                        case 1:
                            // run pong
                            RunGame(new PongGame(800, 600));
                            break;
                        case 2:
                            // run snake
                            RunGame(new SnakeGame(800, 600));
                            break;
                        case 3:
                            // run invaders
                            RunGame(new SpaceInvadersGame(800, 600));
                            break;
                    }
                }
            }
        }
    }

    public static void RunGame(Applet applet) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setSize(applet.getSize());

        frame.add(applet, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        applet.init();
    }
}

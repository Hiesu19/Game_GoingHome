
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Avatar {
    Map lab = new Map();
    Sound sound = new Sound();

    public int x = 32;
    public int y = 32;

    int movement = 32;
    public BufferedImage cat = null;

    public int lv = 1;

    public void playSound(int i) {
        sound.setFile(i);
        sound.play();
    }

    public void paint(Graphics grafico) {
        try {
            File c = new File("./src/image/cat.png");
            cat = ImageIO.read(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
        grafico.drawImage(cat, x, y, 32, 32, null);
        // System.out.print(x + " ");
        // System.out.println(y);
    }

    public void keyKey(KeyEvent event) {
        int[][] map = lab.getMap(Map.randomMap[Game.getLevel() - 1]);

        if (event.getKeyCode() == 37) {
            if (map[y / 32][(x / 32) - 1] != 1) {
                x = x - movement;
            }
        }
        if (event.getKeyCode() == 39) {
            if (map[y / 32][(x / 32) + 1] != 1) {

                x = x + movement;
                map[y / 32][(x / 32)] = 1;

            }
        }
        if (event.getKeyCode() == 40) {
            if (map[(y / 32) + 1][x / 32] != 1) {
                y = y + movement;
            }
        }
        if (event.getKeyCode() == 38) {
            if (map[(y / 32) - 1][x / 32] != 1) {
                map[(y / 32)][x / 32] = 1;
                y = y - movement;
            }
        }

        if (x == 1088 && y == 704) {
            Game.changeLevel();
            lv++;
            playSound(1);
            x = 32;
            y = 32;
        }
    }
}

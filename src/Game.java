
import java.awt.Color;

import java.awt.Graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

import javax.swing.JPanel;

public class Game extends JPanel {
    Map map = new Map();
    Avatar avatar = new Avatar();
    static Sound sound = new Sound();

    public static int musicIndex = MrRandom.randomIntSound();
    public static Color[] colorsBackground = { MrRandom.randomColorBG(), MrRandom.randomColorBG(),
            MrRandom.randomColorBG(), MrRandom.randomColorBG(), MrRandom.randomColorBG() };

    public static void playMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public static int level = 1;
    public static long startTime;
    public static long nowTime;

    int sc;

    public Game() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                avatar.keyKey(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });
        setFocusable(true);
    }

    public void paint(Graphics grafico) {
        if (level <= 3) {
            map.paint(grafico);
            avatar.paint(grafico);
        } else if (level == 4) {
            map.paintMoon(grafico, avatar.x, avatar.y, 0, 3);
            avatar.paint(grafico);
        } else if (level == 5) {
            map.paintMoon(grafico, avatar.x, avatar.y, 1, 2);
            avatar.paint(grafico);
        } else {
            map.paintMoon(grafico, avatar.x, avatar.y, 1, 1);
            avatar.paint(grafico);
        }

    }

    public static int changeLevel() {
        return level++;
    }

    public static int getLevel() {
        return level;
    }

    public static void resetLevel() {
        level = 1;
    }

    public static void resetTime() {
        startTime = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        System.out.println("Going Home!!");
        Notion notion = new Notion();
        notion.screenStart();
        notion.screenHowToPlay();

        JFrame myWindow = new JFrame("Going Home!!");
        Game game = new Game();
        myWindow.add(game);
        myWindow.setSize(1360, 1000);
        myWindow.setLocation(100, 0);
        myWindow.setVisible(true);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setBackground(colorsBackground[level]);

        startTime = System.currentTimeMillis();
        playMusic(musicIndex);

        while (true) {
            try {
                Thread.sleep(10);
                nowTime = System.currentTimeMillis();
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, "you lose");
            }
            myWindow.repaint();

            // String s = String.valueOf((Game.nowTime - Game.startTime) / 1000);
            if (getLevel() > 6) {
                // JOptionPane.showMessageDialog(null, "Your time:" + s);
                // System.exit(0);
                notion.screenShowTime((nowTime - startTime) / 1000);
                notion.screenEndGame();
            }
        }
    }
}

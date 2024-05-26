import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Notion {

    public JFrame mainFrame;
    public JLabel headerLabel;
    public JLabel statusLabel;
    public JPanel controlPanel;

    public void screenStart() {
        Object[] options = { "Tiếp theo" };
        ImageIcon icon = new ImageIcon("./src/image/g3.gif");
        int n = JOptionPane.showOptionDialog(null, "", "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                icon,
                options,
                options[0]);
        if (n == JOptionPane.CLOSED_OPTION) {
            System.exit(0);
        }

    }

    public void screenHowToPlay() {
        Object[] options = { "Start !!" };
        ImageIcon icon = new ImageIcon("./src/image/howtoplay.png");
        int n = JOptionPane.showOptionDialog(null, "", "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                icon,
                options,
                options[0]);
        if (n == JOptionPane.CLOSED_OPTION) {
            System.exit(0);
        }
    }

    public void screenEndGame() {

        Object[] options = { "Thoát", "Chơi lại" };
        ImageIcon icon = new ImageIcon("./src/image/congrat.gif");
        int response = JOptionPane.showOptionDialog(null, "", "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                icon,
                options,
                options[0]);
        if (response == JOptionPane.YES_OPTION) {
            System.exit(0); // Đóng chương trình
        }
        if (response == JOptionPane.NO_OPTION) {
            System.out.print("OK");
            Game.resetLevel();
            Game.resetTime();
            Map.randomMap = MrRandom.randomMap();
            screenStart();
        }
        if (response == JOptionPane.CLOSED_OPTION) {
            System.exit(0);
        }
    }

    public void screenShowTime(long i) {
        String s = String.valueOf(i);
        String res = "Thời gian vượt qua:  " + s;
        JOptionPane.showMessageDialog(null,
                res,
                "Siuuuuu !!",
                JOptionPane.INFORMATION_MESSAGE);
    }
}

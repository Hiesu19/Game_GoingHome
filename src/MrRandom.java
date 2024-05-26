import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MrRandom {

    public Color randomColor() {
        Color[] fixedColors = {
                Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.CYAN, Color.MAGENTA, Color.PINK,
                Color.LIGHT_GRAY
        };
        Random random = new Random();
        int randomIndex = random.nextInt(fixedColors.length);
        return fixedColors[randomIndex];
    }

    public static int randomIntSound() {
        int musicList[] = { 0, 2, 3, 4 };
        Random random = new Random();
        int randomIndex = random.nextInt(musicList.length);
        return musicList[randomIndex];
    }

    public static Color randomColorBG() {
        Color[] fixedColors = {
                Color.BLACK, Color.WHITE
        };
        Random random = new Random();
        int randomIndex = random.nextInt(fixedColors.length);
        return fixedColors[randomIndex];
    }

    public static int[] randomMap() {
        int numOfMap = 8;
        List<Integer> numbers = new ArrayList<>(numOfMap);
        for (int i = 1; i <= numOfMap; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        int res[] = new int[7];
        for (int i = 0; i < 7; i++) {
            res[i] = numbers.get(i);
        }
        return res;
    }

}
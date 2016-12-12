import java.lang.Integer;
import java.util.ArrayList;

public class PathCalculator {

    public int calculatePathLength(ArrayList<String> directions) {
        int compassPoint = 0; // 0 is north, 1 is east, 2 is south, 3 is west
        int blocksNorth = 0;
        int blocksEast = 0;
        int[] lastPos = {0, 0};
        char[] lastTwoTurns = {'', ''};
        for (String direction : directions) {
            char turn = direction.charAt(0);
            if (turn == 'R') {
                compassPoint = (compassPoint + 5) % 4;
            }
            if (turn == 'L') {
                compassPoint = (compassPoint + 3) % 4;
            }
            int blocksWalked = Integer.parseInt(direction.substring(1));
            switch (compassPoint) {
            case 0:
                blocksNorth = blocksNorth + blocksWalked;
                break;
            case 1:
                blocksEast = blocksEast + blocksWalked;
                break;
            case 2:
                blocksNorth = blocksNorth - blocksWalked;
                break;
            case 3:
                blocksEast = blocksEast - blocksWalked;
                break;
            }
        }
    }
}

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        FileParser f = new FileParser();
        PathCalculator p = new PathCalculator();
        ArrayList<String> directions = f.parseFile("directions.txt");
        int pathLength = p.calculatePathLength(directions);
        System.out.println(pathLength);
    }
}

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Day6 {
    public static void main(String[] args) {
        ArrayList<String> fileData = Utility.getFileData("src/Day6Input.txt");

        ArrayList<ArrayList<String>> map = new ArrayList<>();

        for (String line : fileData) {
            map.add(new ArrayList<>(Arrays.asList(line.split(""))));
        }

//        for (ArrayList<String> row : map) {
//            System.out.println(row);
//        }

        Point guardPosition = new Point();
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                if (map.get(i).get(j).equals("^")) {
                    guardPosition.x = j;
                    guardPosition.y = i;
                }
            }
        }
        Direction guardDirection = new Direction(0, -1);

        while (guardPosition.x < map.get(0).size() && guardPosition.x > 0 && guardPosition.y < map.size() && guardPosition.y > 0)
    }
}

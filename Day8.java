import java.awt.*;
import java.util.ArrayList;

public class Day8 {
    public static void main(String[] args) {
        ArrayList<String> fileData = Utility.getFileData("src/Day8Input.txt");
        ArrayList<String[]> map = new ArrayList<>();

        // Make map
        for (String line : fileData) {
            map.add(line.split(""));
        }

        ArrayList<Antenna> antennas = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).length; j++) {
                if (!map.get(i)[j].equals(".")) {
                    antennas.add(new Antenna(map.get(i)[j], new Point(j, i)));
                }
            }
        }

        for (int i = 0; i < antennas.size(); i++) {
            Antenna antenna = antennas.get(i);
            for (int j = i + 1; j < antennas.size(); j++) {
                Antenna secondAntenna = antennas.get(j);
                if (antenna.frequency.equals(secondAntenna.frequency)) {
                    int rise = secondAntenna.location.y - antenna.location.y;
                    int run = secondAntenna.location.x - antenna.location.x;

                    if (validPoint(antenna.location.x - run, antenna.location.y - rise, map)) {
                        map.get(antenna.location.y - rise)[antenna.location.x - run] = "#";
                    }
                    if (validPoint(secondAntenna.location.x + run, secondAntenna.location.y + rise, map)) {
                        map.get(secondAntenna.location.y + rise)[secondAntenna.location.x + run] = "#";
                    }
                }
            }
        }

        int antiNodes = 0;
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).length; j++) {
                System.out.print(map.get(i)[j]);
                if (map.get(i)[j].equals("#")) {
                    antiNodes++;
                }
            }
            System.out.println();
        }
        System.out.println(antiNodes);
    }

    public static boolean validPoint(int x, int y, ArrayList<String[]> map) {
        return x < map.get(0).length && x >= 0 && y < map.size() && y >= 0;
    }
}

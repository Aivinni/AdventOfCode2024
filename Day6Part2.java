import java.awt.*;
import java.util.ArrayList;

public class Day6Part2 {
    public static void main(String[] args) {
        ArrayList<String> fileData = Utility.getFileData("src/Day6Input.txt");
        ArrayList<String[]> map = new ArrayList<>();

        // Make map
        for (String line : fileData) {
            map.add(line.split(""));
        }

        // Get guard position
        Point guardPosition = new Point();
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).length; j++) {
                if (map.get(i)[j].equals("^")) {
                    guardPosition.x = j;
                    guardPosition.y = i;
                }
            }
        }

        // Solve once
        Direction guardDirection = new Direction(0, -1);
        boolean guardOnMap = guardPosition.x < map.get(0).length - 1 && guardPosition.x > 0 && guardPosition.y < map.size() - 1 && guardPosition.y > 0;
        Point guardStartPosition = new Point(guardPosition.x, guardPosition.y);
        map.get(guardStartPosition.y)[guardStartPosition.x] = "W";
        while (guardOnMap) {
            guardPosition.x += guardDirection.x;
            guardPosition.y += guardDirection.y;
            if (map.get(guardPosition.y)[guardPosition.x].equals("#")) {
                guardPosition.x -= guardDirection.x;
                guardPosition.y -= guardDirection.y;
                guardDirection.changeDirection(Math.PI / 2);
            } else {
                if (map.get(guardPosition.y)[guardPosition.x].equals("W") && guardDirection.angle * (180 / Math.PI) == 270.0) {
                    break;
                } else if (map.get(guardPosition.y)[guardPosition.x].equals("A") && guardDirection.angle * (180 / Math.PI) == 180.0) {
                    break;
                } else if (map.get(guardPosition.y)[guardPosition.x].equals("S") && guardDirection.angle * (180 / Math.PI) == 90.0) {
                    break;
                } else if (map.get(guardPosition.y)[guardPosition.x].equals("D") && guardDirection.angle * (180 / Math.PI) == 0.0) {
                    break;
                }

                if (guardDirection.angle * (180 / Math.PI) == 270.0) {
                    map.get(guardPosition.y)[guardPosition.x] = "W";
                } else if (guardDirection.angle * (180 / Math.PI) == 180.0) {
                    map.get(guardPosition.y)[guardPosition.x] = "A";
                } else if (guardDirection.angle * (180 / Math.PI) == 90.0) {
                    map.get(guardPosition.y)[guardPosition.x] = "S";
                } else if (guardDirection.angle * (180 / Math.PI) == 0.0) {
                    map.get(guardPosition.y)[guardPosition.x] = "D";
                }
            }
            guardOnMap = guardPosition.x < map.get(0).length - 1 && guardPosition.x > 0 && guardPosition.y < map.size() - 1 && guardPosition.y > 0;
        }


        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).length; j++) {
                System.out.print(map.get(i)[j]);
            }
            System.out.println();
        }

        int numXs = 0;
        ArrayList<Point> xPoints = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).length; j++) {
                if (map.get(i)[j].equals("W") || map.get(i)[j].equals("A") || map.get(i)[j].equals("S") || map.get(i)[j].equals("D")) {
                    numXs++;
                    xPoints.add(new Point(j, i));
                }
            }
        }

        System.out.println(numXs);

        // reset
        map = new ArrayList<>();
        for (String line : fileData) {
            map.add(line.split(""));
        }



        int loopTimes = 0;
        for (int i = 0; i < numXs; i++) {
            map.get(xPoints.get(i).y)[xPoints.get(i).x] = "#";
            guardPosition = new Point(guardStartPosition.x, guardStartPosition.y);
            guardOnMap = guardPosition.x < map.get(0).length - 1 && guardPosition.x > 0 && guardPosition.y < map.size() - 1 && guardPosition.y > 0;
            guardDirection = new Direction(0, -1);
            map.get(guardStartPosition.y)[guardStartPosition.x] = "X";
                while (guardOnMap) {
                    guardPosition.x += guardDirection.x;
                    guardPosition.y += guardDirection.y;
                    if (map.get(guardPosition.y)[guardPosition.x].equals("#")) {
                        guardPosition.x -= guardDirection.x;
                        guardPosition.y -= guardDirection.y;
                        guardDirection.changeDirection(Math.PI / 2);
//                        System.out.println(guardDirection.angle);
                    } else {
                        if (map.get(guardPosition.y)[guardPosition.x].equals("W") && guardDirection.angle * (180 / Math.PI) == 270.0) {
                            loopTimes++;
                            break;
                        } else if (map.get(guardPosition.y)[guardPosition.x].equals("A") && guardDirection.angle * (180 / Math.PI) == 180.0) {
                            loopTimes++;
                            break;
                        } else if (map.get(guardPosition.y)[guardPosition.x].equals("S") && guardDirection.angle * (180 / Math.PI) == 90.0) {
                            loopTimes++;
                            break;
                        } else if (map.get(guardPosition.y)[guardPosition.x].equals("D") && guardDirection.angle * (180 / Math.PI) == 0.0) {
                            loopTimes++;
                            break;
                        }

                        if (guardDirection.angle * (180 / Math.PI) == 270.0) {
                            map.get(guardPosition.y)[guardPosition.x] = "W";
                        } else if (guardDirection.angle * (180 / Math.PI) == 180.0) {
                            map.get(guardPosition.y)[guardPosition.x] = "A";
                        } else if (guardDirection.angle * (180 / Math.PI) == 90.0) {
                            map.get(guardPosition.y)[guardPosition.x] = "S";
                        } else if (guardDirection.angle * (180 / Math.PI) == 0.0) {
                            map.get(guardPosition.y)[guardPosition.x] = "D";
                        }
                    }
                    guardOnMap = guardPosition.x < map.get(0).length - 1 && guardPosition.x > 0 && guardPosition.y < map.size() - 1 && guardPosition.y > 0;
                }
//                for (int j = 0; j < map.size(); j++) {
//                    for (int k = 0; k< map.get(j).length; k++) {
//                        System.out.print(map.get(j)[k]);
//                    }
//                    System.out.println();
//                }
                System.out.println();
                System.out.println();
                map = new ArrayList<>();
                for (String line : fileData) {
                    map.add(line.split(""));
                }
        }

        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).length; j++) {
                System.out.print(map.get(i)[j]);
            }
            System.out.println();
        }

        System.out.println(numXs);
        System.out.println(loopTimes);
    }
}

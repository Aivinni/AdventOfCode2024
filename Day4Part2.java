import java.util.ArrayList;


public class Day4Part2 {
    public static void main(String[] args) {
        ArrayList<String> data = Utility.getFileData("src/Day4Input.txt");
        ArrayList<String[]> data2D = new ArrayList<>();
        // Copy data to data2D
        for (String datum : data) {
            data2D.add(datum.split(""));
        }

        String[][] arraySearch2D =  new String[data.size()][data2D.get(0).length];
        // Copy data2D to arraySearch2D
        for (int i = 0; i < data2D.size(); i++) {
            arraySearch2D[i] = data2D.get(i);
        }

        int timesFound = 0;
        String[] searchString = {"M", "A", "S"};
        for (int i = 0; i < arraySearch2D.length; i++) {
            for (int j = 0; j < arraySearch2D[i].length; j++) {
                boolean[] found = {false, false, false};
                if (arraySearch2D[i][j].equals("A")) {
                    found[1] = true;
                }
                if (found[1]) {
                    boolean makesX = false;
                    int prevAngle = -1;
                    Direction direction = new Direction();
                    for (int k = 0; k < searchString.length; k++) {
                        boolean validIndex = true;

                        int searchX = j + (direction.x * (k - 1));
                        if (searchX < 0 || searchX > arraySearch2D[i].length - 1) {
                            validIndex = false;
                        }
                        int searchY = i + (direction.y * (k - 1));
                        if (searchY < 0 || searchY > arraySearch2D.length - 1) {
                            validIndex = false;
                        }

                        if (validIndex) {
                            System.out.println("LOOKING FOR: " + searchString[k]);
                            System.out.println("AT: X=" + searchX + " Y=" + searchY);
                            System.out.println("FOUND: " + arraySearch2D[searchY][searchX]);
                            System.out.println(direction.angle * (180 / Math.PI));
                            if (arraySearch2D[searchY][searchX].equals(searchString[k])) {
                                found[k] = true;
                                if (allTrue(found)) {
                                    if (prevAngle != -1 && !makesX) {
                                        timesFound++;
                                        makesX = true;
                                    } else {
                                        prevAngle = (int) direction.angle;
                                    }
                                    shiftDirection(direction);
                                    k = -1;
                                    found = new boolean[]{false, true, false};
                                    if (direction.x == 1 && direction.y == 1) {
                                        break;
                                    }
                                }
                            } else {
                                shiftDirection(direction);
                                k = -1;
                                found = new boolean[]{false, true, false};
                                if (direction.x == 1 && direction.y == 1) {
                                    break;
                                }
                            }
                        } else {
                            shiftDirection(direction);
                            k = 0;
                            found = new boolean[]{false, true, false};
                            if (direction.x == 1 && direction.y == 1) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(timesFound);
    }

    private static void shiftDirection(Direction direction) {
        direction.angle += (Math.PI / 2);
        direction.x = (int) Math.round(Math.cos(direction.angle));
        direction.y = (int) Math.round(Math.sin(direction.angle));
    }

    private static boolean allTrue (boolean[] arr) {
        for (boolean bool : arr) {
            if (!bool) {
                return false;
            }
        }
        return true;
    }
}

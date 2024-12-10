import java.util.ArrayList;


public class Day4 {
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
        String[] searchString = {"X", "M", "A", "S"};
        for (int i = 0; i < arraySearch2D.length; i++) {
            for (int j = 0; j < arraySearch2D[i].length; j++) {
                boolean[] found = {false, false, false, false};
                if (arraySearch2D[i][j].equals("X")) {
                    found[0] = true;
                }
                if (found[0]) {
                    Direction direction = new Direction();
                    for (int k = 1; k < searchString.length; k++) {
                        boolean validIndex = true;

                        int searchX = j + (direction.x * k);
                        if (searchX < 0 || searchX > arraySearch2D[i].length - 1) {
                            validIndex = false;
                        }
                        int searchY = i + (direction.y * k);
                        if (searchY < 0 || searchY > arraySearch2D.length - 1) {
                            validIndex = false;
                        }

                        if (validIndex) {
                            if (arraySearch2D[searchY][searchX].equals(searchString[k])) {
                                found[k] = true;
                                if (found[3]) {
                                    timesFound++;
                                    changeDirection(direction);
                                    k = 0;
                                    found = new boolean[]{true, false, false, false};
                                    if (direction.x == 1 && direction.y == 0) {
                                        break;
                                    }
                                }
                            } else {
                                changeDirection(direction);
                                k = 0;
                                found = new boolean[]{true, false, false, false};
                                if (direction.x == 1 && direction.y == 0) {
                                    break;
                                }
                            }
                        } else {
                            changeDirection(direction);
                            k = 0;
                            found = new boolean[]{true, false, false, false};
                            if (direction.x == 1 && direction.y == 0) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(timesFound);
    }

    private static void changeDirection(Direction direction) {
        direction.angle += (Math.PI / 4);
        direction.x = (int) Math.round(Math.cos(direction.angle));
        direction.y = (int) Math.round(Math.sin(direction.angle));
    }
}

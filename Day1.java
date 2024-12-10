import java.util.ArrayList;
import java.util.Collections;

public class Day1 {
    public static void main(String[] args) {
        ArrayList<String> fileData = Utility.getFileData("src/Day1Input.txt");
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (String line : fileData) {
            String[] lineData = line.split("   ");
            list1.add(Integer.parseInt(lineData[0]));
            list2.add(Integer.parseInt(lineData[1]));
        }
        Collections.sort(list1);
        Collections.sort(list2);
        int totalDistance = 0;
        if (list1.size() == list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                totalDistance += Math.abs(list2.get(i) - list1.get(i));
            }
        }
        System.out.println(totalDistance);

        // Part 2

        int similarityScore = 0;

        for (int number : list1) {
            for (int number2 : list2) {
                if (number == number2) {
                    similarityScore += number;
                }
            }
        }

        System.out.println(similarityScore);
    }
}

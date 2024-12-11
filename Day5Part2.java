import java.util.ArrayList;

public class Day5Part2 {
    public static void main(String[] args) {
        ArrayList<String> rulesData = Utility.getFileData("src/Day5Rules.txt");
        ArrayList<String> updatesData = Utility.getFileData("src/Day5Updates.txt");

        ArrayList<int[]> rules = new ArrayList<>();
        for (String line : rulesData) {
            int[] rule = Utility.stringArrayListToIntArray(line.split(" "));
            rules.add(rule);
        }

//        for (int i = 0; i < rules.size(); i++) {
//            for (int j = 0; j < rules.get(i).length; j++) {
//                System.out.print(rules.get(i)[j] + " ");
//            }
//            System.out.println();
//        }

        ArrayList<ArrayList<Integer>> updates = new ArrayList<>();
        for (String line : updatesData) {
            ArrayList<Integer> update = new ArrayList<>();
            String[] lineSplit = line.split(",");
            for (String x : lineSplit) {
                update.add(Integer.parseInt(x));
            }
            updates.add(update);
        }

//        for (int i = 0; i < updates.size(); i++) {
//            for (int j = 0; j < updates.get(i).length; j++) {
//                System.out.print(updates.get(i)[j] + " ");
//            }
//            System.out.println();
//        }

        ArrayList<ArrayList<Integer>> successfulUpdates = new ArrayList<>();

        for (int i = 0; i < updates.size(); i++) {
            boolean success = true;
            ArrayList<Integer> update = updates.get(i);
            for (int j = 0; j < rules.size(); j++) {
                if (contains(updates.get(i), rules.get(j)[0])) {
                    if (contains(updates.get(i), rules.get(j)[1])) {
                        if (indexOf(updates.get(i), rules.get(j)[0]) > indexOf(updates.get(i), rules.get(j)[1])) {
                            System.out.println(update);
                            int firstTerm = update.remove(indexOf(updates.get(i), rules.get(j)[0]));
                            System.out.println("Rule 1: " + rules.get(j)[0]);
                            System.out.println("First Term: " + firstTerm);
                            System.out.println("Rule 2: " + rules.get(j)[1]);
                            System.out.println("Second Term: " + updates.get(i).get(indexOf(updates.get(i), rules.get(j)[1])));
                            update.add(indexOf(update, rules.get(j)[1]), firstTerm);
                            System.out.println(update);
                            System.out.println();
                            j = -1;
                            success = false;
                        }
                    }
                }
            }
            if (!success) {
                successfulUpdates.add(update);
            }
        }

        int totalMiddle = 0;

        for (int i = 0; i < successfulUpdates.size(); i++) {
            totalMiddle += successfulUpdates.get(i).get(successfulUpdates.get(i).size() / 2);
        }

        System.out.println(totalMiddle);
    }

    private static boolean contains(ArrayList<Integer> arr, int search) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == search) {
                return true;
            }
        }
        return false;
    }

    private static int indexOf(ArrayList<Integer> arr, int search) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == search) {
                return i;
            }
        }
        return -1;
    }
}

import java.util.ArrayList;

public class Day5 {
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

        ArrayList<int[]> updates = new ArrayList<>();
        for (String line : updatesData) {
            int[] update = Utility.stringArrayListToIntArray(line.split(","));
            updates.add(update);
        }

//        for (int i = 0; i < updates.size(); i++) {
//            for (int j = 0; j < updates.get(i).length; j++) {
//                System.out.print(updates.get(i)[j] + " ");
//            }
//            System.out.println();
//        }

        ArrayList<int[]> successfulUpdates = new ArrayList<>();

        for (int i = 0; i < updates.size(); i++) {
            boolean success = true;
            for (int j = 0; j < rules.size(); j++) {
                if (contains(updates.get(i), rules.get(j)[0])) {
                    if (contains(updates.get(i), rules.get(j)[1])) {
                        if (indexOf(updates.get(i), rules.get(j)[0]) > indexOf(updates.get(i), rules.get(j)[1])) {
                            success = false;
                        }
                    }
                }
            }
            if (success) {
                successfulUpdates.add(updates.get(i));
            }
        }

        int totalMiddle = 0;

        for (int i = 0; i < successfulUpdates.size(); i++) {
            totalMiddle += successfulUpdates.get(i)[successfulUpdates.get(i).length / 2];
        }

        System.out.println(totalMiddle);
    }

    private static boolean contains(int[] arr, int search) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == search) {
                return true;
            }
        }
        return false;
    }

    private static int indexOf(int[] arr, int search) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == search) {
                return i;
            }
        }
        return -1;
    }
}

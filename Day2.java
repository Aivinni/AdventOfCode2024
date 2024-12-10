import java.util.ArrayList;

public class Day2 {
    public static void main(String[] args) {
        ArrayList<String> fileData = Utility.getFileData("src/Day2Input.txt");

        int unsafeReports = 0;
        int safeReports = 0;

        for (String line : fileData) {
            String[] reportLine = line.split(" ");
            ArrayList<Integer> report = new ArrayList<>();
            for (String data : reportLine) {
                report.add(Integer.parseInt(data));
            }

            int pattern = 0;
            for (int i = 1; i < report.size(); i++) {
                if ((int) report.get(i) != report.get(0)) {
                    if (report.get(i) - report.get(0) > 0) {
                        pattern = 1;
                    } else if (report.get(i) - report.get(0) < 0) {
                        pattern = -1;
                    }
                }
            }

            boolean dampenerTriggered = false;
            for (int i = 1; i < report.size(); i++) {
                int difference = report.get(i) - report.get(i - 1);
                if (!(pattern * difference > 0 && Math.abs(difference) <= 3)) {
                    dampenerTriggered = true;
                    break;
                } else {
                    if (i == report.size() - 1) {
                        System.out.println("SAFE:");
                        System.out.println(report);
                        System.out.println();
                        safeReports++;
                    }
                }
            }

            if (dampenerTriggered) {
                boolean iterationSafe = true;
                for (int i = 0; i < report.size(); i++) {
                    ArrayList<Integer> copy = Utility.copyArr(report);
                    copy.remove(i);
                    for (int j = 1; j < copy.size(); j++) {
                        int difference2 = copy.get(j) - copy.get(j - 1);
                        pattern = 0;
                        for (int k = 1; k < copy.size(); k++) {
                            if ((int) copy.get(k) != copy.get(0)) {
                                if (copy.get(k) - copy.get(0) > 0) {
                                    pattern = 1;
                                } else if (copy.get(k) - copy.get(0) < 0) {
                                    pattern = -1;
                                }
                            }
                        }
                        if (!(pattern * difference2 > 0 && Math.abs(difference2) <= 3)) {
                            System.out.println(copy);
                            iterationSafe = false;
                            break;
                        } else if (j == copy.size() - 1) {
                            System.out.println("SAFE: " + copy);
                            iterationSafe = true;
                            break;
                        }
                    }
                    if (iterationSafe) {
                        safeReports++;
                        break;
                    }
                }
                System.out.println();
            }
        }
        System.out.println(unsafeReports);
        System.out.println(safeReports);
    }
}

import java.util.ArrayList;
import java.util.Arrays;

public class Day7 {
    public static void main(String[] args) {
        // Get data
        ArrayList<String> fileData = Utility.getFileData("src/Day7Input.txt");
        ArrayList<String[]> unparsedData = new ArrayList<>();
        for (String fileDatum : fileData) {
            unparsedData.add(fileDatum.split(":"));
        }

        // Convert data to ArrayLists
        ArrayList<Long> solutions = new ArrayList<>();
        ArrayList<ArrayList<Integer>> inputs = new ArrayList<>();
        for (int i = 0; i < unparsedData.size(); i++) {
            String[] line = unparsedData.get(i);
            solutions.add(Long.parseLong(line[0]));

            String[] lineInput = line[1].split(" ");
            inputs.add(new ArrayList<>());
            for (String s : lineInput) {
                inputs.get(i).add(Integer.parseInt(s));
            }
        }
//        for (int i = 0; i < solutions.size(); i++) {
//            System.out.print(solutions.get(i));
//            System.out.print(": ");
//            System.out.print(inputs.get(i));
//            System.out.println();
//
        ArrayList<char[]> operations = new ArrayList<>();
        for (ArrayList<Integer> input : inputs) {
            operations.add(Utility.decimalToBinary(0, input.size() - 1).toCharArray());
        }

//        for (int i = 0; i < operations.size(); i++) {
//            System.out.println(operations.get(i));
//        }

        long calibrationResult = 0;
        for (int i = 0; i < solutions.size(); i++) {
            ArrayList<Integer> input = inputs.get(i);
            int operationValue = 0;
            char[] operationList = operations.get(i);

            boolean allOperationsTested = false;


            while (!allOperationsTested) {
                long output = 0;
                output += input.get(0);
                System.out.println("Operation: " + Arrays.toString(operationList));
                System.out.println(operationValue);
                System.out.println(input);
                for (int j = 0; j < operationList.length; j++) {
                    switch (operationList[j]) {
                        case '0' -> output += input.get(j + 1);
                        case '1'-> output *= input.get(j + 1);
                    }
                }
                System.out.println("Output: " + output);
                System.out.println("Target: " +solutions.get(i));
                if (output == solutions.get(i)) {
                    calibrationResult += solutions.get(i);
                    break;
                } else {
                    operationValue++;
                    operationList = Utility.decimalToBinary(operationValue, input.size() - 1).toCharArray();
                    if (operationValue >= Math.pow(2, operationList.length) || operationList.length >= input.size()) {
                        allOperationsTested = true;
                    }
                }
            }
        }

        System.out.println(calibrationResult);
    }
}

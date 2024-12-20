import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utility {
    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }

    public static int binarySearch(ArrayList<Integer> data, int searchNum) {
        int searchIdx = data.size() / 2;
        int searchesMade = 0;
        int count = 0;
        while (!(data.get(searchIdx) == searchNum)) {
            if (data.get(searchIdx) < searchNum) {

            }
        }


        return count;
    }

    public static ArrayList<Integer> copyArr(ArrayList<Integer> arr) {
        ArrayList<Integer> newArr = new ArrayList<>();
        for (Integer num : arr) {
            newArr.add(num);
        }
        return newArr;
    }

    public static int[] stringArrayListToIntArray(ArrayList<String> arr) {
        int[] returnArr = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            returnArr[i] = Integer.parseInt(arr.get(i) );
        }
        return returnArr;
    }

    public static int[] stringArrayListToIntArray(String[] arr) {
        int[] returnArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            returnArr[i] = Integer.parseInt(arr[i]);
        }
        return returnArr;
    }

    public static String convertBase(String input, int inputBase, int targetBase) {
        // Splits the input string into something usable by the program
        String[] inputList = input.split(", ");

        // converts input string into decimal
        int decimal = 0;
        for (String digit : inputList) {
            int number = Integer.parseInt(digit.split(" ")[0]) * (int) (Math.pow(inputBase, Integer.parseInt(digit.split("\\^")[1])));
            decimal += number;
        }

        // converts number to the target base, as an array
        ArrayList<Integer> finalList = new ArrayList<>();
        int remainder;
        while (decimal > 0) {
            remainder = decimal % targetBase;
            decimal /= targetBase;
            finalList.add(0, remainder);
        }

        // Make a String in the proper format and return it
        StringBuilder returnString = new StringBuilder();
        while (!finalList.isEmpty()) {
            returnString.append(finalList.get(0)).append(" ").append(targetBase).append("^").append(finalList.size() - 1).append(", ");
            finalList.remove(0);
        }

        return returnString.toString();
    }

    public static String decimalToBinary(String input) {
        int decimal = Integer.parseInt(input);

        // converts number to the target base, as an array
        ArrayList<Integer> finalList = new ArrayList<>();
        int remainder;
        while (decimal > 0) {
            remainder = decimal % 2;
            decimal /= 2;
            finalList.add(0, remainder);
        }

        // Make a String in the proper format and return it
        StringBuilder returnString = new StringBuilder();
        while (!finalList.isEmpty()) {
            returnString.append(finalList.get(0));
            finalList.remove(0);
        }

        return returnString.toString();
    }

    public static String decimalToBinary(int input, int minPlaces) {
        int decimal = input;

        // converts number to the target base, as an array
        ArrayList<Integer> finalList = new ArrayList<>();
        int remainder;
        while (decimal > 0) {
            remainder = decimal % 2;
            decimal /= 2;
            finalList.add(0, remainder);
        }

        // Make a String in the proper format and return it
        StringBuilder returnString = new StringBuilder();
        while (!finalList.isEmpty()) {
            returnString.append(finalList.get(0));
            finalList.remove(0);
        }

        String finalString = returnString.toString();
        while (finalString.length() < minPlaces) {
            finalString = "0" + finalString;
        }

        return finalString;
    }

    public static String decimalToTertiary(int input, int minPlaces) {
        int decimal = input;

        // converts number to the target base, as an array
        ArrayList<Integer> finalList = new ArrayList<>();
        int remainder;
        while (decimal > 0) {
            remainder = decimal % 3;
            decimal /= 3;
            finalList.add(0, remainder);
        }

        // Make a String in the proper format and return it
        StringBuilder returnString = new StringBuilder();
        while (!finalList.isEmpty()) {
            returnString.append(finalList.get(0));
            finalList.remove(0);
        }

        String finalString = returnString.toString();
        while (finalString.length() < minPlaces) {
            finalString = "0" + finalString;
        }

        return finalString;
    }
}

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
}
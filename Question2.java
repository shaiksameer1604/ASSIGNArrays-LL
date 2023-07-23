import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question2 {
    public static void main(String[] args) {
        int[] arrNum1 = {1, 2, 4, 5, 6};
        int[] arrNum2 = {1, 2, 3, 5, 6, 8, 10, 11, 14};

        System.out.println("Missing numbers in arrNum1: " + findMissingNumbers(arrNum1));
        System.out.println("Missing numbers in arrNum2: " + findMissingNumbers(arrNum2));
    }

    public static List<Integer> findMissingNumbers(int[] arrNum) {
        Arrays.sort(arrNum);
        List<Integer> missingNumbers = new ArrayList<>();

        int start = arrNum[0];
        int end = arrNum[arrNum.length - 1];

        for (int i = start + 1; i < end; i++) {
            if (!contains(arrNum, i)) {
                missingNumbers.add(i);
            }
        }

        return missingNumbers;
    }

    public static boolean contains(int[] arr, int num) {
        for (int value : arr) {
            if (value == num) {
                return true;
            }
        }
        return false;
    }
}


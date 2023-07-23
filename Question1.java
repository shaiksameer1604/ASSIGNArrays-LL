import java.util.Arrays;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int[] arrNum = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arrNum[i] = sc.nextInt();
        }

        sc.close();

        try {
            
            int cumulativeMultiple = 1;
            for (int i = 0; i < arrNum.length; i++) {
                cumulativeMultiple *= arrNum[i];
                arrNum[i] = cumulativeMultiple;
            }

            System.out.println("arrNum = " + Arrays.toString(arrNum));
        } catch (ArithmeticException e) {
            System.out.println("An arithmetic exception occurred: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("An array index out of bounds exception occurred: " + e.getMessage());
        }
    }
}

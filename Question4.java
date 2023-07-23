import java.util.Scanner;

public class Question4 {

    public static int countNegativeSubarrays(int[] arr) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int subSum = 0;
            for (int j = i; j < n; j++) {
                subSum += arr[j];
                if (subSum < 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array:");
        int m = sc.nextInt();
        int[] arr = new int[m];
        System.out.println("Enter the elements");
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }
        int result = countNegativeSubarrays(arr);
        System.out.println(result);

        sc.close();
    }
}

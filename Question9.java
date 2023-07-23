import java.util.Deque;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;

public class Question9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input:");
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        int maxUnique = findMaxUniqueIntegers(arr, k);
        System.out.println(maxUnique);
        
        scanner.close();
    }

    public static int findMaxUniqueIntegers(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        Deque<Integer> deque = new ArrayDeque<>();
        int maxUnique = 0;

        for (int num : arr) {
            if (deque.size() >= k) {
                int removedNum = deque.removeFirst();
                if (!deque.contains(removedNum)) {
                    set.remove(removedNum);
                }
            }

            deque.addLast(num);
            set.add(num);

            maxUnique = Math.max(maxUnique, set.size());
        }

        return maxUnique;
    }
}

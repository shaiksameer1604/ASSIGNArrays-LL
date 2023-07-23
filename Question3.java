import java.util.HashMap;
import java.util.Map;

public class Question3 {
    public static void main(String[] args) {
        int[] arrNum = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int singularCount = countSingularSocks(arrNum);
        System.out.println("Count of singular socks = " + singularCount);
    }

    public static int countSingularSocks(int[] arrNum) {
        Map<Integer, Integer> sockCounts = new HashMap<>();
        for (int sockID : arrNum) {
            sockCounts.put(sockID, sockCounts.getOrDefault(sockID, 0) + 1);
        }

        
        int singularCount = 0;
        for (int count : sockCounts.values()) {
            singularCount += count % 2;
        }

        return singularCount;
    }
}

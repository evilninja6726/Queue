package queueDs;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateNumbersWithGivenDigits {
    public static void main(String[] args) {
        generateNumbersWithGivenDigits(10, 6, 7);
    }

    public static void generateNumbersWithGivenDigits(int n, int smallerDigit, int largerDigit) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(Integer.toString(smallerDigit));
        queue.offer(Integer.toString(largerDigit));
        for (int i = 0; i < n; i++) {
            String digit = queue.poll();
            System.out.print(digit + " ");
            queue.offer(digit + Integer.toString(smallerDigit));
            queue.offer(digit + Integer.toString(largerDigit));
        }
    }
}

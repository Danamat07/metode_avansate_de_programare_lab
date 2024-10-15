package lab1;

import java.util.Arrays;

public class ArrayOperations {

    private int[] numbers;

    // constructor
    public ArrayOperations(int[] numbers) {
        this.numbers = numbers;
    }

    // find max nr
    public int findMax() {
        int max = numbers[0];
        for (int nr : numbers)
            if (nr > max)
                max = nr;
        return max;
    }

    // find min nr
    public int findMin() {
        int min = numbers[0];
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    // max sum of n-1 numbers
    public int maxSum() {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        int min = findMin();
        return sum - min;
    }

    // min sum of n-1 numbers
    public int minSum() {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        int max = findMax();
        return sum - max;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 8, 3, 10, 17};
        ArrayOperations array = new ArrayOperations(numbers);
        // display max nr
        System.out.println("Max number: " + array.findMax());
        // display min nr
        System.out.println("Min number: " + array.findMin());
        // display max sum of n-1 nrs
        System.out.println("Max sum of n-1: " + array.maxSum());
        // display min sum of n-1 nrs
        System.out.println("Min sum of n-1: " + array.minSum());
    }
}

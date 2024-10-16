package lab1;

import java.util.Arrays;

public class BigNrOperations {

    public static int[] add(int[] x, int[] y) {
        int len = Math.max(x.length, y.length);
        int[] result = new int[len + 1];
        int carry = 0;
        for (int i=0; i<len; i++) {
            int digit1 = 0;
            int digit2 = 0;
            if (i < x.length)
                digit1 = x[x.length - 1 - i];
            if (i < y.length)
                digit2 = y[y.length - 1 - i];
            // find sum of digits and carry
            int sum = digit1 + digit2 + carry;
            // add in result last digit of sum
            result[result.length - 1 - i] = sum % 10;
            carry = sum / 10;
        }
        if (carry > 0) {
            // add carry to beginning
            result[0] = carry;
            return result;
        }
        // when carry is 0
        int[] final_result = new int[len];
        for (int i = 0; i < final_result.length; i++) {
            final_result[i] = result[i + 1];
        }
        return final_result;
    }

    public static int[] substract(int[] x, int[] y) {
        int[] result = new int[x.length];
        int borrow = 0;
        for (int i = x.length - 1; i >= 0; i--) {
            int sub = x[i] - y[i] - borrow;
            if (sub < 0) {
                sub += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result[i] = sub;
        }
        return result;
    }

    public static int[] multiply(int[] num, int multiplier) {
        int[] result = new int[num.length + 1];
        int carry = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            int product = num[i] * multiplier + carry;
            result[i + 1] = product % 10;
            carry = product / 10;
        }
        result[0] = carry;
        if (result[0] == 0) {
            int[] final_result = new int[num.length];
            for (int i = 0; i < final_result.length; i++) {
                final_result[i] = result[i + 1];
            }
            return final_result;
        }
        return result;
    }

    public static int[] divide(int[] num, int divisor) {
        int[] result = new int[num.length];
        int remain = 0; // restul
        for (int i = 0; i < num.length; i++) {
            // find new nr by adding previous remain
            int current = remain * 10 + num[i];
            result[i] = current / divisor;
            remain = current % divisor; // noul rest
        }
        if (result[0] == 0) {
            int[] final_result = new int[num.length];
            for (int i = 0; i < final_result.length; i++) {
                final_result[i] = result[i + 1];
            }
            return final_result;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num1 = {8, 3, 0, 0, 0, 0, 0, 0, 0};
        int[] num2 = {5, 4, 0, 0, 0, 0, 0, 0, 0};
        // display sum
        int[] sum = add(num1, num2);
        System.out.println("Sum: " + Arrays.toString(sum));
        // display difference
        int[] dif = substract(num1, num2);
        System.out.println("Difference: " + Arrays.toString(dif));
        // display multiply
        int[] mul = multiply(num1, 1);
        System.out.println("Multiplication: " + Arrays.toString(mul));
        // display division
        int[] div = divide(num2, 2);
        System.out.println("Division: " + Arrays.toString(div));
    }
}

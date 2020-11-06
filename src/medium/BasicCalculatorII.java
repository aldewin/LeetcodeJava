package medium;

/**
 * 227. Basic Calculator II
 *
 * https://leetcode.com/problems/basic-calculator-ii/
 */

import java.util.ArrayList;
import java.util.List;

public class BasicCalculatorII {
    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
    }

    public static int calculate(String s) {
        List<Integer> sumNumber = new ArrayList<>();
        char sign = '+';
        int number = 0;
        char[] nums = s.toCharArray();
        for (int i = 0; i < nums.length; i++) {
            char symbol = nums[i];
            if (Character.isDigit(symbol))
                number = number * 10 + Integer.parseInt(String.valueOf(symbol));
            if ((symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/') || i == nums.length - 1) {
                if (sign == '+')
                    sumNumber.add(number);
                else if (sign == '-')
                    sumNumber.add(-number);
                else if (sign == '*')
                    sumNumber.set(sumNumber.size() - 1, sumNumber.get(sumNumber.size() - 1) * number);
                else if(sign == '/')
                    sumNumber.set(sumNumber.size() - 1, sumNumber.get(sumNumber.size() - 1) / number);
                sign = symbol;
                number = 0;
            }
        }
        int sum = 0;
        for (int num : sumNumber) {
            sum += num;
        }
        return sum;
    }
}

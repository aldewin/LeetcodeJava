package easy;

/**
 * 258. Add Digits
 *
 * https://leetcode.com/problems/add-digits/
 */

public class AddDigits {
    public static void main(String[] args) {
        System.out.println(addDigits1(38));
        System.out.println(addDigits2(54));
        System.out.println(addDigits3(78));
        System.out.println(addDigits4(96));
    }


    private static int sumDigits1(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // Runtime: 1 ms, Memory: 36.2 MB
    public static int addDigits1(int num) {
        int ans = sumDigits1(num);
        while (String.valueOf(ans).length() > 1)
            ans = sumDigits1(ans);
        return ans;
    }

    private static int[] sumDigits2(int num) {
        int sum = 0;
        int count = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
            count++;
        }
        return new int[] {sum, count};
    }

    // Runtime: 2 ms, Memory: 37.4 MB
    public static int addDigits2(int num) {
        int[] ans = sumDigits2(num);
        num = ans[0];
        int count = ans[1];
        while (count > 1) {
            ans = sumDigits2(num);
            num = ans[0];
            count = ans[1];
        }
        return num;
    }

    // Runtime: 1 ms, Memory: 36.1 MB
    public static int addDigits3(int num) {
        int ans = 0;
        while (num > 0) {
            ans += num % 10;
            num /= 10;
            if (num == 0 && ans > 9) {
                num = ans;
                ans = 0;
            }
        }
        return ans;
    }

    // Runtime: 1 ms, Memory: 36.1 MB
    public static int addDigits4(int num) {
        if (num == 0)
            return 0;
        int r = num % 9;
        if (r == 0)
            return 9;
        return r;
    }
}

package easy;

import java.util.HashSet;

public class HappyNumber {
    public static  void main(String[] args) {
        System.out.println(isHappy1(7));
        System.out.println(isHappy2(19));
    }

    public static boolean isHappy1(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            n = nextNum(n);
            if (set.contains(n))
                return false;
            set.add(n);
        }
        return true;
    }

    public static boolean isHappy2(int n) {
        int first = n;
        int second = n;
        while (true) {
            first = nextNum(first);
            second = nextNum(nextNum(second));
            if (second == 1)
                return true;
            if (second == first)
                return false;
        }
    }

    private static int nextNum(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }
}

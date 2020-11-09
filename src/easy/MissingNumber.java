package easy;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] {3, 0, 1}));
    }

    // Time Complexity: O(n), Space Complexity: O(1)
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sumProgression = n * (n + 1) / 2;
        for (int num: nums)
            sumProgression -= num;
        return sumProgression;
    }
}

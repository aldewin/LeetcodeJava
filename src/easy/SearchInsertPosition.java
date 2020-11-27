package easy;

public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 5));
    }

    // Runtime(nlogn), Space complexity: O(1)
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target)
                right = mid;
            if (nums[mid] < target)
                left = mid;
        }
        if (nums[left] >= target)
            return left;
        if (nums[right] >= target)
            return right;
        return right + 1;
    }
}

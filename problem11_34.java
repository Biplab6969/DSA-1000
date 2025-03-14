public class problem11_34 {
  public static void main(String[] args) {
    int[] nums = {1, 2, 5, 5, 5, 8, 9, 6};
    int target = 5;
    
    int first = lowerBound(nums, target);
    if (first == -1) {
        System.out.println("-1, -1");
        return;
    }

    int last = upperBound(nums, target);
    System.out.println(first + ", " + last);
}

private static int lowerBound(int[] nums, int target) {
    int low = 0, high = nums.length - 1;
    int first = -1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            first = mid;
            high = mid - 1; // Continue searching in the left half
        } else if (nums[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return first;
}

private static int upperBound(int[] nums, int target) {
    int low = 0, high = nums.length - 1;
    int last = -1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            last = mid;
            low = mid + 1; // Continue searching in the right half
        } else if (nums[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return last;
}
}

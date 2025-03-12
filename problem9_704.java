public class problem9_704 {

  // Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
  public int search(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;


    while (start <= end) {
      int mid = start + (end - start) / 2; // Correct way to calculate mid

      if (nums[mid] == target) {
        return mid; // Return the index, not the target value
      }

      if (nums[mid] > target) {
        end = mid - 1; // Move left
      } else {
        start = mid + 1; // Move right
      }
    }
    return -1; // Target not found
  }

  public static void main(String args[]) {
    problem9_704 sol = new problem9_704(); // Correct instance creation
    int nums[] = {2, 3, 5, 6, 8, 9, 10, 12, 13, 14}; // Sorted array
    int target = 10;
    System.out.println("Index for key is " + sol.search(nums, target));
  }
}

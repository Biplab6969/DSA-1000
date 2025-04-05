public class problem13_153 {
  private static int findMin(int[] nums){
    int start = 0;
    int end = nums.length - 1;
    int mini = Integer.MAX_VALUE;
    while(start <= end){
      int mid = start + (end - start)/2;
      if(nums[start] <= nums[mid]){
        mini = Math.min(nums[start], mini);
        start = mid + 1;
      } else {
        mini = Math.min(mini, nums[mid]);
        end = mid -1;
      }
    }
    return mini;
  }

  public static void main(String[] args) {
    int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
    int min = findMin(nums);
    System.out.println("The minimum element is: " + min );
}
}


// 📘 Detailed Step-by-Step Algorithm
// Function: findMin(int[] nums)
// Step 1: Initialize pointers and minimum variable
// start = 0, end = nums.length - 1

// mini = Integer.MAX_VALUE (used to track the minimum value found so far)

// Step 2: Binary Search Loop (while start <= end)
// Find mid index: mid = start + (end - start) / 2

// Step 3: Determine which half is sorted
// ✅ Case A: Left half is sorted
// Condition: nums[start] <= nums[mid]

// This means elements between start and mid are in order, so the minimum must be among nums[start] or in the right part.

// Update mini = min(mini, nums[start])

// Move right: start = mid + 1

// ✅ Case B: Right half is unsorted
// Else: the pivot is in the left half (including mid)

// Update mini = min(mini, nums[mid])

// Move left: end = mid - 1

// Step 4: After loop ends, return mini
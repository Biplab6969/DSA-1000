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



// Algorithm (Binary Search Approach):
// Initialize Pointers:

// Set start = 0 (beginning of the array).

// Set end = nums.length - 1 (end of the array).

// Loop until start is less than or equal to end:

// Compute the midpoint to avoid overflow:

// 𝑚
// 𝑖
// 𝑑
// =
// 𝑠
// 𝑡
// 𝑎
// 𝑟
// 𝑡
// +
// (
// 𝑒
// 𝑛
// 𝑑
// −
// 𝑠
// 𝑡
// 𝑎
// 𝑟
// 𝑡
// )
// 2
// mid=start+ 
// 2
// (end−start)
// ​
 
// If nums[mid] == target, return mid (index of target found).

// If nums[mid] > target, search the left half by updating end = mid - 1.

// If nums[mid] < target, search the right half by updating start = mid + 1.

// If target is not found, return -1.

// Pseudocode:
// sql
// Copy
// Edit
// FUNCTION search(nums, target):
//     start ← 0
//     end ← length(nums) - 1

//     WHILE start ≤ end:
//         mid ← start + (end - start) / 2   // Calculate mid to prevent overflow

//         IF nums[mid] == target:
//             RETURN mid  // Target found, return index

//         ELSE IF nums[mid] > target:
//             end ← mid - 1  // Search left half

//         ELSE:
//             start ← mid + 1  // Search right half

//     RETURN -1  // Target not found

// // Main Function
// BEGIN
//     nums ← [2, 3, 5, 6, 8, 9, 10, 12, 13, 14]  // Sorted array
//     target ← 10
//     PRINT "Index for key is ", search(nums, target)
// END
// Time & Space Complexity Analysis:
// Time Complexity: 
// 𝑂
// (
// log
// ⁡
// 𝑛
// )
// O(logn)

// The search space is divided by half in each iteration, making it logarithmic.

// Space Complexity: 
// 𝑂
// (
// 1
// )
// O(1)

// Only a few extra variables are used, so it’s constant space.
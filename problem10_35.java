public class problem10_35 {

  // Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
  public int search(int[] nums, int target){
    int start = 0;
    int end = nums.length - 1;
    while (start <= end){
    int mid = start + (end-start) / 2;
    if(nums[mid] == target){
      return mid;
    }
    if(nums[mid] > target){
      end = mid - 1;
    } else {
      start = mid + 1;
    }
  }

    return -1;
  }



  public static void main(String args[]) {
    problem10_35 sol = new problem10_35(); // Correct instance creation
    int nums[] = {2, 3, 5, 6, 8, 9, 10, 12, 13, 14}; // Sorted array
    int target = 10;
    System.out.println("Index for key is " + sol.search(nums, target));
  }
}


// Algorithm (Binary Search Approach)
// Initialize Two Pointers:

// start = 0, end = nums.length - 1

// Perform Binary Search:

// While start ≤ end:

// Compute mid = start + (end - start) / 2 (to prevent integer overflow).

// If nums[mid] == target, return mid (index of the target).

// If nums[mid] > target, search in the left half (end = mid - 1).

// Else, search in the right half (start = mid + 1).

// Return the Insert Position:

// If the loop exits without finding target, return start (position where it should be inserted).

// Pseudocode:
// sql
// Copy
// Edit
// FUNCTION searchInsert(nums, target):
//     start ← 0
//     end ← length(nums) - 1

//     WHILE start ≤ end:
//         mid ← start + (end - start) / 2

//         IF nums[mid] == target:
//             RETURN mid  // Found the target

//         ELSE IF nums[mid] > target:
//             end ← mid - 1  // Search left half

//         ELSE:
//             start ← mid + 1  // Search right half

//     RETURN start  // Insert position if not found


// // Main function
// BEGIN
//     nums ← [2, 3, 5, 6, 8, 9, 10, 12, 13, 14]  // Sorted array
//     target ← 10
//     result ← searchInsert(nums, target)
//     PRINT "Index for key is ", result
// END
// Time & Space Complexity Analysis:
// Time Complexity: O(log N) (Binary Search halves the search space in each iteration).

// Space Complexity: O(1) (Only a few integer variables are used).
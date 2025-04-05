public class problem14_540 {

  private static int singleElement(int[] nums){
    int n = nums.length;
    if(n == 1){
      return nums[0];
    }
    if(nums[0] != nums[1]){
      return nums[0];
    }
    if(nums[n-1] != nums[n-2]){
      return nums[n-1];
    }

    int low = 1;
    int high = n - 2;
    while(low <= high){
     int mid = low + (high - low)/2;
      if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]){
        return nums[mid];
      } 

    if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
        low = mid + 1;
    } else {
        high = mid - 1;
    }
    
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = {1,1,2,3,3,4,4,8,8};
    int single = singleElement(nums);
    System.out.println("The minimum element is: " + single );
}
}


// 📘 Algorithm Explanation (Binary Search)
// Step 1: Handle Base Cases
// Before applying binary search:

// java
// Copy
// Edit
// if(n == 1) return nums[0];                     // Only one element
// if(nums[0] != nums[1]) return nums[0];         // Single is at index 0
// if(nums[n-1] != nums[n-2]) return nums[n-1];   // Single is at the last index
// Step 2: Initialize Binary Search
// java
// Copy
// Edit
// int low = 1;
// int high = n - 2;
// Why 1 and n-2?

// Because index 0 and n-1 are already checked in base cases.

// Step 3: Binary Search Loop
// java
// Copy
// Edit
// while(low <= high){
//     int mid = low + (high - low)/2;
// Step 4: Check if nums[mid] is the single element
// java
// Copy
// Edit
// if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]){
//     return nums[mid];
// }
// This means the current nums[mid] is not part of any pair, so it's the single element ✅

// Step 5: Use Index Pattern to Decide Search Direction
// Here’s the clever trick:

// java
// Copy
// Edit
// if (
//     (mid % 2 == 0 && nums[mid] == nums[mid + 1]) || 
//     (mid % 2 == 1 && nums[mid] == nums[mid - 1])
// ) {
//     // You're on the left side → move right
//     low = mid + 1;
// } else {
//     // You're on the right side → move left
//     high = mid - 1;
// }
// 🔍 Explanation:
// If the index mid is even and the pair continues at mid + 1, it means we are still in the left part → Go right.

// If the index mid is odd and the pair continues at mid - 1, it also means we are in the left part → Go right.

// Otherwise, go left.

// Step 6: Return -1 if not found (edge case)
// After loop, if not returned, just return -1. This theoretically shouldn't happen for valid inputs.


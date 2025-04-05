public class problem12_81 {

  private static boolean search(int[] nums, int target){
    int start = 0;
    int end = nums.length - 1;
    while(start <= end){
      int mid = start + (end - start)/2;
      if(nums[mid] == target){
        return true;
      }

      if(nums[start] == nums[mid] && nums[mid] == nums[end]){
        start += 1;
        end -= 1;
        continue;
       }
      

      if(nums[start] <= nums[mid]){
        if(nums[start] <= target && target <= nums[mid]){
          end = mid - 1;
        } else {
          start = mid + 1;
        }

      } else {
        if(nums[mid] <= target && target <= nums[end]){
          start = mid+1;
        } else {
          end = mid - 1;
        }
      }
    }
    return false;
  }
  public static void main(String[] args) {
    int[] nums = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
    int target = 3;
    boolean ans = search(nums, target);
    if (ans == false)
        System.out.println("Target is not present.");
    else
        System.out.println("Target is present in the array.");
}
}



// 🔁 Step-by-step Algorithm:
// Step 1: Initialize pointers
// Set start = 0

// Set end = nums.length - 1

// Step 2: Run a loop while start <= end
// Calculate mid = start + (end - start) / 2

// Step 3: Check if target is found
// If nums[mid] == target, return true

// Step 4: Handle duplicates (Ambiguity Case)
// If nums[start] == nums[mid] == nums[end]:

// It means we can't determine which half is sorted

// So, shrink the boundaries:

// start += 1

// end -= 1

// continue to next iteration

// Step 5: Determine which half is sorted
// ✅ Case A: Left half is sorted
// If nums[start] <= nums[mid]:

// Now check if target lies between nums[start] and nums[mid]

// If yes → Move end = mid - 1

// If no → Move start = mid + 1

// ✅ Case B: Right half is sorted
// Else (i.e., nums[mid] < nums[start])

// Check if target lies between nums[mid] and nums[end]

// If yes → Move start = mid + 1

// If no → Move end = mid - 1

// Step 6: If loop ends, target is not found
// Return false
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



// Step-by-step Procedure:
// Step 1: Initialize the array and target
// Define an integer array nums.

// Define an integer target that you want to find in the array.

// Step 2: Find the First Occurrence using lowerBound()
// Function: lowerBound(nums, target)
// Initialize three variables:

// low = 0 (start of the array)

// high = nums.length - 1 (end of the array)

// first = -1 (to store the index of first occurrence)

// While low <= high, do:

// Compute mid = low + (high - low) / 2

// If nums[mid] == target:

// Set first = mid

// Move high = mid - 1 to continue searching in the left half

// Else if nums[mid] < target:

// Move low = mid + 1 to search in the right half

// Else:

// Move high = mid - 1 to search in the left half

// Return the value of first

// If first remains -1, it means the target is not found.

// Step 3: If first is -1, Target Not Found
// Print -1, -1 and exit the program.

// Step 4: Find the Last Occurrence using upperBound()
// Function: upperBound(nums, target)
// Initialize three variables:

// low = 0 (start of the array)

// high = nums.length - 1 (end of the array)

// last = -1 (to store the index of last occurrence)

// While low <= high, do:

// Compute mid = low + (high - low) / 2

// If nums[mid] == target:

// Set last = mid

// Move low = mid + 1 to continue searching in the right half

// Else if nums[mid] < target:

// Move low = mid + 1 to search in the right half

// Else:

// Move high = mid - 1 to search in the left half

// Return the value of last.

// Step 5: Print the result
// Print the values of first and last returned by lowerBound() and upperBound() respectively.

// Time and Space Complexity
// Time Complexity: O(log n) for both lowerBound and upperBound functions.

// Space Complexity: O(1) (no extra space used)



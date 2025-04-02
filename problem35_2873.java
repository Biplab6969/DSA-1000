// 2873. Maximum Value of an Ordered Triplet I
// You are given a 0-indexed integer array nums.

// Return the maximum value over all triplets of indices (i, j, k) such that i < j < k. If all such triplets have a negative value, return 0.

// The value of a triplet of indices (i, j, k) is equal to (nums[i] - nums[j]) * nums[k].

 

// Example 1:

// Input: nums = [12,6,1,2,7]
// Output: 77
// Explanation: The value of the triplet (0, 2, 4) is (nums[0] - nums[2]) * nums[4] = 77.
// It can be shown that there are no ordered triplets of indices with a value greater than 77. 
// Example 2:

// Input: nums = [1,10,3,4,19]
// Output: 133
// Explanation: The value of the triplet (1, 2, 4) is (nums[1] - nums[2]) * nums[4] = 133.
// It can be shown that there are no ordered triplets of indices with a value greater than 133.
// Example 3:

// Input: nums = [1,2,3]
// Output: 0
// Explanation: The only ordered triplet of indices (0, 1, 2) has a negative value of (nums[0] - nums[1]) * nums[2] = -3. Hence, the answer would be 0.

import java.security.AlgorithmConstraints;

public class problem35_2873 {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxValue = 0;
        
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    long value = (long)(nums[i] - nums[j]) * nums[k];
                    maxValue = Math.max(maxValue, value);
                }
            }
        }
        
        return maxValue;
    }


    public static void main(String[] args) {
        int[] nums = {3, 7, 1, 5, 9}; // Sample input array
        
        problem35_2873 solution = new problem35_2873();
        long result = solution.maximumTripletValue(nums);
        
        System.out.println("Maximum Triplet Value: " + result);
    }

  }



//   PSEUDOCODE

//   FUNCTION maximumTripletValue(nums: ARRAY of INTEGER) -> LONG
//     n ← length of nums
//     maxValue ← 0
    
//     FOR i FROM 0 TO n - 3 DO
//         FOR j FROM i + 1 TO n - 2 DO
//             FOR k FROM j + 1 TO n - 1 DO
//                 value ← (nums[i] - nums[j]) * nums[k]
//                 maxValue ← MAX(maxValue, value)
//             END FOR
//         END FOR
//     END FOR
    
//     RETURN maxValue
// END FUNCTION

// MAIN FUNCTION
//     DECLARE nums AS ARRAY ← [3, 7, 1, 5, 9]  // Example input array
    
//     CALL maximumTripletValue(nums) AND STORE RESULT IN result
    
//     PRINT "Maximum Triplet Value: ", result
// END FUNCTION



// AlgorithM
// Algorithm for Finding Maximum Triplet Value
// Step 1: Define the function maximumTripletValue(nums):
// Initialize n as the length of nums.

// Initialize maxValue to 0 (to store the maximum triplet value).

// Step 2: Iterate through all possible triplets (i, j, k):
// For i from 0 to n-3:

// For j from i+1 to n-2:

// For k from j+1 to n-1:

// Calculate value = (nums[i] - nums[j]) * nums[k].

// Update maxValue = max(maxValue, value).

// Step 3: Return the maximum value found.
// Step 4: Define the Main function:
// Initialize an array nums with predefined values (e.g., [3, 7, 1, 5, 9]).

// Call maximumTripletValue(nums) and store the result in result.

// Print "Maximum Triplet Value: " followed by result.

// Time Complexity Analysis
// The algorithm iterates over all possible triplets using three nested loops.

// The total number of iterations is O(n³) (where n is the length of nums).

// This makes the solution inefficient for large arrays and can be optimized.
// 2874. Maximum Value of an Ordered Triplet II
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


  class problem37_2874 {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        int[] leftMax = new int[n];
        leftMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        long ans = 0;  
        for (int i = 1; i < n - 1; i++) {
            int left = leftMax[i - 1];
            int right = rightMax[i + 1];
            ans = Math.max(ans, (long)(left - nums[i]) * right); 
        }

        return ans;
    }



    public static void main(String[] args) {
        int[] nums = {3, 7, 2, 5, 8}; // Example input
        
        problem37_2874 solution = new problem37_2874();
        long result = solution.maximumTripletValue(nums);
        
        System.out.println("Maximum Triplet Value: " + result);
    }
}










/* 
Algorithm for the Program:
Initialize Variables:

Get the length of the input array nums.

If the array has fewer than 3 elements, return 0 (since a triplet is not possible).

Precompute Maximum Values from Left:

Create an array leftMax to store the maximum values from the left.

Iterate through nums from left to right:

Store the maximum value encountered so far at each index in leftMax.

Precompute Maximum Values from Right:

Create an array rightMax to store the maximum values from the right.

Iterate through nums from right to left:

Store the maximum value encountered so far at each index in rightMax.

Find the Maximum Triplet Value:

Initialize ans to 0 (to store the maximum triplet value found).

Iterate through nums from index 1 to n-2 (excluding the first and last elements):

Get leftMax[i - 1] (maximum from the left).

Get rightMax[i + 1] (maximum from the right).

Compute (left - nums[i]) * right and update ans if this value is greater.

Return the Final Maximum Triplet Value.





FUNCTION maximumTripletValue(nums: ARRAY of INTEGER) RETURNS LONG
    n ← LENGTH(nums)
    IF n < 3 THEN
        RETURN 0

    // Compute leftMax array
    leftMax ← ARRAY of size n
    leftMax[0] ← nums[0]
    FOR i FROM 1 TO n-1 DO
        leftMax[i] ← MAX(leftMax[i - 1], nums[i])
    END FOR

    // Compute rightMax array
    rightMax ← ARRAY of size n
    rightMax[n - 1] ← nums[n - 1]
    FOR i FROM n-2 DOWN TO 0 DO
        rightMax[i] ← MAX(rightMax[i + 1], nums[i])
    END FOR

    ans ← 0
    FOR i FROM 1 TO n-2 DO
        left ← leftMax[i - 1]
        right ← rightMax[i + 1]
        ans ← MAX(ans, (left - nums[i]) * right)
    END FOR

    RETURN ans
END FUNCTION

FUNCTION main()
    nums ← [3, 7, 2, 5, 8]  // Example input

    solution ← NEW Solution()
    result ← solution.maximumTripletValue(nums)

    PRINT "Maximum Triplet Value:", result
END FUNCTION
*/
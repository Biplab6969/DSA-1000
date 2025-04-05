import java.util.Arrays;

public class problem2_128 {
  public static int longestConsecutive(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int lastSmaller = Integer.MIN_VALUE;
    int cnt = 1;
    int longest = 0; 
    for(int i=0; i<n; i++){
      if(nums[i]-1 == lastSmaller){
        cnt += 1;
        lastSmaller = nums[i];
      } else if(nums[i] != lastSmaller){
        cnt = 1;
        lastSmaller = nums[i];
      }
      longest = Math.max(longest, cnt);
    }
    return longest;
  }

  public static void main(String[] args) {
    int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
    int ans = longestConsecutive(nums);
    System.out.println(ans);
  }
}

/* 

Algorithm:
Sort the array nums[] in ascending order.

Initialize variables:

lastSmaller = Integer.MIN_VALUE (to track the last unique element).

cnt = 1 (current streak count).

longest = 0 (to store the longest streak found).

Traverse the sorted array and check consecutive elements:

If nums[i] - 1 == lastSmaller, it extends the sequence → increment cnt.

If nums[i] is not equal to lastSmaller, reset cnt = 1.

Update longest = max(longest, cnt).

Return the longest consecutive sequence length.




PSEUDOCODE

FUNCTION longestConsecutive(nums)
    SORT nums in ascending order
    n ← length of nums
    lastSmaller ← Integer.MIN_VALUE
    cnt ← 1
    longest ← 0

    FOR i ← 0 to n - 1 DO
        IF nums[i] - 1 == lastSmaller THEN
            cnt ← cnt + 1
            lastSmaller ← nums[i]
        ELSE IF nums[i] ≠ lastSmaller THEN
            cnt ← 1
            lastSmaller ← nums[i]
        ENDIF
        longest ← MAX(longest, cnt)
    ENDFOR

    RETURN longest
END FUNCTION

// Main function
BEGIN
    nums ← [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
    ans ← longestConsecutive(nums)
    PRINT ans
END

*/
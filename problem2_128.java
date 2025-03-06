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

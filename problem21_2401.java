public class problem21_2401 {
  public static int longestNiceSubarray(int[] nums) {
    int startIndex = 0;
    int ans = 0;

    int bitsUnion = 0;

    for(int i=0; i<nums.length; i++){
        int newEl = nums[i];
        while((bitsUnion & newEl) != 0){
            int startingEl = nums[startIndex];
            bitsUnion ^= startingEl;
            startIndex ++;
        }
        bitsUnion = bitsUnion | newEl;
        ans = Math.max(ans, i-startIndex + 1);
    }
    return ans;
}
public static void main(String[] args) {
  int[] nums = {1,3,8,48,10};
  int peak = longestNiceSubarray(nums);
  System.out.println("The peak element is: " + peak );
}
}

public class problem13_153 {
  private static int findMin(int[] nums){
    int start = 0;
    int end = nums.length - 1;
    int mini = Integer.MAX_VALUE;
    while(start <= end){
      int mid = start + (end - start)/2;
      if(nums[start] <= nums[mid]){
        mini = Math.min(start, mini);
        start = mid + 1;
      } else {
        mini = Math.min(mini, nums[mid]);
        end = mid -1;
      }
    }
    return mini;
  }

  public static void main(String[] args) {
    int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
    int min = findMin(nums);
    System.out.println("The minimum element is: " + min );
}
}

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

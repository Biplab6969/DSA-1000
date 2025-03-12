public class problem10_35 {

  // Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
  public int search(int[] nums, int target){
    int start = 0;
    int end = nums.length - 1;
    while (start <= end){
    int mid = start + (end-start) / 2;
    if(nums[mid] == target){
      return mid;
    }
    if(nums[mid] > target){
      end = mid - 1;
    } else {
      start = mid + 1;
    }
  }

    return -1;
  }



  public static void main(String args[]) {
    problem10_35 sol = new problem10_35(); // Correct instance creation
    int nums[] = {2, 3, 5, 6, 8, 9, 10, 12, 13, 14}; // Sorted array
    int target = 10;
    System.out.println("Index for key is " + sol.search(nums, target));
  }
}

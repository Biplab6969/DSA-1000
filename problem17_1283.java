public class problem17_1283 {

  private static int sumByD(int[] nums, int mid){
    int n = nums.length;
    int sum = 0;
    for(int i=0; i<n; i++){
        sum += Math.ceil((double)(nums[i]) / (double)(mid));
    }
    return sum;
}

private static int smallestDivisor(int[] nums, int threshold) {
int n = nums.length;
if(n > threshold){
    return -1;
}

int maxi = Integer.MIN_VALUE;
for(int i=0; i<n; i++){
    maxi = Math.max(maxi, nums[i]);
}
int low = 1;
int high = maxi;
while(low <= high){
    int mid = low + (high - low)/2;
    if(sumByD(nums, mid) <= threshold){
        high = mid - 1;
    } else {
        low = mid + 1;
    }
}
return low;
}
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5};
    int threshold = 8;
    int ans = smallestDivisor( nums, threshold);
    System.out.println("The minimum divisor is: " + ans);
}
}

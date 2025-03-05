import java.util.Arrays;

class problem1_2149{
  public static int[] rearrangeArray(int[] nums) {
    int n = nums.length;
    int[] positive = new int[n];
    int[] negative = new int[n];
    int[] finalOut  = new int[n];
    int pos = 0;
    int neg = 0;
    for(int i=0; i<n; i++){
        if(nums[i] > 0){
            positive[pos] = nums[i];
            pos++;
        } else {
            negative[neg] = nums[i];
            neg++;
        }
    }

     for(int i=0; i<n/2; i++){
         finalOut[2*i] = positive[i];
         finalOut[2*i+1] = negative[i];
     }

    return finalOut;
}

  public static void main(String[] args){
    int[] nums = {3,1,-2,-5,2,-4};
    // rearrangeArray(nums);
    int[] finalOut = rearrangeArray(nums);
    System.out.println(Arrays.toString(finalOut));
  }
}
public class problem19_1529 {
  // public int findKthPositive(int[] arr, int k) {
    //     Bruteforce solution

    //     int n = arr.length;
    //     for(int i=0; i<n; i++){
    //         if(arr[i] <= k){
    //             k += 1;
    //         } else {
    //             break;
    //         }
    //     }
    //     return k;
    // }

    private static int findKthPositive(int[] arr, int k) {

      //optimal approach
      int start = 0;
      int end = arr.length -1;
      while(start <= end){
          int mid = start + (end - start)/2;
          int missing = arr[mid] - (mid + 1);
          if(missing < k){
              start = mid + 1;
          } else {
              end = mid - 1;
          }
      }
      return end + 1 + k;
  }
  public static void main(String[] args) {
    int[] arr  = {2,3,4,7,11};
    int k = 5;
    int ans = findKthPositive( arr, k);
    System.out.println("The minimum divisor is: " + ans);
  }
}

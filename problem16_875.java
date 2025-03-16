public class problem16_875 {

  private static int sumbyD(int[] piles, int mid){
    int n = piles.length;
    int sum = 0;
    for(int i=0; i<n; i++){
        sum += Math.ceil((double)(piles[i]) / (double)(mid));
    }
    return sum;
}


private static int minEatingSpeed(int[] piles, int h) {
    int n = piles.length;
    if(n>h){
        return -1;
    }

    int maxi = Integer.MIN_VALUE;
    for(int i=0; i<n; i++){
        maxi = Math.max(maxi, piles[i]);
    }
    int low = 1;
    int high = maxi;
    while(low <= high){
        int mid = low + (high - low)/2;
        if(sumbyD(piles, mid) <= h){
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return low;
}
  public static void main(String[] args) {
    int[] piles = {7, 15, 6, 3};
    int h = 8;
    int ans = minEatingSpeed( piles,  h);
    System.out.println("Koko should eat at least " + ans + " bananas/hr.");
}
}

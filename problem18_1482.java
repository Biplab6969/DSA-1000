public class problem18_1482 {
  private static boolean possible(int[] bloomDay, int mid, int m, int k){
    int n = bloomDay.length;
    int count = 0;
    int bouquts = 0;
    for(int i=0; i<n; i++){
        if(bloomDay[i] <= mid){
            count++;
        } else {
            bouquts += (count/k);
            count = 0;
        }
    }
    bouquts += (count/k);
    return bouquts >= m;
    
}
private static int minDays(int[] bloomDay, int m, int k) {
int n = bloomDay.length;
long multi = (long)m*k;
if(n < multi){
    return -1;
}

int maxi = Integer.MIN_VALUE;
for(int i=0; i<n; i++){
    maxi = Math.max(maxi, bloomDay[i]);
}
int mini = Integer.MAX_VALUE;
for(int i=0; i<n; i++){
    mini = Math.min(mini, bloomDay[i]);
}


int low = mini;
int high = maxi;
while(low <= high){
    int mid = low + (high - low)/2;
    if(possible(bloomDay, mid,  m, k)){
        high = mid - 1;
    } else {
        low = mid + 1;
    }
}
return low;

}


public static void main(String[] args) {
  int[] bloomDay = {1,10,3,10,2};
  int m = 3;
  int k = 1;
  int ans = minDays( bloomDay, m, k);
  System.out.println("The minimum divisor is: " + ans);
}
}

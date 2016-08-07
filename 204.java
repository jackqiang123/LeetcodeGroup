public class Solution {

public int countPrimes(int n) {
    if (n == 0) return 0;
    n--;
    if (n == 1) return 0;
    boolean []num = new boolean[n+1];
    int count = 0;
    for (int i = 2; i <=n; i++){
      if (num[i]) continue;
      count++;
      for (int j = 1; j <= n/i; j++)
        nums[j*i] = true;
    }
}
}

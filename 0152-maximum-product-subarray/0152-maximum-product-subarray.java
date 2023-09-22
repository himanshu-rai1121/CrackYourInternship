class Solution {
    public int maxProduct(int[] nums) {
        int pref = 1;
        int suf = 1;
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
          if(pref == 0)
              pref = 1;
          if(suf == 0)
              suf = 1;
          pref = pref * nums[i];
          suf = suf * nums[n-i-1];
          ans = Math.max(ans, Math.max(pref, suf));
        }
        return ans;
    }
}
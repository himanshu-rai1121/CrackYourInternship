class Solution {
    public int maxProfit(int[] price) {
     
        int buy = price[0], sell = 0;
        int n = price.length;
        int profit = 0;
        int p = 6;
        
        for(int i=1;i<n;i++)
        {
            if(price[i]<=buy)
                buy = price[i];
            else
            {
                profit = profit+(price[i]-buy);
                buy = price[i];
                
            }
        }
        return profit;
        
        
        
        
    }
}
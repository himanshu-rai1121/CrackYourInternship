class Solution {
    public int maxArea(int[] height) {
     
        int n = height.length;
        int p = 0, q = n-1;
        int max = 0;
        
        for(int i=0;i<n;i++)
        {
            int m = 0;
            if (height[p]<height[q]) m = height[p]; else m = height[q];
            
            int z = (n-1-i)*m;
            if(z>max)
                max = z;
            
            if (height[p]<height[q])
                p++;
            else
                q--;
        }
        return max;
        
        
    }
}
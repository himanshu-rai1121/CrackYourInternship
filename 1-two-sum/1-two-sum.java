class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] ans = new int[2];
        int [] aux = new int[nums.length];
        for(int i=0;i<nums.length;i++)
            aux[i] = nums[i];
        
        Arrays.sort(aux);
        int p=0,q=nums.length-1,sum=0;
        while(p<q)
        {
            sum = aux[p]+aux[q];
            if(sum==target)
                break;
            else if(sum>target)
                q--;
            else if(sum<target)
                p++;
            
        }
        p = aux[p];
        q = aux[q];
        ans[0]=-1;
        ans[1]=-1;
        
        
        int m=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==p || nums[i]==q){
                ans[m]=i;
                m++;}
        }
        return ans;
        
        
    }
}
class Solution {
    public void moveZeroes(int[] nums) {
        
        int n = nums.length;
        int left = 0,right=0;
        
        for(int i=0;i<n;i++)
        {
            if(nums[i]!=0 && nums[left]!=0)
            {
                left++;
                right++;
                continue;
            }
            if(nums[i]!=0 && nums[left]==0)
            {
                nums[left]=nums[i];
                nums[i]=0;
                    left++;
                right++;continue;
            }
            if(nums[i]!=0 && nums[left]==0)
            {
                right++;
            }
            
        }
        
    }
}
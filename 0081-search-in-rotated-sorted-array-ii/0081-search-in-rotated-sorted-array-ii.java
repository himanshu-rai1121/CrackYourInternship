class Solution {
    // public boolean search(int[] nums, int target) {
    //     int start = 0;
    //     int end = nums.length-1;
    //     while(start<=end)
    //     {
    //         int mid = start+(end-start)/2;
    //         if(nums[mid]==target)
    //             return true;
    //         if(nums[start]==nums[end])
    //         {
    //             start++;
    //             end--;
    //             continue;
    //         }
    //         if(nums[mid]>=nums[start])
    //         {
    //             if(nums[start]<=target&&nums[mid]>=target)
    //             {
    //                 end = mid-1;
    //             }
    //             else
    //                 start = mid+1;
    //         }
    //         else
    //         {
    //             if(nums[mid]<=target&&nums[end]>=target)
    //                 start=mid+1;
    //             else
    //                 end = mid-1;
    //         }
    //     }
    //     return false;
    // }
    public boolean search(int []arr, int k) {
        int n = arr.length; // size of the array.
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            //if mid points the target
            if (arr[mid] == k) return true;

            //Edge case:
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            //if left part is sorted:
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= k && k <= arr[mid]) {
                    //element exists:
                    high = mid - 1;
                } else {
                    //element does not exist:
                    low = mid + 1;
                }
            } else { //if right part is sorted:
                if (arr[mid] <= k && k <= arr[high]) {
                    //element exists:
                    low = mid + 1;
                } else {
                    //element does not exist:
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
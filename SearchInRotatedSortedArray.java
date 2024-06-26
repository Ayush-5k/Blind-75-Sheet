public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;

            if (nums[mid] > nums[high]) {

                if (target > nums[mid] || target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            } else if (nums[mid] < nums[low]) {

                if(target < nums[mid] || target >= nums[low]) {
                    high = mid -1 ;
                } else {
                    low = mid + 1;
                }

            } else {
                if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }
}

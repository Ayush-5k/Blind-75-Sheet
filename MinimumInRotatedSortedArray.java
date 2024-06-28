public class MinimumInRotatedSortedArray {
    public int findMin(int[] arr) {

        int n = arr.length;

        if (n == 1) return arr[0];

        int low = 0;
        int high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid == 0) {
                if (arr[mid] < arr[mid + 1]) return arr[mid];
            }
            if (mid == 1) {
                if (arr[mid] < arr[mid - 1]) return arr[mid];
            }
            if (arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1]) {
                return arr[mid];
            }
            if (arr[mid] > arr[high]) {
                low = low + 1;
            } else if (arr[mid] < arr[low]) {
                high = mid - 1;
            } else {
                high = mid - 1;
            }
        }
        return arr[low];
    }
}

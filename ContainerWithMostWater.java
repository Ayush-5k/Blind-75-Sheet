public class ContainerWithMostWater {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int i = 0;
        int j = n - 1;
        int maxWater = 0;
        while (i < j) {
            maxWater = Math.max(maxWater, (j - i) * Math.min(heights[i], heights[j]));

            if (heights[i] > heights[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxWater;
    }
}

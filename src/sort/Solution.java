package sort;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int indexA = 0;
        int indexB = 1;
        if (nums[indexA] + nums[indexB] == target) return new int[]{indexA, indexB};

        while (indexA < nums.length - 1) {
            for (indexB = indexA + 1; indexB < nums.length; indexB++) {
                if (nums[indexA] + nums[indexB] == target) {
                    return new int[]{indexA, indexB};
                }
            }
            indexA++;
        }

        return new int[]{0, 0};
    }
}
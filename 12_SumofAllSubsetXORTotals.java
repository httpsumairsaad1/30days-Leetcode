class Solution {

    static int total = 0;

    public int subsetXORSum(int[] nums) {
        total = 0;

        rec(nums, 0, 0);

        return total;
    }

    static void rec(int[] nums, int i, int xor) {
        if (i == nums.length) {
            total += xor;
            return;
        }

        rec(nums , i + 1, xor ^ nums[i]);
        rec(nums , i + 1, xor);
    }
}

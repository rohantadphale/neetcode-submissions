class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return new int[0];
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int product = 1;
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            res[i] = product;
        }
        return res;
    }
}

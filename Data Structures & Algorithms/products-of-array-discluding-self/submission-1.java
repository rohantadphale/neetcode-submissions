class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return new int[0];
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int rightProduct = 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return res;
    }
}

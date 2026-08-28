class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> index = new HashMap<>(); // val -> index
        for (int i = 0; i < nums.length; i++) {
            if ((index.containsKey(target - nums[i]) && index.get(target - nums[i]) != i))
                return new int[] {index.get(target - nums[i]), i};
            else
                index.put(nums[i], i);
        }
        return new int[0];
    }
}

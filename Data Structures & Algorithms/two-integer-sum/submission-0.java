class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0; i<nums.length; i++){
            int n = target-nums[i];
            for(int j=0; j<nums.length; j++){
                if(n == nums[j]){
                    result[0] = j;
                    result[1] = i;
                }
            }
        }
        return result;
    }
}

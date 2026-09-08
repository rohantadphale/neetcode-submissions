class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            resultMap.putIfAbsent(key, new ArrayList<>());
            resultMap.get(key).add(s);
        }
        return new ArrayList<>(resultMap.values());
    }
}

class Solution {

    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) {
            return "";
        }
        StringBuilder binaryBuilder = new StringBuilder();
        for (String str : strs) {
            if (str == null) str = "";
            appendAs8BitBinary(binaryBuilder, (char) str.length());

            for (char ch : str.toCharArray()) {
                appendAs8BitBinary(binaryBuilder, ch);
            }
        }
        return binaryBuilder.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || str.isEmpty()) {
            return result;
        }
        int index = 0;
        while (index < str.length()) {
            // 1. Read 8 bits to determine the length of the next string
            String lengthChunk = str.substring(index, index + 8);
            int wordLength = Integer.parseInt(lengthChunk, 2);
            index += 8;

            // 2. Read 'wordLength' characters (each character is 8 bits)
            StringBuilder word = new StringBuilder();
            for (int k = 0; k < wordLength; k++) {
                String charChunk = str.substring(index, index + 8);
                word.append((char) Integer.parseInt(charChunk, 2));
                index += 8;
            }
            result.add(word.toString());
        }
        return result;
    }

    void appendAs8BitBinary(StringBuilder builder, int value) {
        for (int i = 7; i >= 0; i--) {
            builder.append((value >> i) & 1);
        }
    }
}

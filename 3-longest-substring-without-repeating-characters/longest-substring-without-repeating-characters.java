// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int left = 0;
//         int maxLength = 0;
//         HashSet<Character> charSet = new HashSet<>();

//         for (int right = 0; right < s.length(); right++) {
//             while (charSet.contains(s.charAt(right))) {
//                 charSet.remove(s.charAt(left));
//                 left++;
//             }

//             charSet.add(s.charAt(right));
//             maxLength = Math.max(maxLength, right - left + 1);
//         }

//         return maxLength;       
//     }
// }


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charIndex = new int[128];
        int left = 0, res = 0, i = 0;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            left = Math.max(left, charIndex[c]);
            res = Math.max(res, i - left + 1);

            charIndex[c] = i + 1;
        }

        return res;
    }
}
//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 665 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 方法一：滑动窗口
 * 方法二：双指针
 */
class Solution {
//    public int strStr(String haystack, String needle) {
//        int len1=haystack.length();
//        int len2=needle.length();
//        for (int i = 0; i <=len1-len2 ; i++) {//最后一个位置的起始位置为len1-len2
//            if (haystack.substring(i,i+len2).equals(needle))//子串相等，长度为len2
//            return i;
//        }
//        return  -1;
//    }


    /**
     * 双指针
     * 找子串
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int len1=haystack.length();
        int len2=needle.length();
        if (len2==0)
            return 0;
        //只有当第一个字符相同时，才比较后面的字符
        for (int i = 0; i <=len1-len2 ; i++) {//可以将i <=len1-len2转化为len1-len2+1，减小复杂度
            if(haystack.charAt(i)==needle.charAt(0)){//第一个字符相同，比较后边的字符
                int hi=i+1;
                int ni=1;
                while(ni<len2 && haystack.charAt(hi)==needle.charAt(ni)){ //ni>len,即在需要比较len2-1次即可
                    hi++;
                    ni++;
                }
                if(ni==len2)//比较完之后ni的下标为len2
                    return i;
            }
        }
        return  -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

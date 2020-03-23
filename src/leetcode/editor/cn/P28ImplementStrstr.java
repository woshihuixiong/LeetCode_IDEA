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


package leetcode.editor.cn;
//Java：实现 strStr()

import java.util.Scanner;

public class P28ImplementStrstr{
    public static void main(String[] args) {
        Solution ss = new P28ImplementStrstr().new Solution();

        System.out.println("Please input the haystack:");
        Scanner in = new Scanner(System.in);
        String haystack = in.nextLine();

        System.out.println("Please input the needle:");
        String needle = in.nextLine();

        System.out.println(ss.strStr(haystack, needle));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) return 0;
        else if(haystack == null || haystack.length() == 0) return -1;

        char start = needle.charAt(0);
        boolean flag = false;

        for(int i=0;i<=haystack.length()-needle.length();i++){
            if(start == haystack.charAt(i)){
                flag = true;
                for(int j=0;j<needle.length();j++){
                    if(haystack.charAt(i+j) != needle.charAt(j)){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag == true) return i;
        }

        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

//简单题，思路和答案的常规解法一样，就是有许多情况没考虑到导致提交了好几次才ac，继续努力吧。
//最后一次测试git，这次如果没有问题的话以后就正式开始用intellij愉快刷题了～
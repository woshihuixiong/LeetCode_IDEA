//「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下： 
//
// 1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
// 
//
// 1 被读作 "one 1" ("一个一") , 即 11。 
//11 被读作 "two 1s" ("两个一"）, 即 21。 
//21 被读作 "one 2", "one 1" （"一个二" , "一个一") , 即 1211。 
//
// 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。 
//
// 注意：整数序列中的每一项将表示为一个字符串。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "1"
//解释：这是一个基本样例。 
//
// 示例 2: 
//
// 输入: 4
//输出: "1211"
//解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 
//"1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。 
// Related Topics 字符串


package leetcode.editor.cn;
//Java：外观数列

import java.util.Scanner;

public class P38CountAndSay {
    public static void main(String[] args) {
        Solution ss = new P38CountAndSay().new Solution();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the n: "); // 打印提示
        int n = scanner.nextInt();
        scanner.close();

        System.out.println(ss.countAndSay(n));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String countAndSay(int n) {
            String ans = new String("1");

            for (int i = 0; i < n - 1; i++) {
                ans = pre(ans);
            }

            return ans;

        }

        private String pre(String str) {
            int len = str.length();
            int count = 0;
            char cur = str.charAt(0);
            String ans = new String("");

            for (int i = 0; i < len; i++) {
                if (str.charAt(i) == cur) {
                    count++;
                }
                else{
                    ans = ans + (char) ('0' + count) + cur;
                    cur = str.charAt(i);
                    count = 1;
                }

                if(i == len-1){
                    ans = ans + (char) ('0' + count) + cur;
                }
            }

            return ans;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//此题为mac上写的第二题，解决了leetcode插件的防重复class问题，接下来我将更改配置，然后解决git提交的问题。
//回到题目本身，这是一道非常逗比的题目，第一反应是暴力打表，时间一定最快，但想想还是要控制住自己，要提高哈哈。第二反应就是递归，随便写了下就完成了，其中遇到了一些小问题，还是要注意细节。

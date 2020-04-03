//给定两个二进制字符串，返回他们的和（用二进制表示）。 
//
// 输入为非空字符串且只包含数字 1 和 0。 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
// Related Topics 数学 字符串


package leetcode.editor.cn;
//Java：二进制求和

import java.util.Scanner;

public class P67AddBinary{
    public static void main(String[] args) {
        Solution ss = new P67AddBinary().new Solution();

        System.out.println("Please input the string a:");
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();

        System.out.println("Please input the string b:");
        String b = in.nextLine();

        in.close();

        System.out.println(ss.addBinary(a, b));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {

        StringBuilder ans = new StringBuilder();

        if(a.length() < b.length()){
            String c = a;
            a = b;
            b = c;
        }

        int flag = 0;

        for(int i=b.length()-1; i>=0; i--){
            int cur = a.charAt(i+a.length()-b.length()) + b.charAt(i) - 2 * (int)('0') + flag;
            if(cur == 0) ans.append('0');
            if(cur == 1){
                ans.append('1');
                if(flag == 1) flag = 0;
            }
            if(cur == 2){
                ans.append('0');
                flag = 1;
            }
            if(cur == 3){
                ans.append('1');
                flag = 1;
            }
        }

        for(int i=a.length()-b.length()-1; i>=0; i--){
            int cur = a.charAt(i) - (int)('0') + flag;
            if(cur == 0) ans.append('0');
            if(cur == 1){
                ans.append('1');
                if(flag == 1) flag = 0;
            }
            if(cur == 2){
                ans.append('0');
                flag = 1;
            }
            if(cur == 3){
                ans.append('1');
                flag = 1;
            }
        }

        if(flag == 1) ans.append('1');

        return ans.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

//不知道自己在写些什么玩意
//附上答案：
//class Solution {
//    public String addBinary(String a, String b) {
//        StringBuilder ans = new StringBuilder();
//        int ca = 0;
////这个for循环写的真好
//        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
//            int sum = ca;
//            sum += i >= 0 ? a.charAt(i) - '0' : 0;
//            sum += j >= 0 ? b.charAt(j) - '0' : 0;
//            ans.append(sum % 2);
//            ca = sum / 2;
//        }
//        ans.append(ca == 1 ? ca : "");
//        return ans.reverse().toString();
//    }
//}
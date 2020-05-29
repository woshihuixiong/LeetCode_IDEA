//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。 
//
// 
//
// 示例: 
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"] 
// Related Topics 字符串 回溯算法


package leetcode.editor.cn;
//Java：复原IP地址

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P93RestoreIpAddresses{
    public static void main(String[] args) {
        Solution ss = new P93RestoreIpAddresses().new Solution();

        System.out.println("Please input the string:");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        in.close();

        System.out.println(ss.restoreIpAddresses(s));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if(s == null || s == "") return null;

        String addr = "";
        backtrack(s, addr, 0, 0);
        return ans;
    }

    void backtrack(String s, String addr, int cur, int n){
        if((s.length()-cur-1) > (4-n) * 3) return;

        if(cur == s.length() && n == 4){
            ans.add(addr.substring(0,addr.length()-1));
            return;
        }
        else if(n == 4){
            return;
        }

        for(int i=0; i<3; i++){
            if(cur+i >= s.length()) return;
            String sub = s.substring(cur, cur+i+1);
            int N = Integer.parseInt(sub);
            if(N>255 || (N<100 && N>9 && sub.length()==3) || (N<10 && N>=0 && (sub.length()==3 || sub.length()==2))) return;
            addr += sub;

            cur += i+1;
            n++;
            if(n < 5) addr += '.';

            backtrack(s, addr, cur, n);

            n--;
            cur -= i+1;
            addr = addr.substring(0, addr.length()-i-2);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
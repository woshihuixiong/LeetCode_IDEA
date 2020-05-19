//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找


package leetcode.editor.cn;
//Java：x 的平方根

import java.util.Scanner;

public class P69Sqrtx{
    public static void main(String[] args) {
        Solution ss = new P69Sqrtx().new Solution();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the num: "); // 打印提示
        int n = scanner.nextInt();
        scanner.close();

        System.out.println(ss.mySqrt(n));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x == 1) return 1;

        long left = 0;
        long right = x;

        int ans = 0;
        boolean flag = false;

        while(left<right-1){
            long mid = (left + right) / 2;
            if(mid * mid == x){
                ans = (int)mid;
                flag = true;
                break;
            }
            else if(mid * mid > x){
                right = mid;
                continue;
            }
            else if(mid * mid < x){
                left = mid;
            }
        }

        if(!flag) ans = (int)left;

        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

//注意考虑2147395599这种大整数的溢出问题（提交后显示超时），left和right类型应设置为长整型
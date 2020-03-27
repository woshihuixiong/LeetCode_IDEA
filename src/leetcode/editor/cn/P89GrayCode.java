//格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。 
//
// 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。 
//
// 示例 1: 
//
// 输入: 2
//输出: [0,1,3,2]
//解释:
//00 - 0
//01 - 1
//11 - 3
//10 - 2
//
//对于给定的 n，其格雷编码序列并不唯一。
//例如，[0,2,3,1] 也是一个有效的格雷编码序列。
//
//00 - 0
//10 - 2
//11 - 3
//01 - 1 
//
// 示例 2: 
//
// 输入: 0
//输出: [0]
//解释: 我们定义格雷编码序列必须以 0 开头。
//     给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
//     因此，当 n = 0 时，其格雷编码序列为 [0]。
// 
// Related Topics 回溯算法


package leetcode.editor.cn;
//Java：格雷编码

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P89GrayCode{
    public static void main(String[] args) {
        Solution ss = new P89GrayCode().new Solution();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the n: "); // 打印提示
        int n = scanner.nextInt();
        scanner.close();

        System.out.println(ss.grayCode(n));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();

        ans.add(0);
        ans.add(1);

        if(n == 0) return List.of(0);

        for(int i=1; i<n; i++){
            int plus = (int) Math.pow(2, i);

            for(int j=ans.size()-1; j>=0; j--){
                ans.add(plus+ans.get(j));
            }
        }

        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

//爷他妈就是个天才！
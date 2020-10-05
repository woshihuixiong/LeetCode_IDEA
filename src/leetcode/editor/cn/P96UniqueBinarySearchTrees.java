//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划


package leetcode.editor.cn;
//Java：不同的二叉搜索树

import java.util.Arrays;
import java.util.Scanner;

public class P96UniqueBinarySearchTrees{
    public static void main(String[] args) {
        Solution ss = new P96UniqueBinarySearchTrees().new Solution();
        // TO TEST

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the num: "); // 打印提示
        int n = scanner.nextInt();
        scanner.close();

        System.out.println(ss.numTrees(n));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int numTrees(int n) {
            int[] G = new int[n + 1];
            Arrays.fill(G, 0);
            G[0] = 1;
            G[1] = 1;

            for (int i = 2; i <= n; i++) {
                int x = 0;
                int y = i - 1;
                while (x < i) {
                    G[i] += G[x] * G[y];
                    x++;
                    y--;
                }
            }
            return G[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
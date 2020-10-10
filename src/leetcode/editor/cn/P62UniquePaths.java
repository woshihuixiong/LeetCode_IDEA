//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 例如，上图是一个7 x 3 的网格。有多少可能的路径？ 
//
// 
//
// 示例 1: 
//
// 输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 2: 
//
// 输入: m = 7, n = 3
//输出: 28 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10 ^ 9 
// 
// Related Topics 数组 动态规划 
// 👍 711 👎 0


package leetcode.editor.cn;
//Java：不同路径

import java.util.Scanner;

public class P62UniquePaths{
    public static void main(String[] args) {
        Solution ss = new P62UniquePaths().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input m: ");
        int m = scanner.nextInt();
        System.out.print("Input n: ");
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(ss.uniquePaths(m, n));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    int ans = 0;
//    public int uniquePaths(int m, int n) {
//        backtrack(m, n);
//        return ans;
//    }
//    private void backtrack(int m, int n){
//        if(m == 1 && n == 1){
//            ans++;
//            return;
//        }
//        if(m > 1) backtrack(m-1, n);
//        if(n > 1) backtrack(m,n-1);
//    }
//}

    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m+1][n+1];
            for(int i=1; i<=m; i++){
                dp[i][1] = 1;
            }
            for(int i=1; i<=n; i++){
                dp[1][i] = 1;
            }

            for(int i=2; i<=m; i++){
                for(int j=2; j<=n;j++){
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
// Related Topics 回溯算法


package leetcode.editor.cn;
//Java：N皇后

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P51NQueens{
    public static void main(String[] args) {
        Solution ss = new P51NQueens().new Solution();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the num: "); // 打印提示
        int n = scanner.nextInt();
        scanner.close();

        System.out.println(ss.solveNQueens(n));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> ans = new ArrayList<>();


    public List<List<String>> solveNQueens(int n) {
        ArrayList<Integer> track = new ArrayList<>();
        backtrack(n, track);
        return ans;
    }

    void backtrack(int n, ArrayList<Integer> track){
        if(track.size() == n){
            ArrayList<String> trans = new ArrayList<>();
            for(int i=0; i<n; i++){
                String str = "";
                for(int j=0; j<track.get(i); j++) str += '.';
                str += 'Q';
                for(int k=track.get(i)+1; k<n; k++) str += '.';
                trans.add(str);
            }
            ans.add(new ArrayList(trans));
            return;
        }

        for(int i=0; i<n; i++){
            if(track.contains(i)) continue;

            if(check(track, i)){
                track.add(i);
                backtrack(n, track);
                track.remove(track.size()-1);
            }
        }
    }

    boolean check(ArrayList<Integer> track, int i){
        for(int j=0;j<track.size();j++){
            if(Math.abs(track.get(j)-i) == Math.abs(track.size()-j)) return false;
        }
        return true;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}

//经典问题，回溯法解决。对我来说是熟悉一下list的使用。。。
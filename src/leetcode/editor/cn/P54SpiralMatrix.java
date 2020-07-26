//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组


package leetcode.editor.cn;
//Java：螺旋矩阵

import java.util.ArrayList;
import java.util.List;

public class P54SpiralMatrix{
    public static void main(String[] args) {
        Solution ss = new P54SpiralMatrix().new Solution();
        // TO TEST
        int[][] matrix = {
                {1,2},
                {3,4},
        };
        System.out.println(ss.spiralOrder(matrix));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if(matrix.length == 0) return ans;

        int len = matrix[0].length;
        int wide =matrix.length;

        int loop = Math.min(len, wide)/2;
        for(int i=0; i<loop; i++){
            for(int j=i; j<=len-1-i; j++) ans.add(matrix[i][j]);
            for(int j=i+1; j<=wide-1-i; j++) ans.add(matrix[j][len-1-i]);
            for(int j=len-2-i; j>=i; j--) ans.add(matrix[wide-1-i][j]);
            for(int j=wide-2-i; j>=i+1; j--) ans.add(matrix[j][i]);
        }

        if(len>wide && wide%2==1){
            for(int k=loop; k<len-loop; k++) ans.add(matrix[loop][k]);
        }

        if(len<wide && len%2==1){
            for(int k=loop; k<wide-loop; k++) ans.add(matrix[k][loop]);
        }

        if(len==wide && len%2==1){
            ans.add(matrix[loop][loop]);
        }

        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
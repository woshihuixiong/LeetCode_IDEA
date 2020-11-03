//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组 
// 👍 570 👎 0


package leetcode.editor.cn;
//Java：加一

import java.util.Scanner;

public class P66PlusOne{
    public static void main(String[] args) {
        Solution ss = new P66PlusOne().new Solution();
        // TO TEST
        Scanner sc = new Scanner(System.in);


        System.out.println("Please input the nums:");
        String str = sc.next().toString();
        String[] arr  = str.split(",");
        int[] nums = new int[arr.length];
        for(int j = 0; j<nums.length;j++) {
            nums[j] = Integer.parseInt(arr[j]);
        }

        sc.close();

        int[] ans = ss.plusOne(nums);
        for(int i=0; i<ans.length; i++){
            System.out.println(ans[i]);
        }
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        return pp(digits, len-1);
    }

    private int[] pp(int[] digits, int i){
        if(digits[i] < 9){
            digits[i]++;
            return digits;
        }
        else{
            if(i != 0){
                digits[i] = 0;
                return pp(digits, i-1);
            }
            digits = new int[digits.length+1];
            digits[0] = 1;
            return digits;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
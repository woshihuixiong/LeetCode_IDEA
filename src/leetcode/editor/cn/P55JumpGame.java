//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组


package leetcode.editor.cn;
//Java：跳跃游戏

import java.util.Scanner;

public class P55JumpGame{
    public static void main(String[] args) {
        Solution ss = new P55JumpGame().new Solution();

        Scanner sc = new Scanner(System.in);


        System.out.println("Please input the nums:");
        String str = sc.next().toString();
        String[] arr  = str.split(",");
        int[] nums = new int[arr.length];
        for(int j = 0; j<nums.length;j++) {
            nums[j] = Integer.parseInt(arr[j]);
        }

        sc.close();

        System.out.println(ss.canJump(nums));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int start = 0;
        int end = 0;
        int far = 0;
        int count = 0;

        if(len == 0) return false;
        if(len == 1 && nums[0] == 0) return true;

        while(true){
            for(int i=start; i<=end; i++){
                count++;
                if(nums[i] == 0) continue;
                far = Math.max(far, i+nums[i]);
            }

            if(far >= len-1) break;

            if(nums[far] == 0 && count == far+1) return false;

            start = end+1;
            end = far;
        }

        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

//和P45类似，但思路还是不太一样。跳就完事了。
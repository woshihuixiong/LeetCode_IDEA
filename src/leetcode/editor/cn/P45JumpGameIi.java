//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组


package leetcode.editor.cn;
//Java：跳跃游戏 II

import java.util.Scanner;

public class P45JumpGameIi{
    public static void main(String[] args) {
        Solution ss = new P45JumpGameIi().new Solution();

        Scanner sc = new Scanner(System.in);


        System.out.println("Please input the nums:");
        String str = sc.next().toString();
        String[] arr  = str.split(",");
        int[] nums = new int[arr.length];
        for(int j = 0; j<nums.length;j++) {
            nums[j] = Integer.parseInt(arr[j]);
        }

        sc.close();

        System.out.println(ss.jump(nums));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int ans = 0;
        int start = 0;
        int end = 0;
        int far = 1;

        if(len == 0 || len == 1) return 0;

        while(end < len-1){
            for(int i=start; i<=end; i++){
                far = Math.max(far, i+nums[i]);
            }
            ans++;
            start = end+1;
            end = far;
        }

        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

//这是道困难题，一开始没思路，看了下答案的思路一下子就写出来了，其实这道题真的只要理解到位了就非常简单。
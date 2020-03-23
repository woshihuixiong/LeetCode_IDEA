//给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 
//
// 示例 1: 
//
// 给定数组 nums = [1,1,2], 
//
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
//
//你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 2: 
//
// 给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// Related Topics 数组 双指针


package leetcode.editor.cn;
//Java：删除排序数组中的重复项

import java.util.Scanner;

public class P26RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution ss = new P26RemoveDuplicatesFromSortedArray().new Solution();

        Scanner sc = new Scanner(System.in);

        System.out.println("Please input the nums:");
        String str = sc.next().toString();
        String[] arr = str.split(",");
        int[] nums = new int[arr.length];
        for (int j = 0; j < nums.length; j++) {
            nums[j] = Integer.parseInt(arr[j]);
        }

        sc.close();

        System.out.println(ss.removeDuplicates(nums));
    }


//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) return 0;

            int ans = 1;
            int len = nums.length;
            int temp = nums[0];
            int index = 1;

            for (int i = 1; i < len; i++) {
                if (nums[i] == temp) {
                    continue;
                } else {
                    nums[index++] = nums[i];
                    temp = nums[i];
                    ans++;
                }
            }

            return ans;

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//第一道在mac上写的题，因为以后心得都在java源文件中直接注释了，我也不写题目和难度了。
//这道题是非常简单，目前还在试用intellij的leetcode，等下重新配置一下，再做一道题，然后测试git的功能，再做一题，今天比较辛苦。


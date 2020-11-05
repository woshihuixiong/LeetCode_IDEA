//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意: 
//不能使用代码库中的排序函数来解决这道题。 
//
// 示例: 
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2] 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用计数排序的两趟扫描算法。 
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针 
// 👍 693 👎 0


package leetcode.editor.cn;
//Java：颜色分类

import java.util.Scanner;

public class P75SortColors{
    public static void main(String[] args) {
        Solution ss = new P75SortColors().new Solution();
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

        ss.sortColors(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if(len<2) return;
        int zero = 0;
        int two = len;
        int i = 0;

        while(i<two){
            if(nums[i] == 0){
                swap(nums, zero++, i++);
            }
            else if(nums[i] == 1){
                i++;
            }
            else{
                swap(nums, --two, i);
            }
        }

    }

    private void swap(int[] nums, int a, int b){
        int x = nums[a];
        nums[a] = nums[b];
        nums[b] = x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
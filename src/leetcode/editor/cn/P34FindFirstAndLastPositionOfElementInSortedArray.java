//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找


package leetcode.editor.cn;
//Java：在排序数组中查找元素的第一个和最后一个位置

import java.util.Scanner;

public class P34FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution ss = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();

        Scanner sc = new Scanner(System.in);

        System.out.print("Please input the target:");
        int target = sc.nextInt();

        System.out.println("Please input the nums:");
        String str = sc.next().toString();
        String[] arr  = str.split(",");
        int[] nums = new int[arr.length];
        for(int j = 0; j<nums.length;j++) {
            nums[j] = Integer.parseInt(arr[j]);
        }

        sc.close();

        int[] ans = ss.searchRange(nums, target);
        System.out.printf("[%d, %d]",ans[0], ans[1]);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] ans = {-1, -1};

        if(len == 0) return ans;

        int left = 0;
        int right = len;

        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid] == target) right = mid;
            else if(nums[mid] < target) left = mid+1;
            else right = mid;
        }
        int L = left;

        left = 0;
        right = len;

        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid] == target) left = mid+1;
            else if(nums[mid] < target) left = mid+1;
            else right = mid;
        }
        int R = left-1;

        if(L == len || R == len || nums[L] != target || nums[R] != target) return ans;
        ans[0] = L;
        ans[1] = R;
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

//由于题目有时间复杂度的限制，一下子就想到了二分法，然而想到方法容易，代码实现起来n多细节要处理。
//之前一直用二分法查找元素，却没用过它查找左右边界，看了下解答，我觉得还是直接背诵比较好，主要是要理解搜索区间的概念。
//最主要的，搜索一个元素，搜索区间两端闭；搜索左右区间，搜索区间左闭右开，具体细节去看网上的第二个解答，一定要加深理解！
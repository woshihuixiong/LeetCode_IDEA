//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表


package leetcode.editor.cn;
//Java：二叉树的中序遍历

import java.util.ArrayList;
import java.util.List;

public class P94BinaryTreeInorderTraversal{
    public static void main(String[] args) {
        Solution ss = new P94BinaryTreeInorderTraversal().new Solution();
        // TO TEST

        TreeNode root = new P94BinaryTreeInorderTraversal().new TreeNode(1);
        root.right = new P94BinaryTreeInorderTraversal().new TreeNode(2);
        root.right.left = new P94BinaryTreeInorderTraversal().new TreeNode(3);
        System.out.println(ss.inorderTraversal(root));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return ans;
        }
        inorderTraversal(root.left);
        ans.add(root.val);
        inorderTraversal(root.right);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
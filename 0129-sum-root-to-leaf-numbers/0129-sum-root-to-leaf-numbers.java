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
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        calSum(root, 0);
        return sum;
    }

    public void  calSum(TreeNode root, int rootToLeafSum){
        if(root == null) return;
        rootToLeafSum = rootToLeafSum * 10 + root.val;
        if(root.left == null && root.right == null){
                sum += rootToLeafSum;
        }
        
        calSum(root.left, rootToLeafSum);
        calSum(root.right, rootToLeafSum);
    }
}
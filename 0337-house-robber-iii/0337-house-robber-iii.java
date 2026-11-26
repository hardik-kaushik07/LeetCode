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
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int[] ans = new int[2];
        ans = help(root);
        return Math.max(ans[0], ans[1]);

    }
    public int[] help(TreeNode root){
        if(root == null) return new int[]{0,0};

        int[] left = help(root.left);
        int[] right = help(root.right);

        int[] ans = new int[2]; 
// If we robbed the root then we can add the root value, but we have to skip the left and right childern of root.{left[0] and right[0] contains if we robbed then what will be the money,  and left[1] and right[1] contains if we do not robbed then what will be th money.}

//  in this case we robbed the root, then we do not robed the childern.
        ans[0] = root.val + left[1] + right[1];


// if we do not robbed the root, then we can robbed both the childern as they are not adjecent.
// So we simply do not robbed the root, so we can get money maximum of left(we robb and not robb) + maximum of right(we robb and not robb).

    ans[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

    return new int[] {ans[0], ans[1]};
    }
}
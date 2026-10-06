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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> output = new ArrayList<>();
        dfs(root, targetSum, output, new ArrayList<>());
        return output;
    }

    private void dfs(TreeNode root, int targetSum,
                     List<List<Integer>> output, List<Integer> currentPath) {
        
        if(root == null) return;

        currentPath.add(root.val);

        if(root.left==null && root.right==null){
            if (targetSum == root.val) output.add(new ArrayList<>(currentPath));
        }
        // Recur for children
        dfs(root.left, targetSum-root.val, output, currentPath);
        dfs(root.right, targetSum-root.val, output, currentPath);

        

        // Backtrack: remove current node
        currentPath.remove(currentPath.size() - 1);
    }
}
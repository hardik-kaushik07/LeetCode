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

    public int averageOfSubtree(TreeNode root) {
       if(root == null) return 0;
       return bfs(root);
    }
    public int bfs(TreeNode root){
        if(root ==null) return 0;
        int count = 0;
        int sum = 0;
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            TreeNode front = q.remove();
            sum += front.val;
            count ++;
            if(front.left!= null){ 
                q.add(front.left);
            }
            if(front.right!= null) {
                q.add(front.right);
            }
        }
        int  avg = sum/count;
        if(avg == root.val){
            ans ++;
        }
        ans += bfs(root.left);
        ans += bfs(root.right);
        return ans;
    }
}
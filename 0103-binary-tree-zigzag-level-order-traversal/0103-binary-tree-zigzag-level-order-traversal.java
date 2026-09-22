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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        traversal(ans, root);
        return ans;
    }

    public void traversal(List<List<Integer>> ans, TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean leftToRight = true;
        while(q.size()!=0){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode front = q.poll();
                list.add(front.val);

                if(front.left!=null){
                    q.add(front.left);
                }
                if(front.right!=null){
                    q.add(front.right);
                }
            }
            if(!leftToRight){
                Collections.reverse(list);
            }

            ans.add(list);
            leftToRight = !leftToRight;
        }
    }
}
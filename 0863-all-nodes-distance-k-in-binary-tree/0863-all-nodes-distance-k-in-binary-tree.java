/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        Map<TreeNode, TreeNode> parentInfo = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        findParent(root, parentInfo);
        findElementsWithDistanceK(target, ans, 0, parentInfo, k, visited);
        return ans;
    }
    public void findParent(TreeNode root, Map<TreeNode, TreeNode> parentInfo){
        if(root == null) {
            return;
        }
        if(root.left != null){
            parentInfo.put(root.left, root);
            findParent(root.left, parentInfo);
        }
        if(root.right != null){
            parentInfo.put(root.right, root);
            findParent(root.right, parentInfo);
        }
    }

    public void findElementsWithDistanceK(TreeNode node, List<Integer> ans, int distance, Map<TreeNode, TreeNode> parentInfo, int k, Set<Integer> visited){
        if(node == null || visited.contains(node.val)){
            return;
        } 
        visited.add(node.val);

        if(distance == k){
            ans.add(node.val);
        }
        if(node.left != null){
            findElementsWithDistanceK(node.left, ans, distance+1, parentInfo, k, visited);
        }
        if(node.right != null){
            findElementsWithDistanceK(node.right, ans, distance+1, parentInfo, k, visited);
        }
        if(parentInfo.get(node) != null){
            findElementsWithDistanceK(parentInfo.get(node), ans, distance+1, parentInfo, k, visited);
        }
    }
}
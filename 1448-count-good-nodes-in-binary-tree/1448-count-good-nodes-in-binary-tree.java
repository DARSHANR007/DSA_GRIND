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

    int count=0;
    public int goodNodes(TreeNode root) {

        helper(root,root.val);

        return count;
        
    }

    public void helper(TreeNode node, int maxi){

        if(node==null) return;

        if(node.val >= maxi){
            count++;
            maxi=node.val;
        }

        helper(node.left, maxi);

        helper(node.right,maxi);
        




    }
}
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

    int maxi=0;
    public int diameterOfBinaryTree(TreeNode root) {

        helper(root);
        return maxi;
    }

    public int helper(TreeNode node){

        if(node==null)return 0;


        int left=helper(node.left);
        int right=helper(node.right);

        int diameter=right+left;

        maxi=Math.max(maxi,diameter);

        return 1+Math.max(left,right);
    }
}
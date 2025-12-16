class Solution {

    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        helper(root, new StringBuilder());
        return sum;
    }

    public void helper(TreeNode node, StringBuilder str) {

        if (node == null) return;

        // ADD CURRENT NODE VALUE
        str.append(node.val);

        // LEAF NODE
        if (node.left == null && node.right == null) {
            sum += Integer.parseInt(str.toString(), 2);
        } else {
            helper(node.left, str);
            helper(node.right, str);
        }

        // BACKTRACK
        str.deleteCharAt(str.length() - 1);
    }
}

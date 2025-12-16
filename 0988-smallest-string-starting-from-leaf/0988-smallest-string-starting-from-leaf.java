class Solution {

    String smallest = null;

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return smallest;
    }

    private void dfs(TreeNode node, StringBuilder path) {

        if (node == null) return;

        // append current character
        path.append((char) ('a' + node.val));

        // if leaf, evaluate
        if (node.left == null && node.right == null) {

            // leaf → root, so reverse
            path.reverse();
            String curr = path.toString();
            path.reverse(); // restore

            if (smallest == null || curr.compareTo(smallest) < 0) {
                smallest = curr;
            }
        }

        dfs(node.left, path);
        dfs(node.right, path);

        // backtrack
        path.deleteCharAt(path.length() - 1);
    }
}

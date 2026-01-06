class Solution {
    public int maxLevelSum(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int maxi = Integer.MIN_VALUE;
        int level = 1;
        int bestlevel = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();
            int temp = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp += node.val;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            if (temp > maxi) {
                maxi = temp;
                bestlevel = level;
            }

            level++;
        }

        return bestlevel;
    }
}

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {

        if (root == null) return -1;

        Queue<TreeNode> q = new LinkedList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            long levelSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                levelSum += node.val;

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            pq.offer(levelSum);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        if (pq.size() < k) return -1;

        return pq.peek();
    }
}

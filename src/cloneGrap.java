import java.util.*;

public class cloneGrap {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {


        Node start=new Node(
                node.val
        );

        Queue<Node> queue=new LinkedList<>();

        HashMap<Node,Node> hash=new HashMap<>();

        hash.put(node,start);

        queue.add(start);

        while (!queue.isEmpty()){

            Node curr=queue.poll();


            for(Node neighbours: curr.neighbors){
                if(!hash.containsKey(neighbours)){
                    hash.put(neighbours,new Node(neighbours.val));
                }

                hash.get(curr).neighbors.add(hash.get(neighbours));

            }


        }

        return start;


    }




}

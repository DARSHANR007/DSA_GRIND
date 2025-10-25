package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightMostLeaf {



    class Tree {
        int val;
        Tree left;
        Tree right;

        Tree(int val, Tree left, Tree right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public Tree righmost(Tree Node){

        Queue<Tree> queue=new LinkedList<>();


        queue.add(Node);


        while (!queue.isEmpty()){

            Tree curr=queue.poll();

            int size= queue.size();


            for(int i=0;i<size;i++){

                List<Integer> list= new List<>();

                list.


            }
        }






        return null;
    }
}

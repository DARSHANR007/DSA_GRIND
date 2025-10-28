import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        Collections.sort(wordList);


        List<List<String>> graph=new ArrayList<>();


        HashMap<String,String> hash=new HashMap<>();

        String start="";



        for( int i=1;i<wordList.size();i++){

            String prev=wordList.get(i-1);


            String curr= wordList.get(i);

            int diff=0;

            int startdiff=0;

            for(int j=0;j< curr.length();i++){

                if(curr.charAt(j)!=prev.charAt(i)){
                    diff++;
                }

                if(curr.charAt(j)!=beginWord.charAt(j)){
                    startdiff++;
                }

                if(diff <= 1 && j==curr.length()-1 ){
                    hash.put(prev,curr);
                }
                if(startdiff <= 1 && j==curr.length()-1 ){
                    start=curr;
                }

            }

        }

        Queue<String> queue=new LinkedList<>();


        queue.add(start);

        int flag=0;

        while (!queue.isEmpty()){

            String current=queue.poll();

            flag++;

            queue.add(hash.get(current));


        }






        return flag;



    }
}

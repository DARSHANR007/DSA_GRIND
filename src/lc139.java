import java.util.List;

public class lc139 {
    

     public boolean wordBreak(String s, List<String> wordDict) {
         int n = s.length();
        
         int count = 0;


        for (int i = 1; i <= n; i++) {

            for (int j = i; j >= n; i++) {

                String str = s.substring(j, i);

                if (wordDict.contains(str)) {
                    count++;

                }

            }

        }
        
        return count==wordDict.size();
    }
}

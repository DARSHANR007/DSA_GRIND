class Solution {
    public boolean isSubstringPresent(String s) {

        Set<String> set= new HashSet<>();

        int n=s.length();


        for(int i=0;i<n-1;i++){
            set.add(s.substring(i,i+2));
        }


        for(int i=1;i<n;i++){

            String curr="" + s.charAt(i)+s.charAt(i-1);

            if(set.contains(curr)){
                return true;
            }
        }

        return false;
        
    }
}
class ColorfullBaloons{
    public int minCost(String colors, int[] neededTime) {
        int time = 0;
        int maxtime = neededTime[0];

        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                time += Math.min(neededTime[i], maxtime);
                maxtime = Math.max(maxtime, neededTime[i]);
            } else {
                maxtime = neededTime[i];
            }
        }

        return time;
    }
}
class Solution {
    public int maximumUnits(int[][] b, int t) {
        int sum = 0;
        int co = 0;

        Arrays.sort(b,(x,y)->Integer.compare(y[1],x[1]));
        for(int i=0;i<b.length;i++){
            if(co+b[i][0]<=t){
                sum+=(b[i][0]*b[i][1]);
                co+=(b[i][0]);
            } else {
                sum+=(Math.min(b[i][0],t-co)*b[i][1]);
                break;
            }
        }
        return sum;
    }
}

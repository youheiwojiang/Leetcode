public class Solution {
    public int candy(int[] ratings) {
        if(ratings.length < 1) return 0;
        int candy[] = new int[ratings.length];
        candy[0] = 1;
        for(int i = 1;i < ratings.length; i++){
            if(ratings[i] > ratings[i-1])
                candy[i] = candy[i-1] + 1;
            else
                candy[i] = 1;
        }
        for(int i = ratings.length-1;i > 0;i--){
            if(ratings[i-1] > ratings[i])
                candy[i-1] = Math.max(candy[i-1],1+ candy[i]);
        }
        int res = 0;
        for(int num:candy)
            res+= num;
        return res;
    }
}

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int []res = new int[2];
        while(r > l){
            if(numbers[l] + numbers[r] < target) l++;
            else if(numbers[l] + numbers[r] > target) r--;
            else {
               break;
            }
        }
        res[0] = l+1;
        res[1]= r+1;
        return res;
    }
}

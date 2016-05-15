 public class Solution {
    public String getPermutation(int n, int k) {
        //can call next_permutation k times;
        List<Integer>list = new ArrayList<>();
        int num =1;
        for(int i = 1; i< n; i++){
            num *= i;
            list.add(i);
        }
        list.add(n);
        StringBuilder str = new StringBuilder();
        for(int i = n-1; i>=1; i--){
            int index = (k-1)/num;//needs attention
            k = k - index * num;//needs attention
            num /= i;
            str.append(list.remove(index));
        }
        str.append(list.get(0));
        return str.toString();
    }
}

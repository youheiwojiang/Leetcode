public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer>res = new ArrayList<>();
        for(int i = 0; i< input.length();i++){
            char c = input.charAt(i);
            if(c == '+' || c =='-' || c=='*'){
                String pre = input.substring(0,i);
                String pro = input.substring(i+1);
                List<Integer>part1 = diffWaysToCompute(pre);
                List<Integer>part2 = diffWaysToCompute(pro);
                for(int a:part1){
                    for(int b:part2){
                        int tmp = 0;
                        switch(c){
                            case '+':tmp = a+b;break;
                            case '-':tmp = a-b;break;
                            case '*':tmp = a*b;break;
                        }
                        res.add(tmp);
                    }
                }
            }
            
            
        }
        if(res.size() == 0) res.add(Integer.parseInt(input));
        return res;
    }
}

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String,PriorityQueue<String>>map = new HashMap<>();
        List<String>res = new ArrayList<>();
        for(String[] ticket:tickets){
            if(!map.containsKey(ticket[0]))
                map.put(ticket[0],new PriorityQueue<String>());
            map.get(ticket[0]).add(ticket[1]);
        }
        Stack<String>s = new Stack<>();
        s.push("JFK");
        while(!s.isEmpty()){
            String cur = s.peek();
            if(map.containsKey(cur) && !map.get(cur).isEmpty()){
                s.push(map.get(cur).poll());
                
            }else{
                res.add(0,cur);
                s.pop();
            }
        }return res;
    }
}

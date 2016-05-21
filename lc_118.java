//my version
public class Solution {
    List<List<Integer>>res = new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {
        if(numRows < 1) return res;
        List<Integer>list = new ArrayList<>();
        list.add(1);
        res.add(list);
        while(numRows > 1){
            List<Integer>prev = res.get(res.size() - 1);
            List<Integer>tmp = new ArrayList<>();
            tmp.add(1);
            for(int i = 1; i< prev.size(); i++){
                tmp.add(i,prev.get(i) + prev.get(i-1));
            }tmp.add(1);
            res.add(tmp);
            numRows--;
        }
        return res;
    }
}

///concise version:
public class Solution {
public List<List<Integer>> generate(int numRows)
{
    List<List<Integer>> allrows = new ArrayList<List<Integer>>();
    ArrayList<Integer> row = new ArrayList<Integer>();
    for(int i=0;i<numRows;i++)
    {
        row.add(0, 1);
        for(int j=1;j<row.size()-1;j++)
            row.set(j, row.get(j)+row.get(j+1));
        allrows.add(new ArrayList<Integer>(row));
    }
    return allrows;

}

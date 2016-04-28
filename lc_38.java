
public class Solution {
        public String countAndSay(int n) {
                    String last = "1";
                            for(int i = 1 ;i < n; i++){
                                            StringBuilder str = new StringBuilder();
                                                        char init = last.charAt(0) ;
                                                                    int count = 1;
                                                                                for(int j = 1; j< last.length();j++){
                                                                                                    if(last.charAt(j)  == init)
                                                                                                                            count++;
                                                                                                                    else{
                                                                                                                                            str.append(count);
                                                                                                                                                                str.append(init);
                                                                                                                                                                                    count = 1;
                                                                                                                                                                                                        init = last.charAt(j);
                                                                                                                                                                                                                        }
                                                                                                                                }
                                                                                            str.append(count);
                                                                                                        str.append(init);
                                                                                                                    last = str.toString();
                                                                                                                            }
                                    return last;
                                        }
}

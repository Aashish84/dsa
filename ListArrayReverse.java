import java.util.*;
import java.io.*;

class ListArrayReverse{
    public static List<Integer> reverseArray(List<Integer> a) {
    // Write your code here
        List<Integer> ans= new LinkedList<>();
        for (int i=a.size()-1 ; i>=0;i--){
            ans.add(a.get(i));
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        List <Integer> sent = new ArrayList<>(Arrays.asList(1,2,3,4));
        List<Integer> ans= ListArrayReverse.reverseArray(sent);
        System.out.println(ans);
    }
}
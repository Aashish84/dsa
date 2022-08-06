import java.util.*;
import java.util.stream.Collectors;

public class StreamMapDemo {
    public static void main(String[] args) {
        List<String> nums=Arrays.asList("1","2","3","4");

        List<Integer> inums = nums.stream().map( Integer::parseInt).collect(Collectors.toList());
        
        List<Integer> numsqr = inums.stream().map( parm -> StreamMapDemo.intParser(parm) ).collect(Collectors.toList());
        
        System.out.println(inums);
        System.out.println(numsqr);
    }
    public static int intParser(Integer a){
        return a*a;
    }
    
}

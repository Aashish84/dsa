import java.io.*;
import java.util.*;;

class HourGlass2DArray {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
    // Write your code here
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i+3 <=arr.size() ; i++){
            int ix=0;
            for(int j=0; j+3 <= arr.get(i).size() ; j++){
                //top part
                ans.add(ix,
                    arr.get(i).get(j)
                    +arr.get(i).get(j+1)
                    +arr.get(i).get(j+2)
                );

                //middle part
    
                int tmp=ans.get(ix);            
                ans.remove(ix);
                ans.add(ix, tmp+arr.get(i+1).get(j+1));
                
                //lower part

                tmp=ans.get(ix);
                ans.remove(ix);
                ans.add(
                    ix,
                    +tmp+arr.get(i+2).get(j)
                    +arr.get(i+2).get(j+1)
                    +arr.get(i+2).get(j+2)
                );
            }
        }
        int great = ans.get(0);
        for(int gx : ans){
            if(great < gx){
                great = gx;
            }
        }

        // System.out.println("finish : "+ar);

        return great;
    }

    public static void main(String[] args) throws IOException {
        List<List<Integer>> l = new ArrayList<>(Arrays.asList(
            Arrays.asList(1,1,1,0,0,0),
            Arrays.asList(0,1,0,0,0,0),
            Arrays.asList(1,1,1,0,0,0),
            Arrays.asList(0,0,2,4,4,0),
            Arrays.asList(0,0,0,2,0,0),
            Arrays.asList(0,0,1,2,4,0)
            ));
            System.out.println(l);
        System.out.println(HourGlass2DArray.hourglassSum(l));
    }
}
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        subset2(nums,0,result,new LinkedList<Integer>());
        result.add(new LinkedList<Integer>());
        return result;
    }
    public void subset2(int[] nums,int left,List<List<Integer>> result,List<Integer> temp){
        if(left==nums.length) return ;
         for(int i=left;i<nums.length;i++){
             temp.add(nums[i]);
             result.add(new ArrayList<Integer>(temp));
             subset2(nums,i+1,result,temp);
             temp.remove(temp.size()-1);
         }
    }

    public static void main(String[] args){
        int[] nums={1,2,3};
        System.out.println(new Subsets().subsets(nums));
    }
}

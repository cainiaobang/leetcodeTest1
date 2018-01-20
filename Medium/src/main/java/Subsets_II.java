import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        boolean[] mark=new boolean[nums.length];
        subsets(result,nums,0,new LinkedList<Integer>(),mark);
        result.add(new LinkedList<Integer>());
        return result;
    }
    public void  subsets(List<List<Integer>> result,int[] nums,int start,List<Integer> temp,boolean[] mark){
        if(start==nums.length) return;;
        for(int i=start;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]&&!mark[i-1]) continue;
            temp.add(nums[i]);
            mark[i]=true;
            result.add(new ArrayList<Integer>(temp));
            subsets(result,nums,i+1,temp,mark);
            mark[i]=false;
            temp.remove(temp.size()-1);
        }
    }
    public static void main(String[] args){
        int[] nums={1,1,3};
        System.out.println(new Subsets_II().subsetsWithDup(nums) );
    }

}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        combine2(1,n,k,result,new ArrayList<Integer>(k));
        return result;
    }

    public void combine2(int left,int n, int counter,List<List<Integer>> result,List<Integer> list){
        if(counter==0)  result.add(new ArrayList<Integer>(list)) ;
        if(left>n) return;
        for(int i=left;i<=n;i++){
            list.add(i);
            combine2(i+1,n,counter-1,result,list);
            list.remove(list.size()-1);
        }
    }
}

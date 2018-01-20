package Array.operation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Pascal_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        if(numRows<=0) return result;
        List<Integer> list=new LinkedList<Integer>();
        list.add(1);
        result.add(new ArrayList<Integer>(list));
        if(numRows==1) return result;
        list.add(1);
        result.add(new ArrayList<Integer>(list));
        if(numRows==2) return result;
        int i=2;
        while(i++<numRows){
            list.clear();
            list.add(1);
            int prev;
            List<Integer> temp=result.get(result.size()-1);
            Iterator<Integer> iterator=temp.iterator();
            prev=iterator.next();
            while(iterator.hasNext()){
                Integer num=iterator.next();
                list.add(num+prev);
                prev=num;
            }
            list.add(1);
            result.add(new ArrayList<Integer>(list));
        }
        return result;
    }
    public List<List<Integer>> generate2(int numRows)
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

    public static void main(String[] args){
      // System.out.println(new Pascal_Triangle().generate2(1) );
    }
}

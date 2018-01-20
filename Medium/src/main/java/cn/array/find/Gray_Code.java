package cn.array.find;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Gray_Code {
    public List<Integer> grayCode(int n) {
        List<Integer> result=new LinkedList<Integer>();
        result.add(0);
        for(int i=0;i<n;i++){
            int size=result.size();
            for(int j=size-1;j>=0;j--)
                result.add(result.get(j) | 1<<i);
        }
        return  result;
    }
}

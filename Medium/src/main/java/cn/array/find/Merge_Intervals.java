package cn.array.find;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class Merge_Intervals {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<=1) return intervals;
        List<Interval> result=new LinkedList<Interval>();
        result.add(intervals.remove(0));
        ListIterator<Interval> iterator=intervals.listIterator();
        boolean flag=false,flag2=false;
        while(iterator.hasNext()){
            flag=false;
            Interval interval=iterator.next();
            ListIterator<Interval> resultIterator=result.listIterator();
            while(resultIterator.hasNext()){
                Interval resultInterval=resultIterator.next();
                if(!(resultInterval.end<interval.start || interval.end<resultInterval.start)){
                    resultInterval.start=Math.min(resultInterval.start,interval.start);
                    resultInterval.end=Math.max(resultInterval.end,interval.end);
                    flag=true;
                    flag2=true;
                }
            }
            if(!flag) result.add(interval);
        }
        if(!flag2) return result;
        else return  merge(result);
    }
}

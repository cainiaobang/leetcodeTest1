package cn.array.find;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Insert_Interval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ListIterator<Interval> iterator=intervals.listIterator();
        boolean flag=false;
        while(iterator.hasNext()){
            Interval interval=iterator.next();
            if(newInterval.start<=interval.end){
                if(newInterval.end>=interval.start){
                    int start=Math.min(interval.start,newInterval.start);
                    int end=Math.max(interval.end,newInterval.end);
                    iterator.remove();
                    while(iterator.hasNext()){
                        Interval interval2=iterator.next();
                        if(interval2.start<=newInterval.end){
                            end=Math.max(end,interval2.end);
                            iterator.remove();
                        }else{
                            iterator.previous();
                            break;
                        }
                    }
                    iterator.add(new Interval(start,end));
                    flag=true;
                    break;
                }else{
                    iterator.previous();
                    iterator.add(newInterval);
                    flag=true;
                    break;
                }

            }
        }
        if(!flag) intervals.add(newInterval);
        return intervals;
    }



    public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        ListIterator<Interval> iterator=intervals.listIterator();
        boolean flag=false;
        while(iterator.hasNext()){
            Interval interval=iterator.next();
            if(newInterval.start<=interval.end){
                if(newInterval.end>=interval.start){
                    int start=Math.min(interval.start,newInterval.start);
                    int end=Math.max(interval.end,newInterval.end);
                    iterator.remove();
                    while(iterator.hasNext()){
                        Interval interval2=iterator.next();
                        if(interval2.start<=newInterval.end){
                            end=Math.max(end,interval2.end);
                            iterator.remove();
                        }else{
                            iterator.previous();
                            break;
                        }
                    }
                    iterator.add(new Interval(start,end));
                    flag=true;
                    break;
                }else{
                    iterator.previous();
                    iterator.add(newInterval);
                    flag=true;
                    break;
                }

            }
        }
        if(!flag) intervals.add(newInterval);
        return intervals;
    }

}

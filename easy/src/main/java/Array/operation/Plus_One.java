package Array.operation;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Plus_One {
    public int[] plusOne(int[] digits) {
        Stack<Integer> list=new Stack<Integer>();
        int carry=1;
        for(int i=digits.length-1;i>=0;i--){
            int num=digits[i]+carry;
            if(num>9){
                num=num%10;
                carry=1;
            }else{
                carry=0;
            }
           list.push(num);
        }
        if(carry==1) list.push(1);
        int[] num=new int[list.size()];
        for(int i=0;i<num.length;i++)
            num[i]=list.pop();
        return num;
    }
}

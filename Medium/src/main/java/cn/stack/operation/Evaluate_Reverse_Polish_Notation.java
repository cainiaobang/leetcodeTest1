package cn.stack.operation;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        Stack<String> stack=new Stack<String>();
        if(tokens.length==0) return 0;
        Integer n=Integer.valueOf(tokens[0]);
       for(int i=1;i<tokens.length;i++){
             String s=tokens[i];
            if(s=="+"){
                String value1=stack.pop();
                n=n+Integer.valueOf(value1);
            }else if(s=="-"){
                String value1=stack.pop();
                n=n-Integer.valueOf(value1);
            }else if(s=="*"){
                String value1=stack.pop();
                n=n*Integer.valueOf(value1);
            }else if(s=="/"){
                String value1=stack.pop();
                n=n/Integer.valueOf(value1);
            }else{
                stack.push(s);
            }
        }
        return n.intValue();
    }

    public static void main(String[] args){
        String[] nums={"3","-4","+"};
        System.out.println(new Evaluate_Reverse_Polish_Notation().evalRPN(nums) );
    }
}

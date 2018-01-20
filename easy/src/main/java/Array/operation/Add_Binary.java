package Array.operation;

import java.util.Stack;

public class Add_Binary {
    public String addBinary(String a, String b) {
        if(a.length()==0) return b;
        else if(b.length()==0) return a;
        if(a.length()<b.length()) return addBinary(b,a);
        int carry=0, pos1=a.length()-1,pos2=b.length()-1;
        Stack<Character> stack=new Stack<Character>();
        StringBuilder result=new StringBuilder();
        while(pos2>=0){
            if(a.charAt(pos1)=='1'&&b.charAt(pos2)=='1'){
                if(carry==0){
                    carry=1;stack.push('0');
                }else{
                    stack.push('1');
                }
            }else if(a.charAt(pos1)=='1' || b.charAt(pos2)=='1' ){
                if(carry==1){
                    carry=1;stack.push('0');
                }else
                    stack.push('1');
            }else{
                if(carry==1){
                    carry=0;stack.push('1');
                }else{
                    stack.push('0');
                }
            }
            pos1--;pos2--;
        }
        if(carry==0){
            result.append(a.substring(0,a.length()-b.length()));
        }else{
            int length3=a.length()-b.length()-1;
            while(length3>=0){
                if(a.charAt(length3)=='0'){
                    stack.push('1');
                    result.append(a.substring(0,length3));
                    carry=0;
                    break;
                }else{
                    stack.push('0');
                }
                length3--;
            }
            if(carry==1) stack.push('1');
        }
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(new Add_Binary().addBinary("110010","10111") );
    }
}

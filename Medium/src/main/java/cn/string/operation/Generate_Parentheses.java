package cn.string.operation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        LinkedList<String> result=new LinkedList<String>();
        LinkedList<Integer> count1=new LinkedList<Integer>();
        LinkedList<Integer> count2=new LinkedList<Integer>();
        result.add("(");
        count1.add(1);
        count2.add(0);
        for(int i=1;i<n*2;i++){
            for(int j=0;j<result.size();j++){
                String  str=result.peek();
                if(str.length()==i){
                    result.remove();
                    Integer num1=count1.remove();
                    Integer num2=count2.remove();
                   if(num1-num2>0) {
                       if(num1<n){ result.add(str+"(");count1.add(num1+1);count2.add(num2); }
                       if(num2<n){ result.add(str+")");count1.add(num1);count2.add(num2+1); }
                   }else{ result.add(str+"(");count1.add(num1+1);count2.add(num2); }
                }
            }
        }
        return result;
    }

    class Node{
        String string;
        int m;
        int n;
        public Node(String string ,int m,int n){
            this.m=m;this.n=n;this.string=string;
        }
    }
    public List<String> generateParenthesis2(int n){
        LinkedList<String> result=new LinkedList<String>();
        LinkedList<Node> nodeList=new LinkedList<Node>();
        nodeList.add(new Node("(",1,0));
        for(int i=1;i<n*2;i++){
            int count=nodeList.size();
            for(int j=0;j<count;j++){
                Node node=nodeList.remove();
                if(node.m>node.n){
                    if(node.m<n)nodeList.add(new Node(node.string+"(",node.m+1,node.n));
                    nodeList.add(new Node(node.string+")",node.m,node.n+1));
                }else nodeList.add(new Node(node.string+"(",node.m+1,node.n));
            }
        }
        Iterator<Node> iterator=nodeList.iterator();
        while(iterator.hasNext()){
            result.add(iterator.next().string);
        }
        return result;
    }


    // 最聪明的做法。
    public List<String> generateParenthesis3(int n) {
        List<String> list = new ArrayList<String >();
        char[] str = new char[n*2];
        generate(list,n,n,str,0);
        return list;
    }
    public void generate(List<String> list, int leftRemain, int rightRemain, char[] str, int index){
        //no left parentheses left or we added more right parentheses than the left
        if(leftRemain<0 || rightRemain < leftRemain) return;
        if(leftRemain == 0 && rightRemain ==0){
            list.add(String.copyValueOf(str));
        }else{
            str[index] = '(';
            generate(list, leftRemain -1, rightRemain, str, index+1);
            str[index] = ')';
            generate(list, leftRemain, rightRemain-1,str, index+1);
        }
    }

    public static void main(String[] args){
        System.out.println(new Generate_Parentheses().generateParenthesis2(3) );
    }
}

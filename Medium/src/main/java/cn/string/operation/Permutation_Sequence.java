package cn.string.operation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Permutation_Sequence {
    public String getPermutation(int n, int k) {
        StringBuilder result=new StringBuilder();
        int[] mark=new int[n+1];
        Arrays.fill(mark,-1);
        getPermuttation2(n,k,1,new StringBuilder(),0,result,mark);
        return result.toString();
    }

    public int  getPermuttation2(int n, int k,int left,StringBuilder ss,int count,StringBuilder value,int[] mark){
        if(left==n+1) {
            System.out.println(count+"   "+ss);
            count++;
            if(count==k) value.append(ss);
        }
        else{
            for(int i=1;i<=n;i++){
                if(mark[i]==-1){
                    ss.append(i);
                    mark[i]=1;
                    count=getPermuttation2(n,k,left+1,ss,count,value,mark);
                    ss.deleteCharAt(ss.lastIndexOf(i+""));
                    mark[i]=-1;
                }
            }
        }
        return count;
    }


    public String getPermutation2(int n, int k) {
        Set<Integer> used=new HashSet<Integer>();
        StringBuilder sb=new StringBuilder();
        for(int j=1;j<=n;j++){
            int m=k/factorial(n-j),p=0;
            int q=k-factorial(n-j)*m;
            if (q> 0) {
                for(int i=1;i<=n;i++){
                    if(!used.contains(i))p++;
                    if(p-1==m){
                        sb.append(i);
                        used.add(i);
                        break;
                    }
                }
                k=q;
            }else{
                for(int i=1;i<=n;i++){
                    if(!used.contains(i))p++;
                    if(p==m){
                        sb.append(i);
                        used.add(i);
                        break;
                    }
                }
                k=factorial(n-j);
            }
        }
        return sb.toString();
    }
    public int factorial(int n){
        if(n>1) return factorial(n-1)*n;
        else return 1;
    }

    public String getPermutation3(int n, int k) {
        Set<Integer> used=new HashSet<Integer>();
        StringBuilder sb=new StringBuilder();
        k--;
        for(int j=1;j<=n;j++){
            int m=k/factorial(n-j),p=-1;
            int q=k-factorial(n-j)*m;
                for(int i=1;i<=n;i++){
                    if(!used.contains(i))p++;
                    if(p==m){
                        sb.append(i);
                        used.add(i);
                        break;
                    }
                }
                k=q;
            }
        return sb.toString();
    }

/**
    public String getPermutation4(int n, int k) {
        Stack<Integer> stack = new Stack<Integer>();
        int[][] mark = new int[n + 1][n + 1];
        int[] mark_num = new int[n + 1];
        for (int i = 0; i < mark.length; i++)
            Arrays.fill(mark[i], 0);
        Arrays.fill(mark_num, 0);
        int count = 0, num = 0;
        int i = 1;
            while (i <= n) {
                if(i==1){
                    for (int w = 2; w < mark.length; w++)
                        Arrays.fill(mark[w], 0);
                }
                int j=getNext(mark,mark_num,n,i);
                if(j==-1){
                    i--;
                    num--;
                    System.out.println(i+"  "+j);
                    Integer value=stack.pop();
                    mark_num[value.intValue()]=0;
                    continue;
                }else{
                   stack.push(j);
                   num++;
                   if(num==n) {
                       count++;
                       if(count==k) break;
                       System.out.println(count);
                       Integer value=stack.pop();
                       mark_num[value.intValue()]=0;
                       num--;
                       continue;
                   }
                   i++;
                }
            }

        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty())
            sb.insert(0,stack.pop());
        return sb.toString();
    }

        public int getNext( int[][] mark, int[] mark_num, int n,int row){
                int j=1;
                while(j<=n){
                    if(mark_num[j] == 0 && mark[row][j]==0 ){
                        System.out.println(mark[row][j]+"   "+row+"    "+j);
                        mark[row][j]=1;
                        mark_num[j]=1;
                        return j;
                    }
                    j++;
                }
                return -1;
        }
*/

        public static void main (String[]args){
            System.out.println(new Permutation_Sequence().getPermutation(4, 9));
        }
    }
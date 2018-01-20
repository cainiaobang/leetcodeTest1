import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class N_Queens {
    public int  solveNQueens(int n) {
        List<List<String>> result=new LinkedList<List<String>>();
        char[] ch=new char[n];
        Arrays.fill(ch,'.');
        String[] map=new String[n];
        for(int i=0;i<n;i++){
            ch[i]='Q';
            map[i]=new String(ch);
            ch[i]='.';
        }
        LinkedList<String> tempList=new LinkedList<String>();
        int[] mark=new int[map.length];
        int[] pos=new int[map.length];
        Arrays.fill(mark,-1);
        Arrays.fill(pos,-1);
        int count=0;
        makeUpMap(result,tempList,map,mark,count,pos);
        return result.size();
    }

    public void  makeUpMap(List<List<String>> result,  LinkedList<String> tempList,String[] strings,int[] mark,int count,int[] pos){
        if(count<mark.length){
            for(int i=0;i<mark.length;i++){
                if(mark[i]==-1){
                    tempList.add(strings[i]);
                    mark[i]=i;pos[count]=i;
                    makeUpMap(result,tempList,strings,mark,count+1,pos);
                    mark[i]=-1;pos[count]=-1;
                    tempList.removeLast();
                }
            }
        }else{
                if(isValid(pos,0)){
                    result.add(new LinkedList<String>(tempList));
                }
        }
    }

    public boolean isValid(int[] pos,int left){
        if(left==pos.length-1)  return true;
        for(int i=left+1;i<pos.length;i++){
            if(Math.abs(pos[i]-pos[left])==(i-left)) return false;
        }
        return isValid(pos,left+1);
    }

    public static void main(String[] args) {
       // List<List<String>> result=new N_Queens().solveNQueens(11);
        //System.out.println(result.size());
    }
}

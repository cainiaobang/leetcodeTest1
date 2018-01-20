package cn.string.operation;

import java.util.LinkedList;
import java.util.List;

public class Restore_IP_Addresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result=new LinkedList<String>();
        StringBuilder temp=new StringBuilder();
        restoreUtil(result,temp,s,0,0);
        return result;
    }
    public void restoreUtil(List<String> result,StringBuilder temp,String s, int left,int count){
        if(count==4){
            if(left==s.length()){
                result.add(temp.toString().substring(0,temp.length()-1));
            }
        }
        else if(left==s.length()) return;
        else{
                 temp.append(s.charAt(left)+".");
                 restoreUtil(result,temp,s,left+1,count+1);
                 temp.delete(temp.length()-2,temp.length());
                // System.out.println(result+"  "+temp);
                 if(left<s.length()-1&&s.charAt(left)!='0'){
                     temp.append(s.substring(left,left+2)+".");
                     restoreUtil(result,temp,s,left+2,count+1);
                     temp.delete(temp.length()-3,temp.length());
                 }
                 if(left<s.length()-2&&s.charAt(left)!='0'){
                     int num=(s.charAt(left)-'0')*100+(s.charAt(left+1)-'0')*10+(s.charAt(left+2)-'0');
                     if(num<=255){
                         temp.append(s.substring(left,left+3)+".");
                         restoreUtil(result,temp,s,left+3,count+1);
                         temp.delete(temp.length()-4,temp.length());
                     }
                 }

        }
    }

    public static void main(String[] args){
        String s="010010";
       System.out.println(new Restore_IP_Addresses().restoreIpAddresses(s));
    }
}

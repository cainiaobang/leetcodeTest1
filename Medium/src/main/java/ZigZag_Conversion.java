import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


//将String类型转换成Char数组类型
//本题中利用StringBuilder[] 比使用Map<Integer,StringBuilder> 更合算
public class ZigZag_Conversion {
    public String convert(String s, int numRows) {
        int length=s.length();
        Map<Integer,StringBuilder> map=new HashMap<Integer, StringBuilder>();
        for(int i=0;i<numRows;i++){
            map.put(i,new StringBuilder(""));
        }
        for(int i=0;i<length;){
            for(int j=0;j<numRows&&i<length;j++,i++){
                map.get(j).append(s.charAt(i));
            }
            for(int k=numRows-2;k>0&&i<length;k--,i++){
                map.get(k).append(s.charAt(i));
            }
        }
        StringBuilder result=new StringBuilder("");
        for(int i=0;i<numRows;i++){
            result.append(map.get(i));
        }
        return result.toString() ;
    }

    public static void main(String[] args){
        ZigZag_Conversion sb=new ZigZag_Conversion();
        String ss="ABCDEFG";
        System.out.println(sb.convert(ss,3));
    }
}

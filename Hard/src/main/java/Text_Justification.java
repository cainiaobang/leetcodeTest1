import java.util.LinkedList;
import java.util.List;

public class Text_Justification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result=new LinkedList<String>();
        if( maxWidth<=0) {
            result.add("");
            return result;
        }
        StringBuilder temp;
        for(int i=0;i<words.length;){
            int count=0,length=0,j=i;
            while(count<=maxWidth&&j<words.length){
                count+=words[j].length()+1;
                length+=words[j].length();
                j++;
            }
             j--;
            if(j==i){
                temp=new StringBuilder();
                temp.append(words[j]);
                int amout=maxWidth-words[j].length();
                while(amout>0){
                    temp.append(" ");
                    amout--;
                }
                result.add(temp.toString());
                i++;
            }
            else if(count-1==maxWidth){
                 temp=new StringBuilder();
                for(int k=i;k<=j;k++){
                    temp.append(words[k]);
                    temp.append(" ");
                }
                if(temp.length()!=0) temp.deleteCharAt(temp.length()-1);
                result.add(temp.toString());
                i=j+1;
            }else{
                int space,num;
                if(j==words.length-1&&count<maxWidth){
                    space=maxWidth-length;
                    num=j-i+1;
                }else{
                    length=length-words[j].length();
                    space=maxWidth-length;
                    num=j-i;
                }
                int space_amout;
                int amout;
                if(num-1==0){
                    space_amout=space;
                    amout=0;
                }else{
                    space_amout=space/(num-1);
                    amout=space-(num-1)*space_amout;
                }
                if(j==words.length-1&&count<maxWidth){
                   space_amout=1;
                   amout=0;
                }
                StringBuilder space_min=new StringBuilder();
                for(int k=0;k<space_amout;k++){
                    space_min.append(" ");
                }
                temp=new StringBuilder();
                for(int k=i;k<i+num;k++){
                    temp.append(words[k]);
                    temp.append(space_min);
                    if(amout>0){
                        temp.append(" ");
                        amout--;
                    }
                }
                //System.out.println(temp.toString());
                if(num-1!=0) temp.delete(temp.length()-space_amout,temp.length());
                if(j==words.length-1){
                    while(temp.length()<maxWidth)
                        temp.append(" ");
                }
                result.add(temp.toString());
               if(j==words.length-1&&count<maxWidth)i=j+1;
               else i=j ;
            }
            //System.out.println(result);
        }
        return result;
    }

    public static void main(String[] args){
        String[] words={"What","must","be","shall","be."};
        int count=12;
        System.out.println(new Text_Justification().fullJustify(words,count) );
    }
}

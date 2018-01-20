package Array.operation;

public class Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        if(s.length()==0) return 0;
        int p=-1, q=-1,i=0,pastLength=0;
        while(i<s.length()){
            if(s.charAt(i)==' ') {
                p=q;
                q=i;
                if(q-p-1>0) pastLength=q-p-1;
            }
            i++;
        }
        if(q==s.length()-1) return pastLength;
        return s.length()-1-q;
    }
    public static void main(String[] args){
        String ss="a  bs";
        System.out.println(new Length_of_Last_Word().lengthOfLastWord(ss));
    }
}

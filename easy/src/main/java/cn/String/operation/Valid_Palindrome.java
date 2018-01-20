package cn.String.operation;

public class Valid_Palindrome {
    public boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if ((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z')) {
                stringBuilder.append(ch);
                continue;
            }
            if (ch >= 'a' && ch <= 'z') {
                stringBuilder.append(Character.toUpperCase(ch));
            }
        }
        int length = stringBuilder.length();
        //System.out.print(stringBuilder);
        if (length % 2 == 0) {
            return palindrome(stringBuilder, (length >>1) - 1, length >> 1);
        } else
            return palindrome(stringBuilder, length >>1, length >>1);
    }

    public boolean palindrome(StringBuilder s,int posLeft,int posRight){
        while(posLeft>=0){
            if(s.charAt(posLeft--)!=s.charAt(posRight++)) return false;
        }
        return true;
    }

    public static void main(String[] args){
       // System.out.println(new Valid_Palindrome().isPalindrome("a") );
       //System.out.println(Character.toUpperCase('c'));
        System.out.println((-1>>3));
    }
}


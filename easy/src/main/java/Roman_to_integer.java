public class Roman_to_integer {

    /**
    public int romanToInt(String s){
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        return 0;
    }
     if(c[count]=='M') sum+=1000;
     if(c[count]=='D') sum+=500;
     if(c[count]=='C') sum+=100;
     if(c[count]=='L') sum+=50;
     if(c[count]=='X') sum+=10;
     if(c[count]=='V') sum+=5;
     if(c[count]=='I') sum+=1;
     */

    public int romanToInt(String s){
        int sum=0;
        if(s.indexOf("IV")!=-1){sum-=2;}
        if(s.indexOf("IX")!=-1){sum-=2;}
        if(s.indexOf("XL")!=-1){sum-=20;}
        if(s.indexOf("XC")!=-1){sum-=20;}
        if(s.indexOf("CD")!=-1){sum-=200;}
        if(s.indexOf("CM")!=-1){sum-=200;}

        char[] cc=s.toCharArray();
        for(int i=0;i<cc.length;i++){
            switch(cc[i]){
                case 'M':sum+=1000;break;
                case  'D':sum+=500;break;
                case 'C':sum+=100;break;
                case  'L':sum+=50;break;
                case 'X':sum+=10;break;
                case  'V':sum+=5;break;
                case 'I':sum+=1;break;
                default:break;
            }
        }
        return sum;
    }
}

public class Reverse_Integer {


    /**
    public int reverse(int x) {
        boolean flag=true;
        double m=(double)x;
        if(x<0) {
            flag=false; m=-m;
        }
        StringBuilder stringBuilder=new StringBuilder();
        while(m!=0){
           String ch=Integer.toString(m%10);
           m=m/10;
           stringBuilder.append(ch);
        }
        if(stringBuilder.length()!=0) {
            double ss = Double.parseDouble(stringBuilder.toString());
            if(ss>Integer.MAX_VALUE||ss<Integer.MIN_VALUE) return 0;
            if(!flag) ss=-ss;
            return (int)ss;
        }
        return 0;
    }
  */
    public static void main(String[] args){
        Reverse_Integer reverse_integer=new Reverse_Integer();
        int mm=-2147483641;
        System.out.println(reverse_integer.reverse(mm));
    }

    public int reverse(int x){
        if(x==0) return 0;
        int[] num=new int[10];
        int j=0;
        while(j<10){
            num[j]=x%10;x/=10;
            if(x==0) break;
            j++;
        }
        double mm=0;
        for(int i=0;i<=j;i++){
            mm+=num[i]*Math.pow(10, j-i);
        }
        if(mm>Integer.MAX_VALUE||mm<Integer.MIN_VALUE) return 0;
        else
        {
            int result=(int)mm;
            return result;
        }
    }
}

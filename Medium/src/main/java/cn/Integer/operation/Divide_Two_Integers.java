package cn.Integer.operation;

public class Divide_Two_Integers {
    public int divide(int dividend, int divisor) {
        if(divisor==0 || (dividend==Integer.MIN_VALUE && divisor==-1)) return Integer.MAX_VALUE;
        long count=1;
        int flag=0,result=0;
        if(dividend<0) flag++;
        if(divisor<0)  flag++;
        long m=Math.abs((long)dividend),n=Math.abs((long)divisor),init=n;
        while(n<=m){
            while(n<=m){
                n<<=1;count<<=1;
            }
            m-=(n>>1);
            result+=(count>>1);
            count=1;
            n=init;
        }
        if(flag!=1)return result;
        else return -result;
    }

    public int divide2(int dividend, int divisor) {
        if(divisor==0 || (dividend==Integer.MIN_VALUE && divisor==-1)) return Integer.MAX_VALUE;
        if(dividend==Integer.MIN_VALUE&&divisor==1) return Integer.MIN_VALUE;
        long count=1;
        int flag=0,result=0;
        if(dividend<0) flag++;
        if(divisor<0)  flag++;
        long m=Math.abs((long)dividend),n=Math.abs((long)divisor),init=n;
        while(n<=m){
            n<<=1;count<<=1;
        }
        n=n>>1;
        count=count>>1;
        m-=n;result+=count;
        while(n>=init){
            while(n>m&&n>init){n>>=1;count>>=1;}
            if(m<n) break;
            m-=n;result+=count;
        }
        if(flag!=1)return result;
        else return -result;
    }

    public int divide3(int dividend, int divisor){
        if (divisor==0 || (dividend ==Integer.MIN_VALUE && divisor == -1))
            return Integer.MAX_VALUE;
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        int res = 0;
        while (dvd >= dvs) {
            long temp = dvs, multiple = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dvd -= temp;
            res += multiple;
        }
        return sign == 1 ? res : -res;
    }


    public static void main(String[] args){
      System.out.println(new Divide_Two_Integers().divide3(10,3));
    }
}

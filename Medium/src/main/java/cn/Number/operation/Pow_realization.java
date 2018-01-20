package cn.Number.operation;

public class Pow_realization {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(x==0) return 0;
        boolean flag=true;
        if(n<0) {flag=false;n=-n;}
        double y=x;
        int i=1;
        while(i<n){
            y=y*x;
        }
        if(flag) return y;
        else return 1/y;
    }
}

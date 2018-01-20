package Math;

public class Sqrt {
    public int mySqrt(int x) {
        if(x==1) return x;
        long left = 0, right = x, result;
        do {
            result = (left + right) / 2;
            if (result * result < x) left = result + 1;
            else if (result * result > x) right = result;
            else return (int)result;
        } while (left < right);
        if (result < left) return  (int)result;
        else return (int)(result - 1);
    }

    public int mySqrt2(int x) {
        if(x==1) return x;
        long left = 0, right = x, result;
        do {
            result = (left + right) / 2;
            if (result * result < x){
                if((result+1)*(result+1)>x) return (int)result;
                left = result + 1;
            }
            else if (result * result > x) right = result-1;
            else return (int)result;
        } while (true);
    }

}

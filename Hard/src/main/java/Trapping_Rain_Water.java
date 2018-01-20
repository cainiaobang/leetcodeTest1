public class Trapping_Rain_Water {
    public int trap(int[] height) {
        int pos = 0, max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                pos = i;
                max = height[i];
            }
        }
        int sum=leftSum(height, pos);
        sum+=rightSum(height,pos);
        return sum;
    }

    public int leftSum(int[] height, int pos) {
        //System.out.println(sum + "   " + pos);
        int i = 0, max = 0, position = -1;
        while (i < pos) {
            if (height[i] > max) {
                position = i;
                max = height[i];
            }
            i++;
        }
       // System.out.println(sum + "   " + pos + position);
        int sum=0;
        if (position != -1) {
            int sum2 = 0;
            for (int j = position; j < pos; j++) {
                sum2 += height[j];
            }
            sum += (pos - position) * height[position] - sum2;
           // System.out.println(sum + "     " + pos + "      " + position + "        " + sum2);
            if (position > 0) sum+=leftSum(height, position);
        }
        return sum;

    }

    public int  rightSum(int[] height, int pos) {
        int i = pos + 1, max = 0, position = -1;
        while (i < height.length) {
            if (height[i] > max) {
                position = i;
                max = height[i];
            }
            i++;
        }
        int sum=0;
        if (position != -1) {
            int sum2 = 0;
            for (int j = position; j > pos; j--) {
                sum2 += height[j];
            }
            sum += (position - pos) * height[position] - sum2;
            if (position < height.length - 1) sum+=rightSum(height, position);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] sum = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Trapping_Rain_Water().trap(sum));
    }
}

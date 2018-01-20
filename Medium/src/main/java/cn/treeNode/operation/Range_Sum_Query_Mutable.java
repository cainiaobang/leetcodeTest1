package cn.treeNode.operation;

public class Range_Sum_Query_Mutable {
    int[] segmentTree;
    int[] nums;
    public Range_Sum_Query_Mutable(int[] nums) {
        this.nums=nums;
        int length=nums.length;
        int height=(int)Math.floor(Math.log(2*length-1)/Math.log(2))+1;
        int size=(int)Math.pow(2,height)-1;
        segmentTree=new int[size];
        buildUtil(nums,0,length-1,0);
    }
    public int getMiddle(int se,int si){
        return se+((si-se)>>1);
    }
    public int buildUtil(int[] nums,int se, int si,int pos){
        if(si<se) return 0;
        if(se==si) {
            segmentTree[pos]=nums[se];
            return segmentTree[pos];
        }
        int middle=getMiddle(se,si);
        segmentTree[pos]=buildUtil(nums,se,middle,pos*2+1)+buildUtil(nums,middle+1,si,pos*2+2);
        return  segmentTree[pos];
    }

    public void update(int i, int val) {
        int differ=val-nums[i];
        nums[i]=val;
        updateUtil(i,0,nums.length-1,differ,0);
    }
    public void updateUtil(int i,int se,int si,int differ,int pos){
        if(i<se || i>si) return;
        if(se==si) {
            segmentTree[pos]+=differ;
            return;
        }
        segmentTree[pos]+=differ;
        int middle=getMiddle(se,si);
        updateUtil(i,se,middle,differ,pos*2+1);
        updateUtil(i,middle+1,si,differ,pos*2+2);
    }

    public int sumRange(int i, int j) {
        return  sumUtil(i,j,0,nums.length-1,0);
    }

    public int sumUtil(int i,int j,int se,int si,int pos){
       if(j<se || i>si) {
           return 0;
       }
       if(se>=i&&si<=j){
           return segmentTree[pos];
       }
       int middle=getMiddle(se,si);
       return sumUtil(i,j,se,middle,pos*2+1)+sumUtil(i,j,middle+1,si,pos*2+2);
    }

    public static void main(String[] args){
        int[] nums={};
        Range_Sum_Query_Mutable mm= new Range_Sum_Query_Mutable(nums);
        System.out.println(mm.sumRange(1,3));
    }
}

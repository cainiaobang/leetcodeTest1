package cn.binary_search_tree;

import java.util.TreeSet;

public class Contains_Duplicate_III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Long> values = new TreeSet<Long>();
        for (int ind = 0; ind < nums.length; ind++) {

             Long floor = values.floor(new Long(nums[ind]));
            Long ceil = values.ceiling(new Long(nums[ind] ));
            if ((floor != null && floor >= new Long(nums[ind])-t)
                    || (ceil != null && ceil <= nums[ind]+t)) {
                return true;
            }

            values.add(new Long(nums[ind]));
            if (ind >= k) {
                values.remove(new Long(nums[ind - k]));
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums={-2147483648,-2147483647};
        System.out.println(new  Contains_Duplicate_III().containsNearbyAlmostDuplicate(nums,3,3));
    }
}

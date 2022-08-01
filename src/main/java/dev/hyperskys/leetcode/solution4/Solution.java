package dev.hyperskys.leetcode.solution4;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if(l1 > l2) return findMedianSortedArrays(nums2,nums1);

        int start = 0, end = l1, x, y, left1 = 0, left2 = 0, right1 = 0, right2 = 0;
        while(start <= end) {
            x = (start + end) / 2;
            y = (l1 + l2 + 1) / 2 - x;
            if(x == 0) left1 = -1000001;
            else left1 = nums1[x-1];
            if(y == 0) left2 = -1000001;
            else left2 = nums2[y-1];
            if(x == l1) right1 = 1000001;
            else right1 = nums1[x];
            if(y==l2) right2 = 1000001;
            else right2 = nums2[y];
            if(left1 <= right2 && left2 <= right1) break;
            else if(left1 > right2) end = x - 1;
            else start = x + 1;
        }

        if((l1+l2) % 2 != 0) {
            return Math.max(left1, left2);
        } else {
            return (double) (Math.max(left1, left2) + Math.min(right1, right2)) / 2;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}

//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 103 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
// Related Topics 数组 哈希表 
// 👍 10815 👎 0


package com.mmzs.leetcode.editor.cn;

import java.util.HashMap;

public class Leetcode0001 {
    public static void main(String[] args) {
        Solution solution = new Leetcode0001().new Solution();

        int nums[] = {2, 7, 11, 15};
        int target = 13;

        int result[] = solution.twoSum(nums, target);
        StringBuilder sbResult = new StringBuilder();
        sbResult.append("[");
        for (int i : result) {
            sbResult.append(i);
            sbResult.append(",");
        }
        sbResult.delete(sbResult.length() - 1, sbResult.length());
        sbResult.append("]");
        System.out.println(sbResult.toString());
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 解法一： 执行耗时:65 ms,击败了38.72% 的Java用户 内存消耗:40.1 MB,击败了5.06% 的Java用户
//        public int[] twoSum(int[] nums, int target) {
//            if (nums == null || nums.length < 2) {
//                return new int[]{-1, -1};
//            }
//            int[] res = new int[]{-1, -1};
//            for (int i = 0; i < nums.length; i++) {
//                for (int j = i + 1; j < nums.length; j++) {
//                    if (nums[i] + nums[j] == target) {
//                        return new int[]{i, j};
//                    }
//                }
//            }
//            return res;
//        }

        // 解法二：执行耗时:4 ms,击败了61.07% 的Java用户 内存消耗:39.8 MB,击败了5.06% 的Java用户
//        public int[] twoSum(int[] nums, int target) {
//            if(nums == null || nums.length < 2){
//                return new int[]{-1, -1};
//            }
//            int[] res = new int[]{-1,-1};
//
//            HashMap<Integer,Integer> map = new HashMap<>();
//
//            for(int i = 0; i < nums.length; i++){
//                if(map.containsKey(target - nums[i])){
//                    res[0] = map.get(target - nums[i]);
//                    res[1] = i;
//                }
//                map.put(nums[i],i);
//            }
//            return res;
//        }

        // 解法三：
//        public int[] twoSum(int[] nums, int target) {
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int i = 0; i < nums.length; i++) {
//                map.put(nums[i], i);
//            }
//            for (int i = 0; i < nums.length; i++) {
//                int complement = target - nums[i];
//                if (map.containsKey(complement) && map.get(complement) != i) {
//                    return new int[] { i, map.get(complement) };
//                }
//            }
//            throw new IllegalArgumentException("No two sum solution");
//        }

        // 解法四：执行耗时:2 ms,击败了99.58% 的Java用户 内存消耗:39.8 MB,击败了5.06% 的Java用户
        public int[] twoSum(int[] nums, int target) {
            int[] indexs = new int[2];

            // 建立k-v ，一一对应的哈希表
            HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                if (hash.containsKey(nums[i])) {
                    indexs[0] = i;
                    indexs[1] = hash.get(nums[i]);
                    return indexs;
                }
                // 将数据存入 key为补数 ，value为下标
                hash.put(target - nums[i], i);
            }
            // // 双重循环 循环极限为(n^2-n)/2
            // for(int i = 0; i < nums.length; i++){
            //     for(int j = nums.length - 1; j > i; j --){
            //         if(nums[i]+nums[j] == target){
            //            indexs[0] = i;
            //            indexs[1] = j;
            //            return indexs;
            //         }
            //     }
            // }
            return indexs;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}
public class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(target-nums[i]))
            {
                int []res = {map.get(target-nums[i])+1,i+1};
                return res;
            }
            else map.put(nums[i],i);

        }
        return new int[0];
    }
}

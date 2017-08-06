import java.util.Arrays;

public class TwoSum {
	public static void main(String[] args) {
		int[] nums = {3, 2, 4};
		int target = 6;
		int[] result = twoSum(nums, target);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		boolean found = false;
//		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 1 && !found; i++) {
			for(int j = i + 1; j < nums.length && !found; j++) {
				if(nums[i] + nums[j] == target) {
					found = true;
					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
	}
}

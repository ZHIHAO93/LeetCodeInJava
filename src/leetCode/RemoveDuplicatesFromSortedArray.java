package leetCode;

public class RemoveDuplicatesFromSortedArray {

	public static int removeDuplicates(int[] nums) {
		int j = 0;

		if (nums.length == 0)
			return 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
			}
		}
		return j + 1;
	}
	
	public static void printSolution(int[] nums, int length) {
		System.out.print("[");
		printContent(nums, 0, length - 1);
		System.out.print("]");
	}
	
	public static void printContent(int[] nums, int l, int r) {
		if(l > r)
			return;
		else if(l == r)
			System.out.print(nums[l]);
		else {
			int middle = (r - l) / 2 + l;
			printContent(nums, l, middle);
			System.out.print(",");
			printContent(nums, middle + 1, r);
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 1, 2, 3, 5, 5, 7, 8};
		int length = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);
		RemoveDuplicatesFromSortedArray.printSolution(nums, length);
	}
}

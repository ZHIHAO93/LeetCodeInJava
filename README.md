# LeetCodeInJava

## List of solved problems

* [#1 Two Sum](#two-sum)

## [Two Sum](https://leetcode.com/problems/two-sum/description/)
**Problem description**:

Given an array of integers, return **indices** of the two numbers such that they add up to a specific target.

You may assume that each input would have **exactly** one solution, and you may not use the same element twice.

**Detail**:

Time Complexity： O(n!)
```
public int[] twoSum(int[] nums, int target) {
	int[] result = new int[2];
	boolean found = false;
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
```

**Source code**:
[twoSum.java](source/twoSum.java)

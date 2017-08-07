# LeetCodeInJava

## List of solved problems

* [#1 Two Sum](#two-sum)
* [#7 Reverse Integer](#reverse-integer)

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

## [Reverse Integer](https://leetcode.com/problems/reverse-integer/description/)
**Problem description**:

Reverse digits of an integer.

**Example1:** x = 123, return 321

**Example2:** x = -123, return -321

**Detail**:

Time Complexity： O(n!)
```
public int reverse(int x) {
	long result = 0;
	int y = x;
	while(x != 0) {
		result = result * 10 + x % 10;
		x /= 10;
		if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			return 0;
	}
	return (int)result;
}
```

**Source code**:
[reverseInteger.java](source/reverseInteger.java)

## [Palindrome Number](https://leetcode.com/problems/palindrome-number/description/)
**Problem description**:

Determine whether an integer is a palindrome. Do this without extra space.

**Detail**:

Time Complexity： O(n/2)
```
public boolean isPalindrome(int x) {
	if (x < 0)
	    return false;
	String str = String.valueOf(x);
	int i;
	int j = str.length() - 1;
	for(i = 0; i < str.length() / 2; i++) {
	    if(str.charAt(i) != str.charAt(j))
		return false;
	    else
		j--;
	}
	return true;
}
```

**Source code**:
[palindromeNumber.java](source/palindromeNumber.java)

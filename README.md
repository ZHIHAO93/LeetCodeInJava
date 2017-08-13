# LeetCodeInJava

## List of solved problems

* [#1 Two Sum](#two-sum)
* [#7 Reverse Integer](#reverse-integer)
* [#9 Palindrome Number](#palindrome-number)
* [#13 Roman To Integer](#roman-to-integer)
* [#26 Remove Duplicates from Sorted Array](#remove-duplicates-from-sorted-array)

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

## [Roman To Integer](https://leetcode.com/problems/roman-to-integer/description/)
**Problem description**:

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

**Detail**:

Time Complexity： O(n)
```
public int romanToInt(String s) {
	int length = s.length();
	int result = 0;
	int n = 0, m = 0;
	for (int i = length - 1; i >= 0; i--) {
		m = n;
		switch (s.charAt(i)) {
		case 'I':
			n = 1;
			break;
		case 'V':
			n = 5;
			break;
		case 'X':
			n = 10;
			break;
		case 'L':
			n = 50;
			break;
		case 'C':
			n = 100;
			break;
		case 'D':
			n = 500;
			break;
		case 'M':
			n = 1000;
			break;
		default:
			break;
		}
			
		result = (m <= n)? result + n : result - n;
	}
	return result;
}
```

**Source code**:
[romanToInt.java](source/romanToInt.java)

## [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/)
**Problem description**:

Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,

Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

**Detail**:

Time Complexity： O(n)
```    
public int removeDuplicates(int[] nums) {
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
```

**Source code**:
[RemoveDuplicatesFromSortedArray.java](source/RemoveDuplicatesFromSortedArray.java)

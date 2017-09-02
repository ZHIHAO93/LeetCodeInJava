# LeetCodeInJava

## List of solved problems

* [#1 Two Sum](#1-two-sum)
* [#2 Add Two Numbers](#2-add-two-numbers)
* [#3 Longest Substring Without Repeating Characters](#3-longest-substring-without-repeating-characters)
* [#4 Median of Two Sorted Arrays](#4-median-of-two-sorted-arrays)
* [#7 Reverse Integer](#7-reverse-integer)
* [#9 Palindrome Number](#9-palindrome-number)
* [#13 Roman To Integer](#13-roman-to-integer)
* [#21 Merge Two Sorted Lists](#21-merge-two-sorted-lists)
* [#26 Remove Duplicates from Sorted Array](#26-remove-duplicates-from-sorted-array)

## [#1 Two Sum](https://leetcode.com/problems/two-sum/description/)
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
[TwoSum.java](src/leetCode/TwoSum.java)

## [#2 Add Two Numbers](https://leetcode.com/problems/add-two-numbers/description/)
**Problem description**:

You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

**Input:** (2 -> 4 -> 3) + (5 -> 6 -> 4)
**Output:** 7 -> 0 -> 8

**Detail**:

Time Complexity： O(n) n equal to longer length of l1 and l2
```
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	ListNode tmp = new ListNode(0);
	ListNode result = tmp;
	int n = 0;
	int sum;
	while(l1 != null || l2 != null) {
	    if(l1 != null && l2 != null) {
	    	sum = l1.val + l2.val + n;
	    } else if (l1 != null) {
	    	sum = l1.val + n;
	    } else {
	    	sum = l2.val + n;
	    }
	    
	    if(sum >= 10) n = sum / 10;
	    else n = 0;
	    
	    tmp.next = new ListNode(sum % 10);
	    tmp = tmp.next;
	    if(l1 != null) l1 = l1.next;
	    if(l2 != null) l2 = l2.next;
	}
	
	if(n > 0)
		tmp.next = new ListNode(n);
	
	return result.next;
}
```

**Source code**:
[AddTwoNumbers.java](src/leetCode/AddTwoNumbers.java)

## [#3 Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/)
**Problem description**:

Given a string, find the length of the longest substring without repeating characters.

**Examples:**

Given **"abcabcbb"**, the answer is **"abc"**, which the length is 3.

Given **"bbbbb"**, the answer is **"b"**, with the length of 1.

Given **"pwwkew"**, the answer is **"wke"**, with the length of 3. Note that the answer must be a substring, **"pwke"** is a subsequence and not a substring.

**Detail**:

Time Complexity： O(n) n equal to length of String
```
public int lengthOfLongestSubstring(String s) {
	char[] arr = s.toCharArray();
	TreeMap<Character, Integer> tree = new TreeMap<Character, Integer>();
	int pos = 0;
	int sol = 0;
	for(int i = 0; i < arr.length; i++) {
		char c = arr[i];
		if(tree.containsKey(c) && tree.get(c) >= pos) {
			if(i - pos > sol) sol = i - pos;
			pos = tree.get(c) + 1;
		}
		tree.put(c, i);
	}
	
	if(arr.length - pos > sol) sol = arr.length - pos;
    return sol;
}
```

**Source code**:
[LongestSubstringWithoutRepeatingCharacters.java](src/leetCode/LongestSubstringWithoutRepeatingCharacters.java)

## [#4 Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/description/)
**Problem description**:

There are two sorted arrays **nums1** and **nums2** of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

**Example 1:**
```
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
```
**Example 2:**
```
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
```
**Detail**:

Time Complexity： O(n) n equal to longer length of nums1 and nums2
```
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	TreeMap<Double, Double> tree = new TreeMap<Double, Double>();
	double median = 0.0;
	int p = 0, q = 0;
	int size = 0;

	while (p < nums1.length || q < nums2.length) {
		if (p < nums1.length) {
			tree.put((double) size, (double) nums1[p]);
			p++;
			size++;
		}
		if (q < nums2.length) {
			tree.put((double) size, (double) nums2[q]);
			q++;
			size++;
		}
	}

	ArrayList<Double> list = new ArrayList<Double>(tree.values());
	list.sort(new Comparator<Double>() {

		public int compare(Double o1, Double o2) {
			if (o1 < o2)
				return 1;
			else if (o1 > o2)
				return -1;
			else
				return 0;
		}

	});
	int n = size / 2;

	if (size % 2 == 0)
		median = (list.get(n - 1) + list.get(n)) / 2;
	else
		median = list.get(n);

	return median;
}
```

**Source code**:
[MedianOfTwoSortedArrays.java](src/leetCode/MedianOfTwoSortedArrays.java)

## [#7 Reverse Integer](https://leetcode.com/problems/reverse-integer/description/)
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
[ReverseInteger.java](src/leetCode/ReverseInteger.java)

## [#9 Palindrome Number](https://leetcode.com/problems/palindrome-number/description/)
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
[PalindromeNumber.java](src/leetCode/PalindromeNumber.java)

## [#13 Roman To Integer](https://leetcode.com/problems/roman-to-integer/description/)
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
[RomanToInt.java](src/leetCode/RomanToInt.java)

## [#21 Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/description/)
**Problem description**:

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

**Detail**:

Time Complexity： O(n) n equal to the sum of the length of l1 and l2.
```    
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	ListNode tmp = new ListNode(0);
	ListNode result = tmp;
	while(l1 != null || l2 != null) {
		if(l1 != null && l2 != null) {
			if(l1.val > l2.val) {
				tmp.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			else {
				tmp.next = new ListNode(l1.val);
				l1 = l1.next;
			}
		} else if (l1 != null) {
		    tmp.next = new ListNode(l1.val);
		    l1 = l1.next;
		} else {
		    tmp.next = new ListNode(l2.val);
		    l2 = l2.next;
		}
		tmp = tmp.next;
	}
    return result.next;
}
```

**Source code**:
[MergeTwoSortedList.java](src/leetCode/MergeTwoSortedList.java)

## [#26 Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/)
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
[RemoveDuplicatesFromSortedArray.java](src/leetCode/RemoveDuplicatesFromSortedArray.java)

package leetCode;

import java.util.TreeMap;

public class LongestSubstringWithoutRepeatingCharacters {
	
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
	
	public static void main(String[] args) {
		String[] s = {"abcabcbb", "bbbbb", "pwwkew"};
		for(int i = 0; i < s.length; i++) {
			System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s[i]));
		}
	}
}

package leetCode;

import java.util.Stack;

public class ValidParentheses {
	
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>(); 
		char c;
		for(int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if(c == '(' || c == '[' || c == '{') {
				stack.push(c);
			}
			else if(c == ')' || c == ']' || c == '}') {
				if(stack.isEmpty())
					return false;
				char n = stack.lastElement();
				if(c - n <= 2 && c - n >= 0)
					stack.pop();
				else
					return false;
			}
		}
		if(stack.isEmpty())
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		String[] s = {"{{}}"};
		ValidParentheses vp = new ValidParentheses();
		for(int i = 0; i < s.length; i++) {
			System.out.println(vp.isValid(s[i]));
		}
	}
}

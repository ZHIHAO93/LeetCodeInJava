package leetCode;

public class PalindromeNumber {
	public static void main(String[] args) {
		int[] num = {12321, 2332, -2147447412};
		for(int i = 0; i < num.length; i++) {
			System.out.println(isPalindrome(num[i]));
		}
	}
	
    public static boolean isPalindrome(int x) {
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
}

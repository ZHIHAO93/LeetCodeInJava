package leetCode;

public class ReverseInteger {
	public static void main(String[] args) {
		int[] data = {1534236469, 1000000003, 1000000002, -2147483648,
				 -1000000003, -1000000002, -2147483412};
		for(int i = 0; i < data.length; i++) {
			System.out.println(reverse(data[i]));
		}
	}
	
	public static int reverse(int x) {
		long result = 0;
		while(x != 0) {
			result = result * 10 + x % 10;
			x /= 10;
			if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
				return 0;
		}
		return (int)result;
	}
}

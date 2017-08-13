package leetCode;

public class RomanToInt {
	public static void main(String[] args) {
		String[] nRoman = {"LXXIII", "XLVIII", "XVII", "XIX"};
		for (int i = 0; i < nRoman.length; i++) {
			System.out.println(solution(nRoman[i]));
		}
	}

	public static int solution(String s) {
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
}

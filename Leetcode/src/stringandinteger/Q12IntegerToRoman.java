package stringandinteger;

public class Q12IntegerToRoman {
	public static void main(String[] args) {
		int a = 1994;
		String res = intToRoman(a);
		System.out.println(res);
	}

	/*
	 * Method 1:
	 * 
	 * Results: runtime 7 ms beats 34.98% memory 38.1 mb beats 74.02%
	 * 
	 */
	public static String intToRoman(int num) {
		String res = "";
		int index = 0;
		while (num != 0) {
			int a = num % 10;
			if (a == 4 || a == 9) {
				res = intToRomanSub((int) (a * Math.pow(10, index))) + res;
			} else if (a >= 5) {
				for (int i = 1; i <= a - 5; i++) {
					res = intToRomanSub((int) (Math.pow(10, index))) + res;
				}
				res = intToRomanSub((int) (5 * Math.pow(10, index))) + res;
			} else {
				for (int i = 1; i <= a; i++) {
					res = intToRomanSub((int) (Math.pow(10, index))) + res;
				}
			}
			num = num / 10;
			index++;
		}
		return res;
	}

	private static String intToRomanSub(int num) {
		switch (num) {
		case 1:
			return "I";
		case 4:
			return "IV";
		case 5:
			return "V";
		case 9:
			return "IX";
		case 10:
			return "X";
		case 40:
			return "XL";
		case 50:
			return "L";
		case 90:
			return "XC";
		case 100:
			return "C";
		case 400:
			return "CD";
		case 500:
			return "D";
		case 900:
			return "CM";
		case 1000:
			return "M";
		default:
			return "";
		}
	}
}

package leetcode;

public class Q157 {
	public int read(char[] buf, int n) {
		int index = 0;
		char[] buf4 = new char[4];
		while (n > 0) {
			int tmp = read4(buf4);
			int tmpindex = n > tmp ? tmp : n;
			n -= 4;
			System.arraycopy(buf4, 0, buf, index, tmpindex);
			// for(int i=0;i<tmpindex;i++){
			// buf[index++]=buf4[i];
			// System.out.print(buf4[i]);
			// }
			index += tmpindex;
		}
		return index;
	}
}

package pg_git;

class SmallestRec {
	public int solution(int[][] sizes) {

		for (int[] s : sizes) {
			int temp = 0;
			if (s[0] < s[1]) {
				temp = s[0];
				s[0] = s[1];
				s[1] = temp;
			}
		}
		int w = 0;
		int h = 0;

		for (int[] s : sizes) {
			if (s[0] > w) {
				w = s[0];
			}
			if (s[1] > h) {
				h = s[1];
			}
		}
		
		return w*h;
	}
}

public class Lv1_smallestRectangle {
	public static void main(String[] args) {
		SmallestRec sr = new SmallestRec();
		int[][] s = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };
		System.out.println(sr.solution(s));
	}
}

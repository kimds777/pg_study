package pg_git;

public class Lv1_watermelon {
	public String solution(int n) {
		char[] wm = new char[n/2+1];
		return String.valueOf(wm).replace("\0", "수박").substring(0, n);
	}
//	public String solution(int n) {
//		StringBuilder sb = new StringBuilder();
//		if (n % 2 == 0) {
//			for (int w = 0; w < n / 2; w++) {
//				sb.append("수박");
//			}
//		} else {
//			if (n == 1) {
//				sb.append("수");
//			} else {
//				for (int w = 0; w < n / 2; w++) {
//					sb.append("수박");
//				}
//				sb.append("수");
//			}
//		}
//		return sb.toString();
//	}
}

package pg_git;

public class Lv1_middleLetterGet {
	public String solution(String s) {
		String answer;
		int length = s.length();
		int middle = length / 2;
		if (length % 2 == 0) {
			answer = s.substring(middle - 1, middle + 1);
		} else {
			answer = s.substring(middle, middle + 1);
		}
		return answer;
	}
//	public String solution(String s) {
//		int length = s.length();
//		if (length % 2 == 0) {
//			int middle = length / 2;
//			StringBuilder sb = new StringBuilder();
//			for (int m = middle-1; m <= middle; m++) {
//				sb.append(s.charAt(m));
//			}
//
//			return sb.toString();
//		} else {
//			int middle = length / 2;
//			return String.valueOf(s.charAt(middle));
//		}
//	}	
}

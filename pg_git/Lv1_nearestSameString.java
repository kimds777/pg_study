package pg_git;

class Nearest {
	public int[] solution(String s) {
		int leng = s.length();
		int[] answer = new int[leng];
		char[] charArr = s.toCharArray();



		for (int i = 1; i < leng; i++) {
			answer[i] = -1;
			for (int j = i - 1; j >= 0; j--) {
				System.out.println(charArr[i]);
				if (charArr[i] == charArr[j]) {
					answer[i] = i - j;
					break;
				}
			}
		}

		return answer;
	}
}

public class Lv1_nearestSameString {
	public static void main(String[] args) {
		Nearest n = new Nearest();
		int[] ans = n.solution("banana");

		for (int a : ans) {
			System.out.print(a + " ");
		}
	}
}

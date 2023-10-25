package pg_git;

class SecretMap {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		for (int i = 0; i < n; i++) {
			String a1 = Integer.toBinaryString(arr1[i]);
			String a2 = Integer.toBinaryString(arr2[i]);

			if (a1.length() < n) {
				a1 = "0".repeat(n - a1.length()).concat(a1);
			}
			if (a2.length() < n) {
				a2 = "0".repeat(n - a2.length()).concat(a2);
			}

			char[] ch = new char[n];
			for (int j = 0; j < n; j++) {
				if (a1.charAt(j) == '1' || a2.charAt(j) == '1') {
					ch[j] = '#';
				} else {
					ch[j] = ' ';
				}
			}

			answer[i] = String.valueOf(ch);

		}
		return answer;
	}
}

public class Lv1_secretMap {
	public static void main(String[] args) {
		int n = 6;
		int[] arr1 = { 46, 33, 33 ,22, 31, 50 };
		int[] arr2 = { 27 ,56, 19, 14, 14, 10 };

		String[] ans = new SecretMap().solution(n, arr1, arr2);
		for (String a : ans) {
			System.out.print("\"" + a + "\", ");
		}
	}
}

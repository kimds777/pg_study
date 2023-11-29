package pg_git;

class KakaoDartGame { // 수정 필요함!
	public int solution(String dartResult) {
		int answer = 0;
		char[] dart = dartResult.toCharArray();
		int leng = dart.length;

		for (int i = 0; i < leng; i++) {
			int o = 1;
			if (dart[i] == 'S') {
				if (i + 1 < leng) {
					o = option(dart[i + 1]);
					if (checkO(o)) {
						answer *= o;
					}
				}
				answer += dart[i - 1] - 48;
			} else if (dart[i] == 'D') {
				if (i + 1 < leng) {
					o = option(dart[i + 1]);
					if (checkO(o)) {
						answer *= o;
					}
				}
				answer += (int) Math.pow(dart[i - 1] - 48, 2) * o;
			} else if (dart[i] == 'T') {
				if (i + 1 < leng) {
					o = option(dart[i + 1]);
					if (checkO(o)) {
						answer *= o;
					}
				}
				answer += (int) Math.pow(dart[i - 1] - 48, 3) * o;
			}
		}
		return answer;
	}

	public int option(char d) {
		if (d == '#') {
			return -1;
		} else if (d == '*') {
			return 2;
		} else {
			return 1;
		}
	}

	public boolean checkO(int o) {
		if (o == 2) {
			return true;
		} else {
			return false;
		}
	}
}

public class Lv1_kakaoDartGame {
	public static void main(String[] args) {
		String dartResult = "1D2S3T*";
		int ans = new KakaoDartGame().solution(dartResult);
		System.out.println(ans);
	}
}

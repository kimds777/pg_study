package pg_git;

class Reapply {
	public int solution(int n, int m, int[] section) {
		int answer = 0;
		int start = section[0];
		answer++;

		for(int s : section) {
			if(start + m > s) {
				continue;
			}
			
			start = s;
			answer++;
		}

		return answer;
	}
}

public class Lv1_reapply {
	public static void main(String[] args) {
		int n = 4;
		int m = 1;
		int[] section = { 1, 2, 3, 4 };

		int ans = new Reapply().solution(n, m, section);
		System.out.println(ans);
	}
}

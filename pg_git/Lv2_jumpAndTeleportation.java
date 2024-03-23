package pg_git;

class JumpAndTeleportation {
	public int solution(int n) {
		int jump = 0;
		while (n > 0) {
			
			if (n % 2 == 0) { // 이동거리인 n이 2의 배수인 경우
				n /= 2; // 순간이동이므로 이동거리인 n에서 2를 나눠준다.
			} else { // n이 2의 배수가 아닌 경우
				n--; // n에서 1을 빼주고
				jump++; // jump에 1을 더해준다.
			}
		}
		return jump;
	}

}

public class Lv2_jumpAndTeleportation {
	public static void main(String[] args) {
		JumpAndTeleportation jt = new JumpAndTeleportation();
		System.out.println(jt.solution(5));
	}
}

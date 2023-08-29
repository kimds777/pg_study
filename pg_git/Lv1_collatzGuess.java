package pg_git;

public class Lv1_collatzGuess {
	//while문 활용 풀이!
	//파라미터 값을 long으로 설정한 이유
	// -> int를 파라미터로 사용시 큰수를 연산하는 과정에서 오버플로우 발생!
	public int whileSolution(long num) {

		int count = 0;
		while (num != 1) {

			if (num % 2 == 0) {
				num /= 2;
				++count;
			} else {
				num = num * 3 + 1;
				++count;
			}

			if (count >= 500) {
				return -1;
			}

		}

		return count;
	}

	//삼항연산자 활용 풀이!
	public int ternaryOperatorSolution(long num) {

		for (int cnt = 0; cnt < 500; cnt++) {
			if (num == 1) {
				return cnt;
			}
			num = (num % 2 == 0) ? num / 2 : num * 3 + 1;
		}
		return -1;

	}
}

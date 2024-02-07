package pg_git;

class NextBigNumber {
	public int solution(int n) { // bitCount -> true bit (1) 의 갯수를 반환해주는 함수를 사용하여 효율성 테스트 통과!
		int answer = n;
		int nBinaryCount = Integer.bitCount(n); // n의 이진수 1 갯수
		while(true) {
			answer++;
        	int nextBinaryCount = Integer.bitCount(answer); // answer의 이진수 1 갯수
        	if(nextBinaryCount == nBinaryCount) { // 1의 갯수가 동일한 경우
        		break; // 반복문 종료
        	}
		}
		return answer;
	}
//	효율성 테스트 시간초과...
//	public int solution(int n) { 
//        int answer = n;
//        String nBinary = Integer.toBinaryString(n).replaceAll("0", "");
//        while(true) {
//        	answer++;
//        	String nextBinary = Integer.toBinaryString(answer).replaceAll("0", "");
//        	if(nextBinary.equals(nBinary)) {
//        		break;
//        	}
//        }
//        return answer;
//    }
}

public class Lv2_nextBigNumber {
	public static void main(String[] args) {
		int n = 78;
		
		int ans = new NextBigNumber().solution(n);
		System.out.println(ans);
	}
}

package pg_git;

class ExpectedListOfMatches {
    public int solution(int n, int a, int b) {
        int answer = 0;

        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }
        return answer;
    }
}

public class Lv2_expectedListOfMatches {
    public static void main(String[] args) {
        ExpectedListOfMatches em = new ExpectedListOfMatches();
        System.out.println(em.solution(8, 4, 7));
    }
}

package pg_git;

class Obversion{
    public int solution(int n) {
        String answer = Integer.toString(n, 3);
        StringBuffer sb = new StringBuffer(answer);
        answer = sb.reverse().toString();
        return Integer.parseInt(answer,3);
    }
}

public class Lv1_ternaryScaleObversion {
	public static void main(String[] args) {
		Obversion o = new Obversion();
		System.out.println(o.solution(45));
	}
}

package pg_git;

class Handling {
	public boolean solution(String s) {
		boolean answer = true;
		int len = s.length();
		
		if(len==4 && len==6) {
			try {
				Long.parseLong(s);
			} catch (NumberFormatException e) {
				answer = false;
			}
		}
		return answer;
	}
}

public class Lv1_StringHandling {
	public static void main(String[] args) {
		Handling h = new Handling();
		System.out.println(h.solution("1234"));		
	}
}

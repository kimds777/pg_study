package pg_git;

class CaesarCipher {
	public String solution(String s, int n) {
		StringBuilder sb = new StringBuilder();
		System.out.println(s);
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			if (ch != ' ') {
				boolean b = Character.isUpperCase(ch);
				ch = Character.toLowerCase(ch);
				int c = (int) ch;
				c += n;
				
				if(c > 122) {
					c -= 26;
					System.out.println("z를 초과하는 경우: "+c);
				}
				
				if(b) {
					c -= 32;
					System.out.println("대문자인 경우: "+c);
				}
				
				sb.append((char)c);
			} else {
				sb.append(' ');
			}
		}
		return sb.toString();
	}
}

public class Lv1_caesarCipher {
	public static void main(String[] args) {
		CaesarCipher cc = new CaesarCipher();
		System.out.println(cc.solution("AB", 1));
	}
}

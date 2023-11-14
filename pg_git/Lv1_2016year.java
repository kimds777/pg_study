package pg_git;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

class Year {
    public String solution(int a, int b) {        
        LocalDate date = LocalDate.of(2016, a, b);
        DayOfWeek dayOfWeek = date.getDayOfWeek(); 
        
        String answer = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US);        
        return answer.toUpperCase();
    }
}

public class Lv1_2016year {
	public static void main(String[] args) {
		String day = new Year().solution(5, 24);
		System.out.println(day);
	}
}

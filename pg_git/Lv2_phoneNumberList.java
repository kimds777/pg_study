package pg_git;

import java.util.Arrays;

public class Lv2_phoneNumberList {
    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        boolean answer = true;
        for (int i = 0; i < phone_book.length - 1; i++) {

            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] phone_book = {"123", "456", "789"};
        System.out.println(solution(phone_book));
    }
}

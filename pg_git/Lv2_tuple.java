package pg_git;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lv2_tuple {
    public static int[] solution(String s) {

//        s = s.substring(1, s.length() - 1);
//        System.out.println(s);
//
//        List<String> subStr = new ArrayList<>(List.of(s.split("\\},\\{")));
//        subStr.add(0, subStr.get(0).replace("{", ""));
//        subStr.remove(1);
//
//        int lastIndex = subStr.size() - 1;
//        subStr.add(lastIndex, subStr.get(lastIndex).replace("}", ""));
//        subStr.remove(lastIndex + 1);
//
//        subStr.sort((s1,s2) -> Integer.compare(s1.length(), s2.length()));

        String[] subStr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        
        Arrays.sort(subStr, (a, b) -> {
            return a.length() - b.length();
        });

        int i = 0;
        int[] answer = new int[subStr.length];
        Set<String> checkNumber = new HashSet();

        for (String ss : subStr) {
            String[] splitStr = ss.split(",");
            for (String sps : splitStr) {
                if (checkNumber.add(sps)) {
                    answer[i++] = Integer.parseInt(sps);
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

        int[] ans = solution(s);
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }
}

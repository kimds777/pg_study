package pg_git;

import java.util.HashMap;

public class Lv2_clothes {
    public static int solution(String[][] clothes) {

        HashMap<String, Integer> checkClothes = new HashMap();
        for (String[] clothe : clothes) {
            int cnt = checkClothes.getOrDefault(clothe[1], 0) + 1;
            checkClothes.put(clothe[1], cnt);
        }

        int answer = 1;
        for (String key : checkClothes.keySet()) {
            answer *= checkClothes.get(key) + 1 ;
        }

        return answer - 1;
    }

    public static void main(String[] args) {
//        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
//        String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        String[][] clothes = {{"a", "A"}, {"b", "B"}, {"c", "C"}};


        System.out.println(solution(clothes));
    }
}

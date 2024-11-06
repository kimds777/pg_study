package pg_git;

import java.util.LinkedList;
import java.util.Queue;

public class Lv2_cache {
    public static Queue<String> dbCache;

    public static int containCity(String city, int answer) {
        dbCache.remove(city);
        dbCache.offer(city);
        answer++; // cache hit!!

        return answer;
    }

    public static int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) { // cacahe 사이즈가 0인 경우
            return cities.length * 5;
        }

        dbCache = new LinkedList();

        int answer = 0;
        for (String city : cities) {
            city = city.toLowerCase(); // 대소문자 구분 방지

            if (dbCache.size() >= cacheSize) { // cache가 꽉찬 경우
                if (dbCache.contains(city)) { // dbCache에 도시 이름이 있는 경우

                    answer = containCity(city, answer);

                } else { // cache miss!!

                    dbCache.remove();
                    dbCache.offer(city);
                    answer += 5;
                }
            } else { // cache에 공간이 있는 경우
                if (dbCache.contains(city)) { // dbCache에 도시 이름이 있는 경우

                    answer = containCity(city, answer);

                } else {
                    dbCache.offer(city);
                    answer += 5;
                }

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int cacheSize = 3;
//        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        String[] cities = {"A", "B", "C", "A", "D", "G", "A"};

        System.out.println(solution(cacheSize, cities));
    }
}

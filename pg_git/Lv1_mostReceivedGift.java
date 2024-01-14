package pg_git;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MostReceivedGift {
	public int solution(String[] friends, String[] gifts) {
		Map<String, Map<String, Integer>> friendGiftInfo = new HashMap<>(); // 선물을 준 사람 -> key , 선물을 받은 사람 + 갯수 -> value
		Map<String, Integer> giftCount = new HashMap<>(); // 선물 받은 사람 -> key, 받은 선물 갯수 -> value
		for (String f : friends) {

			Map<String, Integer> friend = new HashMap<>(); 
			for (String fr : friends) {
				friend.put(fr, 0); // 선물을 주고 받은 기록이 없어도 선물 지수로 비교해야하기 때문에 모든 사람을 넣는다.
			}

			friendGiftInfo.put(f, friend);
			giftCount.put(f, 0);
		}

		for (String g : gifts) {
			String[] gift = g.split(" ");
			Map<String, Integer> giveGiftFriend = friendGiftInfo.get(gift[0]); // 선물 받은 사람들의 이름과 갯수를 넣을 map

			giveGiftFriend.replace(gift[1], giveGiftFriend.get(gift[1]) + 1); // 선물 받은 갯수 1씩 증가
			giftCount.replace(gift[1], giftCount.get(gift[1]) + 1); // 선물 받은 사람의 선물 갯수 1씩 증가
		}

		List<Integer> nextMonthGifts = new ArrayList<>(); // 다음달에 선물 받을 사람들의 선물 갯수
		for (String f : friends) {
			int nextMonthGiftCount = 0;
			Map<String, Integer> giveGiftFriend = friendGiftInfo.get(f);

			for (String key : giveGiftFriend.keySet()) { // 친구들 조회
				Map<String, Integer> friend = friendGiftInfo.get(key);
				if (giveGiftFriend.get(key) != 0) { // 내가 선물을 준 친구인 경우

					if (!friend.containsKey(f)) { // 친구가 나한테 선물을 안 준 경우
						nextMonthGiftCount++; // 다음달에 받을 선물 갯수에 1을 증가
					} else { // 친구가 나한테 선물을 준 경우
						int fromFriend = friend.get(f); // 내가 친구한테 받은 선물 갯수
						int fromMe = giveGiftFriend.get(key); // 친구가 나한테 받은 선물 갯수

						if (fromMe > fromFriend) { // 내가 친구에게 준 선물 갯수가 더 큰 경우
							nextMonthGiftCount++;

						} else if (fromMe == fromFriend) { // 나와 친구가 서로에게 준 선물 갯수가 동일한 경우
							// 선물 지수로 비교
							nextMonthGiftCount = getGiftIndex(friend, giveGiftFriend, giftCount, f, key, nextMonthGiftCount);
						}
					}

				} else { // 친구가 나에게 준 선물이 없는 경우
					int fromFriend = friend.get(f); // 친구가 나한테 준 선물 갯수
					if (fromFriend == 0) { // 친구가 나한테 준 선물 갯수가 0인 경우 -> 서로 선물을 주고 받은 기록이 없는 경우!
						// 선물 지수로 비교
						nextMonthGiftCount = getGiftIndex(friend, giveGiftFriend, giftCount, f, key, nextMonthGiftCount);
					}
				}

			}
			nextMonthGifts.add(nextMonthGiftCount); // 다음달에 선물 받을 갯수를 리스트에 저장
		}
		
		Collections.sort(nextMonthGifts, Comparator.reverseOrder()); // 리스트 역정렬
		
		return nextMonthGifts.get(0); // 가장 큰 숫자 출력
	}

	private int getGiftIndex(Map<String, Integer> friend, Map<String, Integer> giveGiftFriend,
			Map<String, Integer> giftCount, String f, String key, int nextMonthGiftCount) {
		int myGiftIndex = 0; // 나의 선물 지수
		int friendGiftIndex = 0; // 친구의 선물 지수

		for (String k : giveGiftFriend.keySet()) {
			myGiftIndex += giveGiftFriend.get(k); // 내가 준 모든 선물 갯수를 더한다.
		}
		myGiftIndex -= giftCount.get(f); // 내가 받은 모든 선물 갯수를 빼준다.

		for (String k : friend.keySet()) {
			friendGiftIndex += friend.get(k); // 친구가 준 모든 선물 갯수를 더한다.
		}

		friendGiftIndex -= giftCount.get(key); // 친구가 받은 모든 선물 갯수를 빼준다.

		if (myGiftIndex > friendGiftIndex) { // 내가 친구보다 선물 지수가 큰 경우
			nextMonthGiftCount++;
		}

		return nextMonthGiftCount;
	}
}

public class Lv1_mostReceivedGift {
	public static void main(String[] args) {
		String[] friends = { "muzi", "ryan", "frodo", "neo" };
		String[] gifts = { "muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi",
				"frodo ryan", "neo muzi" };

		int ans = new MostReceivedGift().solution(friends, gifts);
		System.out.println(ans);
	}
}

package kakao_blind_2022;

import java.util.*;

public class Solution_v2 {
    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = {};

        Map<String, HashSet<String>> kill_list = new HashMap<>(); //1:n 관계의 map (신고자(1), 신고받은자(n))
        Map<String, Integer> id_Map = new LinkedHashMap<>(); // 신고자와 인덱스를 관리하는 map (링크드리스트는 순서대로 삽잆한다)

        for(int i = 0; i < id_list.length; i++) {
            kill_list.put(id_list[i],new HashSet<>());
            id_Map.put(id_list[i],i);
        }

        for(String str : report){
            String[] newStr= str.split(" ");

            /*각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
            * 신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
            * 한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.*/

            /*1.hashset은 중복을 제외하고 삽입
            * 2.신고 당한 사람을 신고자에 맵핑
            * */
            kill_list.get(newStr[1]).add(newStr[0]);
        }
        System.out.println(kill_list);
        answer = new int[id_list.length];

        for(String key : kill_list.keySet()){//전체 대상 검색
            /*k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.*/
            if(kill_list.get(key).size() >= k) { //대상중 신고 건수가 k보다 크거나 같은 애들 확인

                for(String kill : kill_list.get(key)) // 메일발송 대상 key 값 가져오기
                    answer[id_Map.get(kill)]++; //id map에 해당하는 index ++
            }
        }

        return answer;
    }
}

package programmers.kakao_blind_2022;

import java.util.*;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        /*각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.*/
        /*신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.*/
        /*한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.*/

        /*k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.*/
        int[] answer = {};
        int[] answer_tmp = {};

        //name_arr
        HashMap<String, ArrayList<String>> dic = new LinkedHashMap<String, ArrayList<String>>();

        String [] tokens ;

        for(int i = 0; i < id_list.length; i++) {
            ArrayList<String> kill_name = new ArrayList<String>();

            for (int j = 0; j < report.length; j++){
                tokens = report[j].split(" ");

                if(id_list[i].equals(tokens[0])){
                    if(!kill_name.contains(tokens[1])) {
                        kill_name.add(tokens[1]);
                    }
                }
            }
            dic.put(id_list[i],kill_name);
        }

        answer = new int[id_list.length];
        answer_tmp = new int[id_list.length];

        for(int i = 0; i < id_list.length; i++) {
            int count = 0;
            int seq = 0;
            for(String j : dic.keySet()) { //저장된 key값 확인

                count = Collections.frequency(dic.get(j), id_list[i]);
                answer_tmp[i] = answer_tmp[i] + count;
            }

            if(answer_tmp[i] >= k){

                for (Map.Entry<String, ArrayList<String>> entry : dic.entrySet()) {


                    answer[seq] = answer[seq] + Collections.frequency(entry.getValue(), id_list[i]);

                    seq++;
                }
            }
        }

        return answer;
    }
}

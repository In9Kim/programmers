package programmers.kakao_blind_2022;

public class Solution_main {
    public static void main(String[]args){
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        int result = 0;
        int result1 = 0;

        Solution s = new Solution();
        Solution_v2 s2 = new Solution_v2();

        //s.solution(id_list,report,k);

        s2.solution(id_list,report,k);

    }
}

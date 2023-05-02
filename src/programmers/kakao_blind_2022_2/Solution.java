package programmers.kakao_blind_2022_2;
import java.util.*;
class Solution {
    /*
    1.채팅하는데 본래 닉네임 말고 말고 가상 닉네임 가능
    2.김크루가 오픈채팅방 개설을 위해 사람들 왔다갔다 하는 관리자창 만듬
    3.누가 들어오면 "[닉네임]님이 들어왔습니다."
    4.누가 나가면 "[닉네임]님이 들어왔습니다."
    5.닉변 방법
        1. 채팅방 나간 후 새로운 닉넴으로 들어오기
        2. 채팅방에서 닉넴 바꾸기
    6.닉변하면 기존 채팅방 출력 닉네임도 싹 바뀜
    7.중복닉네임 허용
    8.채팅방 들어오거 나가거나 닉변 기록하는 문자열 배일이 record 매개변수 주어질때 모두 기록
    9.최종적으로 방 개설한 사람이 보게되는 메세지 문자열 배열 형태로 return
    */
    public String[] solution(String[] record) {
        String [] answer = {};

        HashMap<String,String> enter_map = new LinkedHashMap<>();
        ArrayList<String>final_str = new ArrayList<>();

        String [] tokens = {};
        
        //1. leave 빼고 key:value값 넣기
        //hashmap 특성상 이미 있는 키값의 value는 치환된다
        for(int i = 0; i < record.length; i ++){
            tokens = record[i].split(" ");
            if(tokens.length > 2){
                enter_map.put(tokens[1],tokens[2]);
            }
        }

        //2. Change는 continue한다(이미 위에서 최종 아이디를 가공했다)
        //나머지 경우는 이미 위에서 넣어둔 key:value 값을 이용하여, 출력한다.
        for(int i = 0; i < record.length; i ++) {
            tokens = record[i].split(" ");
            if (tokens[0].equals("Change")) continue;
            if (tokens[0].equals("Leave")) {
                final_str.add(enter_map.get(tokens[1])+"님이 나갔습니다.");
            } else {
                final_str.add(enter_map.get(tokens[1])+"님이 들어왔습니다.");
            }
        }
        answer = final_str.toArray(new String[final_str.size()]);

        return answer;
    }
}
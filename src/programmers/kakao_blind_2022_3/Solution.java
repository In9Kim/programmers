package programmers.kakao_blind_2022_3;

import java.lang.*;

public class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;

        for(int phone:numbers){
            if(phone == 1 || phone == 4 || phone == 7){
                answer += "L";
                left = phone;
            }else if(phone == 3|| phone == 6 || phone == 9){
                answer += "R";
                right = phone;
            }else{
                if(phone==0) phone=11;
                int leftdist = Math.abs(phone-left)/3+Math.abs(phone-left)%3;
                int rightdist = Math.abs(phone-right)/3+Math.abs(phone-right)%3;

                if(leftdist<rightdist){
                    answer += "L";
                    left = phone;
                }else if(leftdist>rightdist){
                    answer += "R";
                    right = phone;
                }else{
                    if(hand.equals("left")){
                        answer += "L";
                        left = phone;
                    }else{
                        answer += "R";
                        right = phone;
                    }
                }
            }
        }
        return answer;
    }
}

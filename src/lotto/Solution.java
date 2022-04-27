package lotto;

import java.util.*;
public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};

        int zero_cnt = 0;
        int same_cnt = 0;
        for(int i : lottos){
            if(i == 0){
                zero_cnt ++;
                continue;
            }
            for(int j : win_nums){
                if(j == i){
                    same_cnt ++;
                    break;
                }
            }
        }

        System.out.println(zero_cnt + same_cnt); // 최고일떈 0이 맞았다고 간주 + 같은 숫자들
        System.out.println(same_cnt); //최저일떈 같은 숫자들만

        /*
        * 최고 등수는 다 맞았다고 간주했을때 개수를 7에서 뺸다
        * 최저 등수는 맞은 개수만 개수를 7에서 뺸다
        *
        * 다 틀린 경우는 6등이니까 max함수를 통해 1로 간주시킨다
        * */
        return new int[]{7-Math.max(zero_cnt + same_cnt,1),7-Math.max(same_cnt,1)};
    }
}

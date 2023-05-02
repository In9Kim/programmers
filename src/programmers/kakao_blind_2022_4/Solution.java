package programmers.kakao_blind_2022_4;

import java.util.*;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        /*
        1.멈춘 위치에서 가장 위에 있는 인형 집어올릴수 있다
        2.집어올리면 바구니에 쌓인다
        3.같은거 두개 쌓이면 터진다
        4.크레인 작동 후 터트려진 인형개수 return
        */

        Stack<Integer>st = new Stack<>();
        st.push(0);

        for(int ii = 0; ii < moves.length; ii++) {
            for (int j = 0; j < board.length; j++) {
                if(board[j][moves[ii]-1] == 0) continue;
                else {
                    if(st.peek() == board[j][moves[ii]-1] ){
                        st.pop();
                        answer = answer + 2;
                    }else{
                        st.push(board[j][moves[ii] - 1]);
                    }
                    board[j][moves[ii]-1] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}

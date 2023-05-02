package programmers.kakao_blind_2022_4;

public class Solution_main {
    public static void main(String[]args){
        int [][] board = {{0,0,0,0,0}
                         ,{0,0,1,0,3}
                         ,{0,2,5,0,1}
                         ,{4,2,4,4,2}
                         ,{3,5,1,3,1}};
        int [] moves= {1,5,3,5,1,2,1,4};

        Solution s1 = new Solution();

        s1.solution(board,moves);
    }
}

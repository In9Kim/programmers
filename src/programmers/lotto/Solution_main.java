package programmers.lotto;

public class Solution_main {
    public static void main(String[]args){
        /*
        lottos	win_nums
        [44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]
        [0, 0, 0, 0, 0, 0]	[38, 19, 20, 40, 15, 25]
        [45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]
         */
        int[] lottos ={44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        Solution s = new Solution();

        s.solution(lottos,win_nums);
    }
}

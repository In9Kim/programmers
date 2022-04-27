package Solution;
import Solution.Solution;

public class Solution_main {
    public static void main(String[]args){
        Solution solution1 = new Solution();
        Solution_20220306 solution2 = new Solution_20220306();
        String[] ledgers = new String[7];

        ledgers[0]="01/01 4 50000";
        ledgers[1]="01/11 6 3555";
        ledgers[2]="02/01 0 -23555";
        ledgers[3]="02/25 5 5000";
        ledgers[4]="03/25 0 -15000";
        ledgers[5]="06/09 8 43951";
        ledgers[6]="12/30 9 99999";

        int answer = solution1.solution(ledgers);
        System.out.println("answer: "+answer);
        //int answer = solution2.solution(ledgers);
    }
}

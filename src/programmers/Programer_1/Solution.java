package programmers.Programer_1;

public class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int temp = 0;

        for(int i = 0; i<numbers.length; i++){
            temp += numbers[i];
        }

        answer = 45 - temp;

        return answer;
    }
}

package programmers.programmer_stack_1;

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>(); //int형 스택 선언

        stack.push(arr[0]);

        for(int i:arr){
            if(stack.peek() == i) continue;
            stack.push(i);
        }
        answer = stack.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;
    }
}
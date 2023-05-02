package programmers.programmer_hash_1;

import java.util.*;

public class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int result_length = nums.length / 2;
        HashSet<Integer> hashSet = new HashSet<>();

        for(Integer temp:nums){
            hashSet.add(temp);
        }

        if(result_length > hashSet.size()){
            answer = hashSet.size();
        }
        else{
            answer = result_length;
        }

        return answer;
    }
}
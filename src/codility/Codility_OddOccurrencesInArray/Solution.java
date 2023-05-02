package codility.Codility_OddOccurrencesInArray;
import java.util.*;

public class Solution {
    public int solution(int[] A) {
        int answer = -1;
        HashSet<Integer> hs = new HashSet<>();

        for (int tmp:A) {
            if (hs.contains(tmp)) {
                //존재
                hs.remove(tmp);
            } else {
                //없으면
                hs.add(tmp);
            }
        }
        ArrayList<Integer> al = new ArrayList<>(hs);
        answer = al.get(0);
        return answer;
    }
}

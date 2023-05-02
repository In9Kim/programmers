package codility.Codility_CyclicRotation;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

/*
An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).

The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

Write a function:

class Main_1330 { public int[] solution(int[] A, int K); }

that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given

    A = [3, 8, 9, 7, 6]
    K = 3
the function should return [9, 7, 6, 3, 8]. Three rotations were made:

    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
For another example, given

    A = [0, 0, 0]
    K = 1
the function should return [0, 0, 0]

Given

    A = [1, 2, 3, 4]
    K = 4
the function should return [1, 2, 3, 4]

Assume that:

N and K are integers within the range [0..100];
each element of array A is an integer within the range [−1,000..1,000].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
* */
class Solution {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        if(A.length == 0) return A;

        LinkedList<Integer>linked  = new LinkedList<Integer>();
        for(int tmp:A){
            linked.add(tmp);
        }

        for(int i = 0; i < K; i++){
            int last = linked.get(linked.size()-1);

            linked.addFirst(last);//가장 앞에 데이터 추가
            linked.removeLast(); //가장 뒤의 데이터 제거
        }

        int [] arr = new int[linked.size()];
        for (int j = 0 ; j < linked.size() ; j++) {
            arr[j] = linked.get(j).intValue();
        }

        return arr;
    }
}
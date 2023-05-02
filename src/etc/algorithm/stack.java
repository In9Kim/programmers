package etc.algorithm;
import java.util.*;

public class stack {
    public static void main(String[]args){
        Stack<Integer> stack = new Stack<>(); //int형 스택 선언
        stack.push(1);     // stack에 값 1 추가
        stack.push(2);     // stack에 값 2 추가

        System.out.println(stack);

        System.out.println(stack.size());      // stack의 크기 출력 : 2
        System.out.println(stack.empty());     // stack이 비어있는제 check (비어있다면 true)
        System.out.println(stack.contains(1)); // stack에 1이 있는지 check (있다면 true)

        System.out.println(stack.peek());     // stack의 가장 상단의 값 출력

        stack.pop();     // stack에 값 제거 (젤 위에꺼 제거)

        System.out.println(stack);
    }
}

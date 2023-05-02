package etc.algorithm;
import java.util.*;

public class Linked {
    public static void main(String[]args){
        LinkedList<String> ll = new LinkedList<String>();

        /* 값을 추가한다 */
        ll.add("Hello");
        ll.add("World");
        ll.add("Hello");
        ll.add("World");
        ll.add("Hello");
        ll.add("World");

        System.out.println(ll);

        ll.removeFirst(); // 첫 번째 데이터 삭제
        ll.removeLast(); // 마지막 데이터 삭제

        System.out.println(ll);

        ll.remove(); // remove로 삭제하면 첫 번째 데이터를 삭제

        System.out.println(ll);

        ll.remove(2); // Index순번의 데이터를 삭제

        System.out.println(ll);

        ll.clear(); // List의 모든 데이터를 삭제

        System.out.println(ll);
    }
}

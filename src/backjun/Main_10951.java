package backjun;

import java.io.IOException;
import java.util.*;

//https://www.acmicpc.net/problem/10951
public class Main_10951 {
    private static int a,b;
    public void solution() throws IOException {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextInt()) {
            a = scanner.nextInt();
            b = scanner.nextInt();

            System.out.println(a+b);
        }
        scanner.close();
    }
    public static void main(String [] args) throws IOException {
        new Main_10951().solution();
    }
}

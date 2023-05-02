package backjun;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2588
public class Main_2588 {
    public static void Solution(){
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int answer = a * b;

        while(b > 0) {
            System.out.println( a * (b %10));
            b /= 10;
        }
        System.out.print(answer);
    }
    public static void main(String [] args){
        Solution();
    }
}

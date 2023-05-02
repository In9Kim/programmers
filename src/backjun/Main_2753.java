package backjun;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2753
public class Main_2753 {
    public static void solution(){
        //윤년이면 1, 아니면 0
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int answer = 0;
        if (((number%4) == 0 && (number%100) != 0) || (number%400) ==0 ){
            answer = 1;
        }
        System.out.print(answer);
    }
    public static void main(String []args){
        solution();
    }
}

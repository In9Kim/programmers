package backjun;

import java.util.Scanner;
import java.util.Arrays;

//https://www.acmicpc.net/problem/2577
public class Main_2577 {
    public static void solution(){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int total = a*b*c;

        int [] answer = new int[10];
        Arrays.fill(answer, 0);

        while(total > 0) {
            int target = total % 10;
            answer[target]++;
            total /= 10;
        }

        for(int temp:answer){
            System.out.println(temp);
        }

    }
    public static void main(String [] args){
        solution();
    }
}

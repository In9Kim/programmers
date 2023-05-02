package backjun;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2848
public class Main_2848 {
    public static void Solution(){
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int M = scanner.nextInt();

        if ((M-45) < 0) {
            if ((H-1) < 0){
                System.out.print(24+(H-1));
            }
            else{
                System.out.print(H-1);
            }

            System.out.print(" ");

            System.out.print(60+(M-45));
        }else{
            System.out.print(H);

            System.out.print(" ");

            System.out.print(M-45);
        }

    }
    public static void main(String[]args){
        Solution();
    }
}

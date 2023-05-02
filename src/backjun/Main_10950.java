package backjun;

import java.util.Scanner;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10950
public class Main_10950 {
    public static void Solution(){
        Scanner scanner = new Scanner(System.in);
        int max = scanner.nextInt();

        for (int i = 0; i < max; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a + b);
        }
    }
    public static void main(String [] args){
        Solution();
    }
}

package backjun;

import java.util.Scanner;

//https://www.acmicpc.net/problem/8958
public class Main_8958 {
    public static void Solution(){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        for(int i=0; i <number; i++){
            int answer = 0;
            int cnt = 0;

            String input = scanner.next();
            for(int j=0; j<input.length(); j++){
                if(input.charAt(j) == 'O') answer += ++cnt;
                else cnt = 0;
            }

            System.out.println(answer);
        }
    }
    public static void main(String[]args){
        Solution();
    }
}

package backjun;

import java.util.Arrays;
import java.util.Scanner;

//https://www.acmicpc.net/problem/10809
public class Main_10809 {
    public static void solution(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int [] answer = new int[26];

        Arrays.fill(answer,-1);

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(answer[ch - 'a'] == -1) {
                answer[ch - 'a'] = i;
            }
        }

        for(int var:answer){
            System.out.print(var+" ");
        }
    }
    public static void main(String[]args){
        solution();
    }
}

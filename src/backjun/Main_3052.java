package backjun;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//https://www.acmicpc.net/problem/3052
public class Main_3052 {
    public static void solution(){
        Scanner scanner = new Scanner(System.in);
        Set<Integer> set = new HashSet<Integer>();
        for(int i =0; i <10; i++){
            set.add(scanner.nextInt() % 42);
        }
        System.out.println(set.size());
    }
    public static void main(String[]args){
        solution();
    }
}

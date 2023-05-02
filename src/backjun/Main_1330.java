package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/1330
public class Main_1330 {
    private int a, b;
    private int [] arr;
    public void solution() throws IOException {
        String answer = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        a = Integer.parseInt(stringTokenizer.nextToken());
        b = Integer.parseInt(stringTokenizer.nextToken());
        
        if(a > b) answer = ">";
        else if(a < b) answer = "<";
        else if(a == b) answer = "==";

        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        new Main_1330().solution();
    }
}
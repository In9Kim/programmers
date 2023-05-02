package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/10818
public class Main_10818 {
    public static void Solution(){
        Scanner scanner = new Scanner(System.in);
        int N= scanner.nextInt();

        int [] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = scanner.nextInt();
        }

        scanner.close();
        Arrays.sort(arr);

        System.out.print(arr[0]+" "+arr[N-1]);
    }
    public static void Solution2() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");

        int max = -1000001;
        int min = 1000001;
        while(stringTokenizer.hasMoreTokens()){
            int val = Integer.parseInt(stringTokenizer.nextToken());

            if(val > max){
                max = val;
            }
            if(val < min){
                min = val;
            }
        }
        System.out.println(min+" "+max);
    }
    public static void main (String [] args) throws IOException {
        Solution2();
    }
}
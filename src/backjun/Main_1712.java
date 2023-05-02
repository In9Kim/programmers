package backjun;

import java.util.Scanner;

//https://www.acmicpc.net/problem/1712
public class Main_1712 {
    public static void solution(){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        // n * 상품가격(c) >  고정비용(a) + (n*가변비용(b))
        // (n*상품가격) = 불변비용 + (n * 가변비용)
        // (n*상품가격) - (n * 가변비용) = 불변비용
        // n * (상품가격 - 가변기용) = 불변비용
        // n = 불변비용 / (상품가격 - 가변기용)
        // n은 총용과 수익이 같아지는 지점, 이익이 나는 지점이 아님 그래서 + 1함
        if (b>=c) System.out.print(-1);

        else System.out.println((a/(c-b))+1);

    }
    public static void main(String[]args){
        /*
        1. 노트북 판매 대수에 상관없이 매년 임대료, 재산세, 보험료, 금여 등 a만원의 고정 비용 듬(고정)
        2. 노트북 안대 만드는데, 재료비와 인건비 등 b만원의 가변 비용(가변)
        ex) a=1000, b=70, 한대 생성하는데 1,070만원 열대는 1700만원
        3. 노트북 가격 = c만원
        4. 생산대수 늘려가다 보면 으느순간 총 수입(판매비용)이 총 비용(고정비용+가변비용)보다 많아지게 된다
        5.최초로 총 수입이 총 비용보다 많아져 이익이 발생하는 지점을 손익 분기점점
       * */

        // n * 노트북가격 > 고정비용 + (가변비용 * n)
        // n * 노트북가격 = 고정비용 + (가변비용 * n)
        // (n * 노트북가격) - (가변비용 * n) = 고정비용
        // n * (노트북가격 - 가변비용) = 고정비용
        // n  = 고정비용 / (노트북가격 - 가변비용)
        solution();
    }
}

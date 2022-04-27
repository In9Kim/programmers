package Solution;



import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

class LedgerInfo {
    private LocalDate tradeDate;
    private int rate;
    private int money;
    private int balance;

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "LedgerInfo{" +
                "tradeDate=" + tradeDate +
                ", rate=" + rate +
                ", money=" + money +
                ", balance=" + balance +
                '}';
    }
}
public class Solution_20220306 {
    /*
     * 입금과 출금 가능한 예금 상품 이용
     * 입금 날짜별로 서로 다른 금리 적용
     * 출금시 가장 최근에 입금된 급액부터 출금.
     * 출금된 금액에 대해서는 입금 당시 적용된 금리와 예치 기간으로 이자가 계산됨.
     * 12월 31일에는 잔액이 자동으로 모두 츨금.
     * 이자 계산 시 소수점 이하는 버림.
     *
     * 윤년이 아니라고 했으므로 2021년으로 가정?
     * */

    int solution(String[] ledgers){
        int answer = 0;

        boolean[] indexOfWithdrawal = new boolean[ledgers.length];
        ArrayList<LedgerInfo> infos = new ArrayList<>();

        for(String ledger : ledgers) {
            LedgerInfo info = new LedgerInfo();

            String[] tmpLedger = ledger.split(" ");
            String[] tmpDate = tmpLedger[0].split("/");
            LocalDate tradeDate = LocalDate.of(2021, Integer.parseInt(tmpDate[0]), Integer.parseInt(tmpDate[1]));
            info.setTradeDate(tradeDate);

            int r = Integer.parseInt(tmpLedger[1]);
            info.setRate(r);

            int money = Integer.parseInt(tmpLedger[2]);
            info.setMoney(money);
            info.setBalance(money);

            if(money < 0) {
                info.setBalance(0);
                indexOfWithdrawal[infos.size()] = true;
            }

            infos.add(info);
            System.out.println(info.toString());
        }

        for(int i=0; i < infos.size(); i++) {
            if(!indexOfWithdrawal[i]) continue;
            System.out.println("withdrawal=" + infos.get(i));
            for(int j=i-1; j>=0; j--) {

                if(infos.get(j).getBalance() == 0) continue;
                // 출금
                int balance = infos.get(j).getBalance() + infos.get(i).getMoney();
                System.out.println("withdrawal_step_"+ j + ":balance=" + balance);
                long days = ChronoUnit.DAYS.between(infos.get(j).getTradeDate(), infos.get(i).getTradeDate());
                System.out.println("withdrawal_step_"+ j + ":days=" + days);
                double rate = (infos.get(j).getRate()*1.0/100);
                System.out.println("withdrawal_step_"+ j + ":rate=" + rate);

                System.out.println("withdrawal_step_"+ j + "=" + infos.get(j));
                if(balance < 0) { // 더 출금해야 하는 경우
                    int interest = (int) ((days*1.0/365) * infos.get(j).getMoney() * rate);
                    System.out.println("interest:" + interest);
                    answer += interest;
                    System.out.println("!!!1:" + infos.get(j).getMoney() + "|" + rate + "|" + days);
                    infos.get(j).setBalance(0);
                    infos.get(i).setMoney(balance);
                } else if(balance == 0){
                    int interest = (int) ((days*1.0/365) * infos.get(j).getMoney() * rate);
                    answer += interest;
                    System.out.println("interest:" + interest);
                    System.out.println("!!!2:" + infos.get(j).getMoney() + "|" + rate + "|" + days);
                    infos.get(i).setMoney(0);
                    break;
                } else { // 출금할 돈이 더 없는 경우
                    int interest = (int) ((days*1.0/365) * (infos.get(i).getMoney() * -1) * rate);
                    answer += interest;
                    System.out.println("interest:" + interest);
                    System.out.println("!!!3:" + infos.get(j).getMoney() + "|" + rate + "|" + days);
                    infos.get(j).setBalance(balance);
                    infos.get(i).setMoney(0);
                    break;
                }

            }
        }

        System.out.println("answer1=" + answer);

        for(int i=0; i<infos.size(); i++) {
            if(infos.get(i).getBalance() > 0) {
                System.out.println("lastCal=" + infos.get(i));
                long days = ChronoUnit.DAYS.between(infos.get(i).getTradeDate(), LocalDate.of(2021, 12, 31));
                System.out.println("!!!" + infos.get(i).getMoney() + "|" + infos.get(i).getRate()*1.0/100 + "|" + days);
                answer += (days*1.0/365) * infos.get(i).getBalance() * (infos.get(i).getRate()*1.0/100);
            }
        }

        return answer;
    }

}
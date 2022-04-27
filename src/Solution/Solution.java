package Solution;

import java.time.LocalDate;
import java.util.*;

class withdraw {
    private String tradeDate;
    private int rate;
    private int money;
    private int balance;
    private boolean zero;

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
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

    public Boolean getZero() {
        return zero;
    }

    public void setZero(Boolean zero) {
        this.zero = zero;
    }

    @Override
    public String toString() {
        return "LedgerInfo{" +
                "tradeDate=" + tradeDate +
                ", rate=" + rate +
                ", money=" + money +
                ", balance=" + balance +
                ", Zero=" + zero +
                '}';
    }
}
public class Solution {
    public int solution(String[] ledgers) {
        int answer = 0;
        int money_tmp = 0;
        int balance_tmp = 0;

        ArrayList<withdraw> infos = new ArrayList<>();

        for(String ledger : ledgers) {
            withdraw info = new withdraw();
            String[] ArraysStr = ledger.split(" ");

            for (int j = 0; j < ArraysStr.length; j++) {
                if (j == 0) {
                    info.setTradeDate(ArraysStr[j]);
                } else if (j == 1) {
                    info.setRate(Integer.parseInt(ArraysStr[j]));
                } else if (j == 2) {
                    info.setMoney(Integer.parseInt(ArraysStr[j]));
                }
            }
            infos.add(info);
            System.out.println(info.toString());
        }

        for(int j=0; j<infos.size(); j++){
            if(infos.get(j).getMoney() < 0){
                money_tmp = infos.get(j).getMoney();
                System.out.println("money1:"+money_tmp);
                for(int k=j-1; k>=0; k--){
                    balance_tmp = 0;
                    System.out.print("k:"+k);
                    System.out.print(" j:"+j);
                    System.out.print(" mmdd:"+infos.get(j).getTradeDate());
                    System.out.print(" money:"+infos.get(k).getMoney());
                    System.out.print(" rate:"+(double)infos.get(k).getRate()/100);
                    System.out.println(" bf money_tmp:"+money_tmp);

                    if(infos.get(k).getZero() == true) continue;

                    money_tmp += infos.get(k).getMoney();
                    System.out.println(" af money_tmp:"+money_tmp);

                    // (3555*0.06)*(21/365)
                    if(infos.get(k).getZero() == false) {
                        if (money_tmp > 0) {
                            balance_tmp += (infos.get(k).getMoney() - money_tmp) * ((double) infos.get(k).getRate() / 100)
                                    * (date(infos.get(j).getTradeDate()) - date(infos.get(k).getTradeDate())) / 365;
                            if(infos.get(k).getBalance() > 0){
                                System.out.println("3333333333  get balance:" + infos.get(j).getBalance());
                                infos.get(k).setBalance(infos.get(k).getBalance()+balance_tmp);
                            }
                            else{
                                infos.get(k).setBalance(balance_tmp);
                            }
                            infos.get(k).setMoney(money_tmp);
                            System.out.println(" if in balance_tmp:" + infos.get(k).getBalance());
                            System.out.println(" if in money_tmp:" + money_tmp);

                            //answer += balance_tmp;

                            continue;
                        } else {
                            balance_tmp += (infos.get(k).getMoney()) * ((double) infos.get(k).getRate() / 100)
                                    * (date(infos.get(j).getTradeDate()) - date(infos.get(k).getTradeDate())) / 365;
                            System.out.print(" 1 date :" + date(infos.get(j).getTradeDate()));
                            System.out.print(" 2 date :" + date(infos.get(k).getTradeDate()));

                            infos.get(k).setBalance(balance_tmp);
                            infos.get(k).setZero(true);
                            System.out.println(" else in balance_tmp:" + infos.get(k).getBalance());

                            //answer += balance_tmp;
                        }
                    }
                    System.out.println();
                }
                infos.get(j).setZero(true);
            }
        }
        for(int j=infos.size()-1; j>=0; j--) {
            balance_tmp = 0;
            if(infos.get(j).getZero() == false){
                System.out.print("22 mmdd:"+infos.get(j).getTradeDate());
                System.out.print(" 22 money:"+infos.get(j).getMoney());
                System.out.print(" 22 rate:"+(double)infos.get(j).getRate()/100);
                System.out.println();
                balance_tmp += (infos.get(j).getMoney()) * ((double) infos.get(j).getRate() / 100)
                        * (date("12/31") - date(infos.get(j).getTradeDate())) / 365;

                System.out.print("22 1 date :" + date(infos.get(j).getTradeDate()));
                System.out.print("22 2 date :" + date(infos.get(j).getTradeDate()));

                if(infos.get(j).getBalance() > 0){
                    System.out.println("3333333333  get balance:" + infos.get(j).getBalance());
                    infos.get(j).setBalance(infos.get(j).getBalance()+balance_tmp);
                }
                else{
                    infos.get(j).setBalance(balance_tmp);
                }

                System.out.println("22 else in balance_tmp:" + balance_tmp);
            }
        }

        for(int j=0; j<infos.size(); j++){
            answer += infos.get(j).getBalance();
        }

        System.out.println(infos.toString());

        return answer;
    }
    public int date(String str) {

        int [] mdays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int month = 0;
        int mday = 0;
        int total = 0;

        int i = 0;

        String[] ArraysStr = str.split("/");
        for (int j = 0; j < ArraysStr.length; j++) {
            if(j == 0){
                month = Integer.parseInt(ArraysStr[j]);
            }
            else{
                mday = Integer.parseInt(ArraysStr[j]);
            }
        }

        for (i = 0; i < month - 1; i++) {
            total += mdays[i];
        }
        total += mday;

        return month == 1 ? mday : total;
    }
}




package chap01;

import java.util.*;

public class RefactoringSample {
    public static String statement(Invoices invoice, Map<String, Play> plays) throws Exception {
        int totalAmount = 0;
        int volumeCredits = 0;
        String result = "청구 내역 고객명 : " + invoice.getCustomerName() + '\n';

        for (var perf : invoice.getPerformances()) {
            Play play = plays.get(perf.getPlayId());
            var thisAmount = 0;

            switch (play.getType()) {
                case "tragedy":
                    thisAmount = 40000;
                    if (perf.getAudience() > 30) {
                        thisAmount += 1000 * (perf.getAudience() - 30);
                    }
                    break;
                case "comedy":
                    thisAmount = 30000;
                    if (perf.getAudience() > 20) {
                        thisAmount += 10000 + 500 * (perf.getAudience() - 20);
                    }
                    thisAmount += 300 * perf.getAudience();
                    break;
                default:
                    throw new Exception("알 수 없는 장르");
            }

            volumeCredits += Math.max(perf.getAudience() - 30, 0);
            if ("comedy".equals(play.getType())) {
                volumeCredits += Math.floor(perf.getAudience() / 5);
            }

            result += play.getName() + ": " + thisAmount + "원, " + perf.getAudience() + "석\n";
            totalAmount += thisAmount;
        }

        result += "총액: " + totalAmount + "원\n";
        result += "적립 포인트: " + volumeCredits + "점\n";
        return result;
    }

    public static void main(String[] args) throws Exception {
        List<Performance> performances = new ArrayList<>();
        performances.add(new Performance("hamlet", 55));
        performances.add(new Performance("as-like", 35));
        performances.add(new Performance("othello", 40));

        Invoices invoices = new Invoices("BigCo", performances);
        Map<String, Play> plays = new HashMap<>();
        plays.put("hamlet", new Play("Hamlet", "tragedy"));
        plays.put("as-like", new Play("As You Like It", "comedy"));
        plays.put("othello", new Play("Othello", "tragedy"));

        System.out.println(statement(invoices, plays));
    }
}

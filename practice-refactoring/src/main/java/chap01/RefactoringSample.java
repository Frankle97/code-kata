package chap01;

import java.util.*;

public class RefactoringSample {
    private static List<Performance> performances;
    private static Invoices invoices;
    private static Map<String, Play> plays;

    public static String statement(Invoices invoice, Map<String, Play> plays) throws Exception {
        int totalAmount = 0;
        int volumeCredits = 0;
        String result = "청구 내역 고객명 : " + invoice.getCustomerName() + '\n';

        for (var perf : invoice.getPerformances()) {
            int thisAmount = amountFor(perf, playFor( perf));

            volumeCredits += Math.max(perf.getAudience() - 30, 0);
            if ("comedy".equals(playFor( perf).getType())) {
                volumeCredits += Math.floor(perf.getAudience() / 5);
            }

            result += playFor( perf).getName() + ": " + thisAmount + "원, " + perf.getAudience() + "석\n";
            totalAmount += thisAmount;
        }

        result += "총액: " + totalAmount + "원\n";
        result += "적립 포인트: " + volumeCredits + "점\n";
        return result;
    }

    private static Play playFor(Performance performance) {
        return plays.get(performance.getPlayId());
    }

    private static int amountFor(Performance performance, Play play) throws Exception {
        var result = 0;

        switch (play.getType()) {
            case "tragedy":
                result = 40000;
                if (performance.getAudience() > 30) {
                    result += 1000 * (performance.getAudience() - 30);
                }
                break;
            case "comedy":
                result = 30000;
                if (performance.getAudience() > 20) {
                    result += 10000 + 500 * (performance.getAudience() - 20);
                }
                result += 300 * performance.getAudience();
                break;
            default:
                throw new Exception("알 수 없는 장르");
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        performances = new ArrayList<>();
        performances.add(new Performance("hamlet", 55));
        performances.add(new Performance("as-like", 35));
        performances.add(new Performance("othello", 40));

        invoices = new Invoices("BigCo", performances);
        plays = new HashMap<>();
        plays.put("hamlet", new Play("Hamlet", "tragedy"));
        plays.put("as-like", new Play("As You Like It", "comedy"));
        plays.put("othello", new Play("Othello", "tragedy"));

        System.out.println(statement(invoices, plays));
    }
}

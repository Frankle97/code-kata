package chap01;

import java.util.*;

public class RefactoringSample {
    private static List<Performance> performances;
    private static Invoices invoices;
    private static Map<String, Play> plays;

    public static String statement(Invoices invoice, Map<String, Play> plays) throws Exception {
        int totalAmount = 0;
        String result = "청구 내역 고객명 : " + invoice.getCustomerName() + '\n';

        for (Performance performance : invoice.getPerformances()) {

            result += playFor(performance).getName() + ": " + amountFor(performance) + "원, " + performance.getAudience() + "석\n";
            totalAmount += amountFor(performance);
        }

        result += "총액: " + totalAmount + "원\n";
        result += "적립 포인트: " + totalVolumeCredits() + "점\n";
        return result;
    }

    private static int totalVolumeCredits() {
        int volumeCredits = 0;
        for (Performance performance : performances) {
            volumeCredits = volumeCreditsFor(performance);
        }
        return volumeCredits;
    }

    private static int volumeCreditsFor(Performance performance) {
        int result = 0;
        result += Math.max(performance.getAudience() - 30, 0);
        if ("comedy".equals(playFor(performance).getType())) {
            result += Math.floor(performance.getAudience() / 5);
        }
        return result;
    }

    private static Play playFor(Performance performance) {
        return plays.get(performance.getPlayId());
    }

    private static int amountFor(Performance performance) throws Exception {
        var result = 0;

        switch (playFor(performance).getType()) {
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

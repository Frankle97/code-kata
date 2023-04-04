package chap01;

import java.util.*;

public class RefactoringSample {
    private static List<Performance> performances;
    private static Invoices invoices;
    private static Map<String, Play> plays;

    private static StatementData createStatementData(Invoices invoice) throws Exception {
        StatementData statementData = new StatementData();
        statementData.setCustomerName(invoice.getCustomerName());
        statementData.setPerformances(invoice.getPerformances());
        statementData.setTotalAmount(totalAmount());
        statementData.setTotalVolumeCredits(totalVolumeCredits());
        return statementData;
    }

    public static String statement(Invoices invoice, Map<String, Play> plays) throws Exception {
        return renderPlainText(createStatementData(invoice));
    }

    private static String renderPlainText(StatementData data) throws Exception {
        String result = "청구 내역 고객명 : " + data.getCustomerName() + '\n';

        for (Performance performance : data.getPerformances()) {
            result += playFor(performance).getName() + ": " + amountFor(performance) + "원, " + performance.getAudience() + "석\n";
        }

        result += "총액: " + data.getTotalAmount() + "원\n";
        result += "적립 포인트: " + data.getTotalVolumeCredits() + "점\n";
        return result;
    }

    public static String htmlStatement(Invoices invoices, Map<String, Play> plays) throws Exception {
        return renderHtml(createStatementData(invoices));
    }

    private static String renderHtml(StatementData data) throws Exception {
        String result = "<h1>청구 내역 (고객명: " + data.getCustomerName() + " </h1>\n";
        result += "<table>\n";
        result += "<tr><th>연극</th><th>좌석 수</th><th>금액</th></tr>\n";
        for (Performance performance : data.getPerformances()) {
            result += "<tr><td>" + performance.getPlayId() + "</td><td>(" + performance.getAudience() + "석)</td>";
            result += "<td>" + amountFor(performance) + "</td></tr>\n";
        }
        result += "</table>\n";
        result += "<p>총액: <em>" + data.getTotalAmount() + "</em></p>\n";
        result += "<p>적립 포인트: " + data.getTotalVolumeCredits() + "</em>점</p>\n";
        return result;
    }


    private static int totalAmount() throws Exception {
        int result = 0;
        for (Performance performance : performances) {
            result += amountFor(performance);
        }
        return result;
    }

    private static int totalVolumeCredits() {
        int result = 0;
        for (Performance performance : performances) {
            result = volumeCreditsFor(performance);
        }
        return result;
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
        System.out.println(htmlStatement(invoices, plays));
    }
}

package chapter_03;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double summarizeTransactions(BankTransactionSummarizer bankTransactionSummarizer) {
        double result = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }

    public double calculateTotalInMonth(Month month) {
        return summarizeTransactions((accumulator, bankTransaction) ->
            bankTransaction.getDate().getMonth() == month ? accumulator + bankTransaction.getAmount() : accumulator);
    }

    public List<BankTransaction> findTransactions(BankTransactionFilter bankTransactionFilter) {
        List<BankTransaction> result = new ArrayList<>();
        for (BankTransaction bankTransaction : bankTransactions) {
            if (bankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }
        return bankTransactions;
    }

    public List<BankTransaction> findTransactionsGreaterThanEqual(int amount) {
        return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
    }
}

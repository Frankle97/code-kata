package chapter_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inspector {

    private final List<ConditionalAction> conditionalActionList;

    public Inspector(ConditionalAction... conditionalActionList) {
        this.conditionalActionList = Arrays.asList(conditionalActionList);
    }

    public List<Report> inspect(Facts facts) {
        List<Report> reports = new ArrayList<>();
        for (ConditionalAction conditionalAction : conditionalActionList) {
            boolean conditionResult = conditionalAction.evaluate(facts);
            reports.add(new Report(conditionalAction, facts, conditionResult));
        }
        return reports;
    }
}

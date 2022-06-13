package chapter_05;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InspectorTest {
    @Test
    void inspectOneConditionEvaluatesTrue() {
        Facts facts = new Facts();
        facts.addFact("jobTitle", "CEO");
        ConditionalAction conditionalAction = new JobTitleCondition();
        Inspector inspector = new Inspector(conditionalAction);

        List<Report> reports = inspector.inspect(facts);

        assertEquals(1, reports.size());
        assertTrue(reports.get(0).isPositive());
    }

    private static class JobTitleCondition implements ConditionalAction {

        @Override
        public boolean evaluate(Facts facts) {
            return "CEO".equals(facts.getFact("jobTitle"));
        }

        @Override
        public void execute(Facts facts) {
            throw new UnsupportedOperationException();
        }
    }

}
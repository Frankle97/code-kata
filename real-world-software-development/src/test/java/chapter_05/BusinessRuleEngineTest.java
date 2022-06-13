package chapter_05;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * TDD Cycle
 *
 * Fail -> Implement -> Success -> Refactor
 * 가장 작은 단위부터 하나씩 구현
 */
class BusinessRuleEngineTest {

    @Test
    void shouldPerformAnActionWithFacts() {
        Action mockAction = mock(Action.class);
        Facts mockFacts = mock(Facts.class);
        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

        businessRuleEngine.addAction(mockAction);
        businessRuleEngine.run();

        verify(mockAction).execute(mockFacts);
    }

    @Test
    void isCEO() {
        Action mockAction = mock(Action.class);
        Facts mockFacts = mock(Facts.class);
        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

        businessRuleEngine.addAction(facts -> {
            double forecastedAmount = 0.0;
            Stage dealStage = Stage.valueOf(facts.getFact("stage"));
            double amount = Double.parseDouble(facts.getFact("amount"));
        });

    }
}
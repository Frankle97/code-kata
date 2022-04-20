package mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.mock;

public class GameGenMockTest {
    @Test
    void mockTest() {
        // create mock object.
        GameNumGen genMock = mock(GameNumGen.class);

        /**
         * stub 설정
         * stub: 테스트에 맞게 단순히 원하는 동작을 수행하는 대역을 설정
         */
        given(genMock.generate(GameLevel.EASY)).willReturn("123");

        String num = genMock.generate(GameLevel.EASY);
        assertEquals("123", num);
    }

    @Test
    void mockThrowTest() {
        GameNumGen genMock = mock(GameNumGen.class);

        given(genMock.generate(null)).willThrow(IllegalArgumentException.class);

        assertThrows(
            IllegalArgumentException.class,
            () -> genMock.generate(null));
    }

    @Test
    void voidMethodWillThrowTest() {
        List<String> mockList = mock(List.class);
    }

    @Test
    void anyMatchTest() {
        GameNumGen genMock = mock(GameNumGen.class);
        given(genMock.generate(any())).willReturn("456");

        String num = genMock.generate(GameLevel.EASY);
        assertEquals("456", num);
    }
}

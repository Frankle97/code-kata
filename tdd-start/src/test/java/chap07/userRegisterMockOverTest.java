package chap07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class userRegisterMockOverTest {

    private UserRegister userRegister;
    private UserRepository userRepository = new MemoryUserRepository();
    private EmailNotifier emailNotifier = Mockito.mock(EmailNotifier.class);
    private WeakPasswordChecker weakPasswordChecker = Mockito.mock(WeakPasswordChecker.class);

    @BeforeEach
    void beforeAll() {
        userRegister = new UserRegister(weakPasswordChecker, userRepository, emailNotifier);
    }

    @Test
    void register() {
        userRegister.register("id", "pw", "pairpapa@gmail.com");

        userRepository.findById("id").toString();
    }
}

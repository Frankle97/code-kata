package chap07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegisterTest {
    private UserRegister userRegister;
    private final StubWeakPasswordChecker stubWeakPasswordChecker = new StubWeakPasswordChecker();
    private final MemoryUserRepository fakeRepository = new MemoryUserRepository();
    private final SpyEmailNotifier spyEmailNotifier = new SpyEmailNotifier();

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(stubWeakPasswordChecker, fakeRepository, spyEmailNotifier);
    }

    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword() {
        stubWeakPasswordChecker.setWeak(true);
        assertThrows(WeakPasswordException.class, () -> userRegister.register("id", "pw", "email"));
    }

    @DisplayName("중복 가입 검사")
    @Test
    void dupIdExists() {
        fakeRepository.save(new User("id", "pw1", "email@gmail.com"));
        assertThrows(DupIdException.class, () -> userRegister.register("id", "pw1", "email.gmail.com"));
    }

    @DisplayName("같은 ID가 없다면 가입 성공")
    @Test
    void noDupId_register_success() {
        userRegister.register("id", "pw", "email");

        User savedUser = fakeRepository.findById("id");
        assertEquals("id", savedUser.getId());
        assertEquals("email", savedUser.getEmail());
    }

    @DisplayName("가입하면 메일 발송")
    @Test
    void whenRegisterThenSendMail() {
        userRegister.register("id", "pw", "email@gmail.com");

        assertTrue(spyEmailNotifier.isCalled());
        assertEquals("email@gmail.com", spyEmailNotifier.getEmail());
    }
}

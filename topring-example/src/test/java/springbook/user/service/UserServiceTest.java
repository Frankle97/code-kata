package springbook.user.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import springbook.user.dao.UserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;

    List<User> users;

    @BeforeEach
    void setUp() {
        this.users = Arrays.asList(
                new User("frankle", "정재엽", "p1", Level.BASIC, 49, 0),
                new User("jamie", "제이미", "p2", Level.BASIC, 50, 0),
                new User("olive", "올리브", "p3", Level.SILVER, 60, 29),
                new User("pizza", "오브리", "p4", Level.SILVER, 60, 30),
                new User("mason", "박줌미", "p5", Level.GOLD, 100, 100)
        );
    }

    @Test
    public void upgradeLevels() {
        userDao.deleteAll();

        for (User user : users) {
            userDao.add(user);
            userService.upgradeLevels(user);
        }

        checkLevel(users.get(0), Level.BASIC);
        checkLevel(users.get(1), Level.SILVER);
        checkLevel(users.get(2), Level.SILVER);
        checkLevel(users.get(3), Level.GOLD);
        checkLevel(users.get(4), Level.GOLD);
    }

    @Test
    public void add() {
        userDao.deleteAll();

        User userWithLevel = users.get(4);
        User userWithoutLevel = users.get(0);
        userWithoutLevel.setLevel(null);


        userService.add(userWithLevel);
        userService.add(userWithoutLevel);

        User userWithLevelRead = userDao.get(userWithLevel.getId());
        User userWithoutLevelRead = userDao.get(userWithoutLevel.getId());

        Assertions.assertEquals(userWithLevel.getLevel(), userWithLevelRead.getLevel());
        Assertions.assertEquals(userWithoutLevel.getLevel(), userWithoutLevelRead.getLevel());
    }

    private void checkLevel(User user, Level expectedLevel) {
        User userUpdate = userDao.get(user.getId());
        Assertions.assertEquals(userUpdate.getLevel(), expectedLevel);
    }
}

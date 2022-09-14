package user.dao;


import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

public class UserDaoTest {

    @Test
    public void addAndGet() throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext-test.xml");

        UserDao dao = context.getBean("userDao", UserDao.class);

        User user1 = new User("jyeob", "woduq", "1234");
        User user2 = new User("suyeon", "tndus", "12345");

        dao.deleteAll();
        assertEquals(dao.getCount(), 0);

        dao.add(user1);
        dao.add(user2);
        assertEquals(dao.getCount(), 2);

        User userget1 = dao.get(user1.getId());
        assertEquals(user1.getName(), userget1.getName());
        assertEquals(user1.getPassword(), userget1.getPassword());

        User userget2 = dao.get(user2.getId());
        assertEquals(user2.getName(), userget2.getName());
        assertEquals(user2.getPassword(), userget2.getPassword());
    }

    @Test
    public void count() throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext-test.xml");

        UserDao userDao = context.getBean("userDao", UserDao.class);
        User user1 = new User("user1", "에이", "spring1");
        User user2 = new User("user2", "비", "spring2");
        User user3 = new User("user3", "쒸익", "spring3");

        userDao.deleteAll();
        assertEquals(userDao.getCount(), 0);

        userDao.add(user1);
        assertEquals(userDao.getCount(), 1);

        userDao.add(user2);
        assertEquals(userDao.getCount(), 2);

        userDao.add(user3);
        assertEquals(userDao.getCount(), 3);
    }

    @Test
    public void getUserFailure() throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext-test.xml");

        UserDao userDao = context.getBean("userDao", UserDao.class);
        userDao.deleteAll();
        assertEquals(userDao.getCount(), 0);

        assertThrows(SQLException.class, () -> userDao.get("unknown_id"));
    }
}

package user.dao;


import java.sql.SQLException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

public class UserDaoTest {

    @Test
    public void gd() {
        System.out.println("true = " + true);
    }

    @Test
    public void addAndGet() throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext-test.xml");

        UserDao dao = context.getBean("userDao", UserDao.class);
        User user = new User();
        user.setId("jyeob");
        user.setName("woduq");
        user.setPassword("1234");

        dao.add(user);

        User user2 = dao.get(user.getId());

        Assertions.assertEquals(user.getName(), user2.getName());
        Assertions.assertEquals(user.getPassword(), user2.getPassword());
    }
}

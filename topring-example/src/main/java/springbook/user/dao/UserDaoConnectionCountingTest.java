package springbook.user.dao;

import java.sql.SQLException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.user.domain.User;

public class UserDaoConnectionCountingTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            CountingDaoFactory.class);
        UserDao userDao = context.getBean("userDao", UserDao.class);
        User user = new User();
        user.setId("frankle2");
        user.setName("정재엽");
        user.setPassword("1234");

        userDao.add(user);

        System.out.println("등록 성공, user.getId() = " + user.getId());

        User user1 = userDao.get(user.getId());
        System.out.println("user1 Name = " + user1.getName());
        System.out.println("user1 Pass = " + user1.getPassword());

        CountingConnectionMaker ccm = context.getBean("connectionMaker",
            CountingConnectionMaker.class);
        System.out.println("ccm.getCounter() = " + ccm.getCounter());
    }

}

package springbook.user.dao;

import java.sql.SQLException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.user.dao.DConnectionMaker;
import springbook.user.dao.DaoFactory;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

public class UserDaoTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            DaoFactory.class);
        UserDao userDao = context.getBean("userDao", UserDao.class);
        User user1 = new User();
        user1.setId("frankle");
        user1.setName("정재엽");
        user1.setPassword("1234");

        userDao.add(user1);

        System.out.println("등록 성공, user1.getId() = " + user1.getId());

        User user2 = userDao.get(user1.getId());

        if (!user1.getName().equals(user2.getName())) {
            System.out.println("테스트 실패 (name)");
        } else if (!user1.getPassword().equals(user2.getPassword())) {
            System.out.println("테스트 실패 (password)");
        } else {
            System.out.println("테스트 성공");
        }
    }

}

package springbook;

import java.sql.SQLException;
import springbook.user.dao.DConnectionMaker;
import springbook.user.dao.DaoFactory;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

public class UserDaoTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new DaoFactory().userDao();
        User user = new User();
        user.setId("frankle");
        user.setName("정재엽");
        user.setPassword("1234");

        userDao.add(user);

        System.out.println("등록 성공, user.getId() = " + user.getId());

        User user1 = userDao.get(user.getId());
        System.out.println("user1 Name = " + user1.getName());
        System.out.println("user1 Pass = " + user1.getPassword());
    }

}

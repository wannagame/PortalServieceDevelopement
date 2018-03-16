import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;


public class UserDaoTest {

    private UserDao userDao;
    @Before
    public void setUp(){
        userDao = new UserDao();
    }
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        int id= 1;
        User user = userDao.get(id);
        assertThat(user.getId(), is(1));
        assertThat(user.getName(), is("허윤호"));
        assertThat(user.getPassword(), is("1234"));
    }
    @Test
    public  void add() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setName("라랄룰랄ㄹ라");
        user.setPassword("333");
        Integer id = userDao.insert(user);

        User insertedUser = userDao.get(id) ;
        assertThat(insertedUser.getId(), is(id));
        assertThat(insertedUser.getName(), is(user.getName()));
        assertThat(insertedUser.getPassword(), is(user.getPassword()));
    }
}
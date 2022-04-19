package alexia.charactermanager.database.dao;

import alexia.charactermanager.database.entity.User;
import alexia.charactermanager.database.entity.UserRole;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTests {

    @Autowired
    UserDAO userDao;

    @Autowired
    UserRoleDAO userRoleDao;

    @Test
    @Order(1)
    public void getUserTest() {

        User expected = new User();
        expected.setId(1);

        User actual = userDao.findById(1);

        Assertions.assertEquals(expected.getId(), actual.getId());

        //Force fail
        //Assertions.assertEquals(expected.getId(), 3);
    }

    @Test
    @Order(2)
    public void createTest() {
        User expected = new User();
        expected.setUsername("test");
        expected.setPassword("test");

        userDao.save(expected);

        Assertions.assertTrue(expected.getId() > 0);
    }

    @Test
    public void updateTest() {
        //User expected = new User();
        //expected.setFirstName("updated");

        User actual = userDao.findById(1);
        actual.setUsername("updated");

        userDao.save(actual);

        Assertions.assertEquals("updated", actual.getUsername());
    }

    @Test
    public void deleteTest() {

        User actual = userDao.findById(1);
        List<UserRole> roles = userRoleDao.findByUserId(1);

        //Need to delete all user_roles before deleting user, because of foreign key
        //Think of this like manually cascading?
        for (UserRole role : roles) {
            userRoleDao.delete(role);
        }

        userDao.delete(actual);

        Assertions.assertNull(userDao.findById(1));
    }
}

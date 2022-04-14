package alexia.charactermanager.service;

import alexia.charactermanager.database.dao.UserDAO;
import alexia.charactermanager.database.entity.User;
import alexia.charactermanager.formbean.RegisterFormBean;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Component
@NoArgsConstructor
@Service
public class UserService {

    @Autowired
    private UserDAO userDao;

    //@Autowired
    //private PasswordEncoder passwordEncoder;

    public Boolean createUser (RegisterFormBean form) {
        //Create new user
        //Set information from form
        //Save new user

        User user = new User();

        user.setUsername(form.getUsername());
        String password = form.getPassword();
        //String password = passwordEncoder.encode(form.getPassword());
        user.setPassword(password);

        userDao.save(user);

        return true;
    }

}

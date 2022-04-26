package alexia.charactermanager.validation;

import alexia.charactermanager.database.entity.User;
import alexia.charactermanager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserUniqueImpl implements ConstraintValidator <UserUnique, String> {

    public static final Logger LOG = LoggerFactory.getLogger(UserUnique.class);

    @Autowired
    private UserService userServ;

    @Override
    public void initialize(UserUnique constraintAnnotation) {}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        User user = userServ.findByUsername(value);

        return (user == null);
    }

}

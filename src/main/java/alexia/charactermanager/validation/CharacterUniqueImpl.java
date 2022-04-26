package alexia.charactermanager.validation;

import alexia.charactermanager.database.entity.Character;
import alexia.charactermanager.database.entity.User;
import alexia.charactermanager.service.CharacterService;
import alexia.charactermanager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CharacterUniqueImpl implements ConstraintValidator <CharacterUnique, String> {

    public static final Logger LOG = LoggerFactory.getLogger(CharacterUnique.class);

    @Autowired
    private CharacterService charServ;

    @Override
    public void initialize(CharacterUnique constraintAnnotation) {}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        Character character = charServ.findByName(value);

        return (character == null);
    }

}

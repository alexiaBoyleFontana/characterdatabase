package alexia.charactermanager.validation;

import alexia.charactermanager.database.entity.Character;
import alexia.charactermanager.database.entity.World;
import alexia.charactermanager.service.CharacterService;
import alexia.charactermanager.service.WorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WorldUniqueImpl implements ConstraintValidator <WorldUnique, String> {

    public static final Logger LOG = LoggerFactory.getLogger(WorldUnique.class);

    @Autowired
    private WorldService worldServ;

    @Override
    public void initialize(WorldUnique constraintAnnotation) {}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        World world = worldServ.findByName(value);

        return (world == null);
    }

}

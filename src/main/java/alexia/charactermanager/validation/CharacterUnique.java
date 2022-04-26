package alexia.charactermanager.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CharacterUniqueImpl.class)
@Target( {ElementType.FIELD} )
@Retention(RetentionPolicy.RUNTIME)
public @interface CharacterUnique {

    String message() default "Character already exists.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

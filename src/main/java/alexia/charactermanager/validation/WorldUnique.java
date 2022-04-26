package alexia.charactermanager.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = WorldUniqueImpl.class)
@Target( {ElementType.FIELD} )
@Retention(RetentionPolicy.RUNTIME)
public @interface WorldUnique {

    String message() default "World already exists.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

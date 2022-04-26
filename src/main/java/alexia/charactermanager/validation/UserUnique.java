package alexia.charactermanager.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserUniqueImpl.class)
@Target( {ElementType.FIELD} )
@Retention(RetentionPolicy.RUNTIME)
public @interface UserUnique {

    String message() default "Username already exists.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

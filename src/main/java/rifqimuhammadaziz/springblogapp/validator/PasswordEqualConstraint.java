package rifqimuhammadaziz.springblogapp.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME) // validate while application running
@Documented
@Constraint(validatedBy = PasswordEqualConstraintValidator.class)
public @interface PasswordEqualConstraint {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

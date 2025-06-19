package pororo.logicinference.common.annotators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import pororo.logicinference.common.validators.ListIntegerValidator;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ListIntegerValidator.class)
public @interface ValidListInteger {
  String message() default "Invalid list number";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}

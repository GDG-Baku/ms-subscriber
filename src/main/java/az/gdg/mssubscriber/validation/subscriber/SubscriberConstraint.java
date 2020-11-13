package az.gdg.mssubscriber.validation.subscriber;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.FIELD, ElementType.TYPE})
@Constraint(validatedBy = SubscriberValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface SubscriberConstraint {
    String message() default "Subscriber request validation error";

    Class[] groups() default {};

    Class[] payload() default {};

    String[] sortingFields() default {};
}
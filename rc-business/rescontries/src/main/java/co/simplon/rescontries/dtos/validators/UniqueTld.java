package co.simplon.rescontries.dtos.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = UniqueTldValidator.class)
public @interface UniqueTld {

    String message() default "Coucou code tld exist deja";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

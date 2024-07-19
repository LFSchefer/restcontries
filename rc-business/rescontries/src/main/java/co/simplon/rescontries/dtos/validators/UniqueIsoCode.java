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
@Constraint(validatedBy = UniqueIsoCodeValidator.class)
public @interface UniqueIsoCode {
    String message() default "Coucou code iso exist deja";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

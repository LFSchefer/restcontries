package co.simplon.rescontries.dtos.validators;

import co.simplon.rescontries.services.CountryService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueTldValidator implements ConstraintValidator<UniqueTld, String> {

    private final CountryService service;

    public UniqueTldValidator(CountryService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
	if (value == null) {
	    return true;
	}
	return !service.existsByTldIgnoreCase(value);
    }

}

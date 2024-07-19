package co.simplon.rescontries.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ContactForm(@NotBlank @Size(max = 100) String firstname, @NotBlank @Size(max = 100) String lastname,
	@NotBlank String email, String comments) {

}
package co.simplon.rescontries.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.rescontries.entities.ContactForm;
import co.simplon.rescontries.services.MailService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/mail")
@CrossOrigin("*")
public class MailController {

    private final MailService service;

    public MailController(MailService service) {
	this.service = service;
    }

    @PostMapping("/send")
    public void sendMail(@RequestBody @Valid ContactForm form) {
	service.sendMail(form);

    }

}

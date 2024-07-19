package co.simplon.rescontries.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import co.simplon.rescontries.entities.ContactForm;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {

    @Value("${co.simplon.hello-spring.email.from}")
    private String emailFrom;

    private final JavaMailSender sender;

    public MailService(JavaMailSender sender) {
	this.sender = sender;
    }

    public void sendMail(ContactForm form) {
	System.out.println(form);
	try {
	    MimeMessage message = sender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	    helper.setFrom(emailFrom);
	    helper.setReplyTo(emailFrom);
	    helper.setTo(form.email());
	    helper.setSubject("test subject from spring");
	    helper.setText("Message: " + form.comments());
	    sender.send(message);
	} catch (MessagingException e) {
	    System.err.println(e);
	}

	System.out.println(form);

    }

}

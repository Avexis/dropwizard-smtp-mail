package no.avexis.dropwizard.mail;

import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;

public class SimpleMailerClient {

    private Mailer mailer;
    private String fromName;
    private String fromAddress;

    public SimpleMailerClient(Mailer mailer, String fromName, String fromAddress) {
        this.mailer = mailer;
        this.fromName = fromName;
        this.fromAddress = fromAddress;
    }

    public Mailer getMailer() {
        return this.mailer;
    }

    public void send(final Email email) {
        if (null == email.getFromRecipient()) {
            email.setFromAddress(fromName, fromAddress);
        }
        mailer.sendMail(email);
    }

    public void send(final String to, String subject, String text, boolean html) {
        final EmailBuilder email = new EmailBuilder()
                .from(fromName, fromAddress)
                .to(to)
                .subject(subject);
        if (html) {
            email.textHTML(text);
        } else {
            email.text(text);
        }
        mailer.sendMail(email.build());
    }
}

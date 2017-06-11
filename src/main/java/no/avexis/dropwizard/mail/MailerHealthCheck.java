package no.avexis.dropwizard.mail;

import com.codahale.metrics.health.HealthCheck;
import org.simplejavamail.mailer.Mailer;

public class MailerHealthCheck extends HealthCheck {

    private Mailer mailer;

    public MailerHealthCheck(final Mailer mailer) {
        this.mailer = mailer;
    }

    protected Result check() throws Exception {
        if (mailer.getSession().getTransport().isConnected()) {
            return Result.healthy();
        } else {
            return Result.unhealthy("Mailer can't connect to server");
        }
    }
}

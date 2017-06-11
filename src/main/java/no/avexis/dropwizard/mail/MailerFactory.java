package no.avexis.dropwizard.mail;

import com.google.common.base.Preconditions;
import io.dropwizard.setup.Environment;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.config.TransportStrategy;

public class MailerFactory {
    private String host;
    private Integer port;
    private String username;
    private String password;
    private TransportStrategy transportStrategy;
    private String fromName;
    private String fromAddress;

    public MailerFactory() {
        this.host = "localhost";
        this.port = 25;
        this.transportStrategy = TransportStrategy.SMTP_PLAIN;
    }

    public Mailer build(final Environment environment, final String name) {
        final Mailer mailer = new Mailer(host, port, username, password, transportStrategy);
        environment.healthChecks().register(name, new MailerHealthCheck(mailer));
        return mailer;
    }

    public SimpleMailerClient buildSimpleClient(final Environment environment, final String name) {
        Preconditions.checkNotNull(fromName);
        Preconditions.checkNotNull(fromAddress);
        final Mailer mailer = build(environment, name);
        return new SimpleMailerClient(mailer, fromName, fromAddress);
    }

}

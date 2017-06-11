# dropwizard-smtp-mail
A dropwizard module for sending smtp mail

### Configurations

Name | Type | Default | Other
--- | --- | --- | ---
host | String | localhost |
port | Integer | 25 |
username | String | |
password | String | |
transportStrategy | Enum | SMTP_PLAIN | SMTP_PLAIN SMTP_SSL SMTP_TLS
fromName | String | | Default sender name if none specified
fromAddress | String | | Default sender address if none specified


### Sample YML
mailerFactory:
  host: localhost
  port: 25
  username: user
  password: secret
  transportStrategy: SMTP_TLS
  fromName: NoReply
  fromAddress: noreply@example.com


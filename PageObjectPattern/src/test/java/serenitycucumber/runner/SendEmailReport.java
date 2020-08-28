package serenitycucumber.runner;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

/*change settings in Google email: Google Account >> Security >> Less Secure App access >> turn it ON*/

public class SendEmailReport {

    public static void main(String[] args) throws EmailException {

        System.out.println("Sending mail");

        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("target\\site\\serenity\\serenity-summary.html");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Serenity-Cucumber Summary  Report");
        attachment.setName("Serenity-Cucumber-Report");

        MultiPartEmail emailAttachment = new MultiPartEmail();
        emailAttachment.setHostName("smtp.gmail.com");
        emailAttachment.setSmtpPort(465);
        emailAttachment.setAuthenticator(new DefaultAuthenticator("yulia.borisova.tr@gmail.com", "Qa123456"));
        emailAttachment.setSSLOnConnect(true);
        emailAttachment.setFrom("yulia.borisova.tr@gmail.com");
        emailAttachment.setSubject("TestMail");
        emailAttachment.setMsg("Hi Artem! Sending you my first Serenity report. Have a nice day:)");
        emailAttachment.addTo("yulia.borisowa.qa@gmail.com");

        // add the attachment
        emailAttachment.attach(attachment);
        emailAttachment.send();
        System.out.println("Email sent");
    }
}
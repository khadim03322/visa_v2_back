package sn.gainde2000.orbuslink.visa.util;

import java.util.Properties;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Bassirou THIAM
 */
//public final class EmailSender implements Runnable {
public class EmailSender {

    /**
     * Mail sender account host.
     */
    public static final String MAIL_HOST = "172.16.2.11";
    /**
     * Email from.
     */
    private String from;
    /**
     * Email to.
     */
    private String to;
    /**
     * Email message.
     */
    private String message;
    /**
     * Email subject.
     */
    private String subject;
    /**
     * Email user name.
     */
    private String userName;
    /**
     * Email password.
     */
    private String password;

    /**
     * Public constructor with parameters.
     *
     * @param userName username
     * @param password password
     * @param from email from
     * @param to email to
     * @param message message about
     * @param subject email subject
     */
    public EmailSender(final String userName, final String password, final String from, final String to,
                       final String message, final String subject) {
        this.userName = userName;
        this.password = password;
        this.from = from;
        this.to = to;
        this.message = message;
        this.subject = subject;
    }

    /**
     * Sends email.
     *
     * @throws MessagingException message exception
     */
    public void sendMail() throws MessagingException {
        /*

         * Properties used to construct a email sending connection
         * protocal.
         */
    	System.out.println("Debut send");
        final Properties props = new Properties();
        props.put("mail.smtp.host", MAIL_HOST);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        final Authenticator auth = new SMTPAuthenticator();
        System.out.println("Debut auth");
        //final MimeMessage msg = new MimeMessage(Session.getDefaultInstance(props, auth));
        final MimeMessage msg = new MimeMessage(Session.getInstance(props, auth));
        msg.setFrom(new InternetAddress(from));
        msg.setRecipient(RecipientType.TO, new InternetAddress(to));
        msg.setSubject(subject);
        msg.setText(message);
        Transport.send(msg);
        System.out.println("Fin send");
    }


    public static void main(String[] args) {

        String subject = "Sujet";
        String text = "Texte 2";
//        String destinataire = "bathiam@gainde2000.sn";
        String destinataire = "thiambassirousn@gmail.com";
//        String destinataire = "thiambassirousn@yahoo.fr";
        String copyDest = "bathiam@gainde2000.sn";

        //sendMessage(subject, text, destinataire);
        
//        EmailSender emailSender = new EmailSender("userName", "", "no-reply@gainde2000.sn", "thiambassirousn@gmail.com", "Message", "subject");
        EmailSender emailSender = new EmailSender("userName", "", "no-reply@gainde2000.sn", "ksarr15@yopmail.com", "Message", "subject");
        try{
            emailSender.sendMail();
        } catch (MessagingException e) {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
            e.printStackTrace();
        }
    }

    /**
     * Inner class for Authenticator.
     */
    private class SMTPAuthenticator extends Authenticator {

        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(userName, password);
        }
    }
}

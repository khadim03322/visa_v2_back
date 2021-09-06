package sn.gainde2000.orbuslink.visa.util;


import org.springframework.stereotype.Service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Message.RecipientType; 
import javax.mail.MessagingException; 
import javax.mail.PasswordAuthentication;
import javax.mail.Session; 
import javax.mail.Transport; 
import javax.mail.internet.InternetAddress; 
import javax.mail.internet.MimeMessage; 


public class OrbusEmail {


	public static final String MAIL_HOST = "172.16.2.11";
    //public static final String MAIL_HOST = "smtp.gmail.com";
    private static final String PASSWORD = "";
    private static final String FROM = "no-reply@gainde2000.sn";
    //private static final String PASSWORD = "";

    public static void sendMail(String userName, String password, String from, String to, String message, String subject) throws MessagingException { 

        Properties props = new Properties();
        props.put("mail.smtp.host", MAIL_HOST); 

        Session session = Session.getInstance(props);
        MimeMessage msg = new MimeMessage(session); 
        msg.setFrom(new InternetAddress(from)); 
        msg.setRecipient(RecipientType.TO, new InternetAddress(to)); 
        msg.setSubject(subject); 
        msg.setText(message); 
        Transport.send(msg);
    }
    
    public static void sendHtmlMail(String userName, String password, String from, String to, String message, String subject) throws MessagingException { 

        System.out.println("message html");
        Properties props = new Properties();
        props.put("mail.smtp.host", MAIL_HOST); 

        Session session = Session.getInstance(props);
        MimeMessage msg = new MimeMessage(session); 
        msg.setFrom(new InternetAddress(from)); 
        msg.setRecipient(RecipientType.TO, new InternetAddress(to)); 
        msg.setSubject(subject); 
        msg.setText(message, "utf-8", "html"); 
        Transport.send(msg);
    }
    
    
    public static boolean sendMessage2(String subject, String text, String destinataire) {
        boolean isSend = false;
        try{
            sendMail("userName", PASSWORD, FROM, destinataire, text, subject);
            isSend = true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return isSend;
    }

    public static void sendMessage(String subject, String text, String destinataire) {
        try{
            sendMail("userName", PASSWORD, FROM, destinataire, text, subject);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
    public static boolean sendHtmlMessage(String subject, String text, String destinataire) {
        boolean isSend = false;
        
    	String debutCorps="<div id='banniere' style='background-color: #000069;color: white;font-weight: bold;font-size: 22px;padding-left: 5px;'>Portail Visa des Etats Financiers</div><div id='interieurMessage' style='margin: 20px auto 20px auto;width: 80%;'><div id='header' style='background-color: #0e70cf;color: white;padding: 40px 0 20px 40px;font-size: 26px;'>Portail Visa des Etats Financiers</div><div id='corps' style='margin: 20px 0 40px 60px;'>";
    	String finCorps="</div><div id='footer' style='background-color: #0e70cf;color: white;padding: 10px 0 10px 40px;font-size: 20px;'>Ne pas répondre à ce message</div></div>";
  
        try{
            sendHtmlMail("userName", PASSWORD, FROM, destinataire, debutCorps+text+finCorps, subject);
            isSend = true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return isSend;
    }
    
    
    /*
    public static boolean sendHtmlMessage(String subject, String text, String destinataire) {
        boolean isSend = false;
        
        String debutCorps="<div id='banniere' style='background-color: #000069;color: white;font-weight: bold;font-size: 22px;padding-left: 5px;'>Portail  Visa des Etats Financiers</div><div id='interieurMessage' style='margin: 20px auto 20px auto;width: 80%;'><div id='header' style='background-color: #0e70cf;color: white;padding: 40px 0 20px 40px;font-size: 26px;'>Portail  Visa des Etats Financiers</div><div id='corps' style='margin: 20px 0 40px 60px;'>";
        String finCorps="</div><div id='footer' style='background-color: #0e70cf;color: white;padding: 10px 0 10px 40px;font-size: 20px;'>Ne pas répondre à ce message</div></div>";
        String result= (new EnvoiGmail()).sendMail("userName", destinataire,  subject, debutCorps+text+finCorps);
        if(result.equals("SUCCESS"))
            isSend = true;
        return isSend;
    }
    */

    
    
    
    public static boolean sendMail3(String sujet, String texte, String destinataire )
    {
        Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("ultimax89@gmail.com","samagayn1989");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from@no-spam.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("ehis@yopmail.com"));
			message.setSubject(sujet);
			message.setText(texte);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
                return true;
	}
    
        
    
 
    //Constructor
    public OrbusEmail() {        
    }
	
	
	
	
	
	
	
	
	
	
	
}

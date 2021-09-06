package sn.gainde2000.orbuslink.visa.service.implementation;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import sn.gainde2000.orbuslink.visa.service.SimpleEmailService;
import sn.gainde2000.orbuslink.visa.util.EmailSender;
import sn.gainde2000.orbuslink.visa.util.OrbusEmail;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;

import javax.mail.MessagingException;

@Service
public class SimpleEmailServiceImpl implements SimpleEmailService {

	//@Value("${adresseLogo}")
    //private String adresseLogo = "http://196.207.202.51:7070/etafiv2/assets/images/logo/etafi.jpg" ;

    private String adresseLogo = "http://196.207.202.51:7070/etafiv3/assets/images/logo/etafi.jpg" ;

    private ScheduledExecutorService
	  quickService = Executors.newScheduledThreadPool(noOfQuickServiceThreads); //Creates a thread pool that reuses fixed number of threads(as specifie  noOfThreads in this case).
	public static int noOfQuickServiceThreads = 20;

	/*@Autowired
    private JavaMailSender sender;
     EnvoyerMail_Service service = new EnvoyerMail_Service();
    EnvoyerMail port = service.getEnvoyerMailPort();




    private ScheduledExecutorService quickService = Executors.newScheduledThreadPool(noOfQuickServiceThreads); // Creates a thread pool that reuses fixed number of threads(as specified by noOfThreads in this case).
    public static int noOfQuickServiceThreads = 20;

    */

    @Override
    public void sendEmail(String destinataie, String objet, String text)  {



    	  /*text
		  +="\nPour toute information ou besoin d’assistance veuillez-vous adresser à support-etafi@dgid.sn"
		  ; text = text.replace("\n","<br>") ; text = insertDecoration(text, objet) ;*/
    	/*String debutCorps="<div id='banniere' style='background-color: #000069;color: white;font-weight: bold;font-size: 22px;padding-left: 5px;'>Portail Visa des Etats Financiers</div><div id='interieurMessage' style='margin: 20px auto 20px auto;width: 80%;'><div id='header' style='background-color: #0e70cf;color: white;padding: 40px 0 20px 40px;font-size: 26px;'>Portail Visa des Etats Financiers</div><div id='corps' style='margin: 20px 0 40px 60px;'>";
    	String finCorps="</div><div id='footer' style='background-color: #0e70cf;color: white;padding: 10px 0 10px 40px;font-size: 20px;'>Ne pas répondre à ce message</div></div>";

		  
    		System.out.println("dest"+destinataie);
	    	EmailSender emailSender = new EmailSender("userName", "", "no-reply@gainde2000.sn",destinataie, debutCorps + text + finCorps, objet);
*/
    	
    	
	        quickService.submit(new Runnable() {

	      		  @Override public void run() { try{

	      		   System.out.println("Debut");
				   // emailSender.sendMail();
				 OrbusEmail.sendHtmlMessage(objet, text, destinataie);

	      		 System.out.println("Fin");
	      			  //sendSms(telephone, texte) ;

	      		  }catch(Exception e)
	      		  {
	      			  System.out.println(e.getMessage());
	      			  } } });







    }
    private String insertDecoration(String text, String objet) {

		  String result =
		  "<div class=\"\"><div class=\"aHl\"></div><div id=\":33\" tabindex=\"-1\"></div><div id=\":2s\" class=\"ii gt\"><div id=\":2r\" class=\"a3s aXjCH msg-5080072927546129928\"><u></u>\n"
		  + "\n" + "\n" + "    \n" + "    \n" + "\n" + "    \n" + "\n" + "\n" +
		  "<div style=\"background-color:#f2f2f2\">\n" +
		  "<div style=\"color:transparent;opacity:0;font-size:0px;border:0;max-height:1px;width:1px;margin:0px;padding:0px;border-width:0px!important;display:none!important;line-height:0px!important\">"
		  +
		  "<img border=\"0\" width=\"1\" height=\"1\" src=\"https://ci3.googleusercontent.com/proxy/oC8Eyd8oxa_6Pfoni8MAJ5RFpwzs1NRYY6VYir2q7j11giYmnsxDEPZt5LPxKUGPy0X81KNyFrKusUUhFIV-G-nkRkCGZToWC6aR9dh-nVtwbnt2Z6hW_X3J9B9fMJwsUCr3s8tF6iTJPGNHrUj3PeW02RksoPOhBt7jszgWvyf2t63UofGbw8H2OFoVJTHA8hkGsYyHxInKravXOIL4=s0-d-e1-ft#http://post.spmailtechnolo.com/q/WgiV3nbaAIzfCagzBAZjhg~~/AABLWQA~/RgRglAGDPVcDc3BjQgoAHoN8sV6KZsn5UhVhbGlvdW5lMTA5N0BnbWFpbC5jb21YBAAAAAA~\" class=\"CToWUd\"></div>\n"
		  + "\n" + "<div align=\"right\">\n" +
		  "    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" height=\"100%\" width=\"100%\" id=\"m_-5080072927546129928bodyTable\" style=\"background-color:#f2f2f2\">\n"
		  + "        <tbody><tr>\n" +
		  "            <td align=\"center\" valign=\"top\" id=\"m_-5080072927546129928bodyCell\" style=\"padding:40px 20px\">\n"
		  +
		  "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"m_-5080072927546129928emailContainer\" style=\"width:600px\">\n"
		  + "                    <tbody><tr>\n" +
		  "                        <td align=\"center\" valign=\"top\">\n" +
		  "                            <a  style=\"text-align:center\" target=\"_blank\" >"
		  + "<img src=\""
		  +adresseLogo+"\"  width=\"200px\" alt=\"DGID\" class=\"CToWUd\"></a>\n" +
		  "                        </td>\n" + "                    </tr>\n" +
		  "                    <tr>\n" +
		  "                        <td align=\"center\" valign=\"top\" style=\"padding-top:30px;padding-bottom:30px\">\n"
		  +
		  "                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" id=\"m_-5080072927546129928emailBody\" style=\"background-color:#ffffff;border-collapse:separate!important;border-radius:4px\">\n"
		  + "                                <tbody><tr>\n" +
		  "                                    <td align=\"center\" valign=\"top\" style=\"color:#606060;font-family:Helvetica,Arial,sans-serif;font-size:15px;line-height:150%;padding-top:40px;padding-right:40px;padding-bottom:30px;padding-left:40px;text-align:center\">\n"
		  +
		  "                                        <h1 style=\"color:#606060!important;font-family:Helvetica,Arial,sans-serif;font-size:18px;font-weight:bold;letter-spacing:-1px;line-height:115%;margin:0;padding:0;text-align:center\">"
		  +objet+"</h1>\n" + "                                        <br>\n" + text+
		  "                                    </td>\n" +
		  "                                </tr>\n" +
		  "                                                                    <tr>\n"
		  + "                                    </tr>\n" +
		  "                                                            </tbody></table>\n"
		  + "                        </td>\n" + "                    </tr>\n" +
		  "                    <tr>\n" +
		  "                        <td align=\"center\" valign=\"top\">\n" +
		  "                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" id=\"m_-5080072927546129928emailFooter\">\n"
		  + "                                <tbody><tr>\n" +
		  "                                    <td align=\"center\" valign=\"top\" style=\"color:#606060;font-family:Helvetica,Arial,sans-serif;font-size:13px;line-height:125%\">\n"
		  + "\n" + "                                        \n" +
		  "                                        <br>\n" +
		  "                                        <p>(+221)33 889 20 02 - " +
		  "31 Rue de Thiong, Dakar &amp;dash; © 2020 DGID · Tous Droits Réservés.\n" +
		  "                                    </p></td>\n" +
		  "                                </tr>\n" +
		  "                            </tbody></table>\n" +
		  "                        </td>\n" + "                    </tr>\n" +
		  "                </tbody></table>\n" + "            </td>\n" +
		  "        </tr>\n" + "    </tbody></table>\n" + "</div>\n" + "\n" +
		  "<img border=\"0\" width=\"1\" height=\"1\" alt=\"\" src=\"https://ci3.googleusercontent.com/proxy/z2Dk_JeHqb0YJbg4JS2Z15dj754i9NmEHWInjTgTzHmwxTR4AfurczHkl8_dHis0rnIs2vhKO5So5f_UtgK1BV9ZC09UznuMyX2DkxzVi332CfLu6cvKVtilsaFwWtqTWfp-U-wWcu4e25PrLZkczrsHvFUO17fT7l8kXtBcoGA7eAcqMQEKDn5_Q3LlMMSWdW2C2ddxdzkoAfHXUb7k=s0-d-e1-ft#http://post.spmailtechnolo.com/q/nyCTncyovuaAeSRZ1K81OA~~/AABLWQA~/RgRglAGDPlcDc3BjQgoAHoN8sV6KZsn5UhVhbGlvdW5lMTA5N0BnbWFpbC5jb21YBAAAAAA~\" class=\"CToWUd\"><div class=\"yj6qo\"></div><div class=\"adL\">\n"
		  + "</div></div><div class=\"adL\">\n" + "\n" + "\n" + "\n" +
		  "</div></div></div><div id=\":38\" class=\"ii gt\" style=\"display:none\"><div id=\":37\" class=\"a3s aXjCH undefined\"></div></div><div class=\"hi\"></div></div>"
		  ;

		  return result ;



    }
}

package multimif.grpc.model;


import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

    private static Logger logger = Logger.getLogger(MailSender.class.getName());

    private MailSender() {
        // on empêche l'instanciation
    }

    public static void generateAndSendEmail(User usr)  {
        try {
            Properties mailServerProperties = System.getProperties();
            mailServerProperties.put("mail.smtp.port", "587");
            mailServerProperties.put("mail.smtp.auth", "true");
            mailServerProperties.put("mail.smtp.starttls.enable", "true");
            Session getMailSession = Session.getDefaultInstance(mailServerProperties, null);
            MimeMessage generateMailMessage = new MimeMessage(getMailSession);
            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(usr.getEmail()));
            generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(usr.getEmail()));
            generateMailMessage.setSubject("Election2017Simulator account verification");
            String code = usr.getActivationcode();
            String emailBody = "Account activation. " +
                    "<br><br> Activation link :"+
                    "<a href=http://localhost:8080/m1if10/registrationConfirm?code="+
                    code +
                    ">Activate</a>";
            generateMailMessage.setContent(emailBody, "text/html");
            Transport transport = getMailSession.getTransport("smtp");


            transport.connect("smtp.gmail.com", "dj.idir94@gmail.com", "Dj1994kiki080315");
            transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
            transport.close();
        }catch (MessagingException e) {
            logger.log(Level.WARNING, "Impossible d'envoyer un mail", e);
        }
    }
}



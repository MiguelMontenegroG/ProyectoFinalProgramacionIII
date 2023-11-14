package Proyecto.model;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class Correos {
    public static void EnviarCorreoReserva(String correo){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("agenciaviajes056@gmail.com", "ccawlcnxpcngmngj");
            }
        });

        try{
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correo, true));
            message.setSubject("Prueba 3");
            message.setText("Su registro fue exitoso");
            System.out.println("sending...");
            Transport.send(message);
            System.out.println("Sent message successfully....");

        }catch (MessagingException me){
            System.out.println("Exception: "+me);

        }
    }
}
    //public static void main (String[] args){

//}

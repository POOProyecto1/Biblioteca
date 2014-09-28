package enviarMail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//clase basada en código tomado de internet
public class javamail {
    private final Properties properties = new Properties();
    private Session session;
	 
    private void init() {
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.mail.sender", "virtualiteca@gmail.com");//Ingresar el correo emisor
        properties.put("mail.smtp.password", "biblioVirtual"); //Ingresar contraseña de correo
        properties.put("mail.smtp.user", "virtualiteca@gmail.com");//Ingresar el correo emisor
        properties.put("mail.smtp.auth", "true");
        session = Session.getDefaultInstance(properties);
    }
    
    public boolean send(String destino,String asunto, String mensaje) {
        init();
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            message.setSubject(asunto);          //Asunto
            message.setText(mensaje);			//Mensaje
            Transport t = session.getTransport("smtp");
            t.connect((String) properties.get("mail.smtp.user"), (String) properties.get("mail.smtp.password"));
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            System.out.println("Enviado");
            return true;
        } catch (MessagingException e) {
            System.out.println("Fallido");
        	return false;
        }
    }
    
    public boolean enviarCorreo(String destinatario,String asunto,String mensaje){
    	boolean result = send(destinatario,asunto,mensaje);
    	return result;
    }
}

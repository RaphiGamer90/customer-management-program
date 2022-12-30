package manager.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendingEmail {

String messageSendingText = "Die Mail wird vorbereitet!";
	
	
	//Methode, die eine Mail verschickt
	public void sendmail(String recipient, String subject, String body) {
		//Mail wird vorbereitet
		
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.host", "smtp.office365.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.debug", "true");
		
//		properties.put("mail.smtp.host", "smtp.gmail.com");
//		properties.put("mail.smtp.port", "587");
//		properties.put("mail.smtp.auth", "true");
//		properties.put("mail.smtp.starttls.enable", "true");
//		properties.put("mail.smtp.starttls.required", "true");
//		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
//		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		String myAccountEmail = "zangl@zangl-immobilien.at";
		String password = "tj9XZiitu3bGuu5#@Xjz28sd";
		
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});
		
		Message message = prepareMessage(session, myAccountEmail, recipient, subject, body);
		
		try {
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			messageSendingText = "Ein Fehler bei Versenden ist aufgetreten!";
		}
		messageSendingText = "Message sent successfully!";
		
	}

	public Message prepareMessage(Session session, String myAccountEmail, String recepient, String subject, String body) {
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject(subject);
			message.setText(body);
			return message;
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}	
		
		return null;
	}
	
}

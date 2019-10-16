package TestPages;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SentMailTest {
	WebDriver driver;
	Properties prop; 
	@Test
	public void sendingMail(){
		prop=new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.port","465");	
		Session session=Session.getDefaultInstance(prop, 
				new Authenticator(){
			
			protected PasswordAuthentication getPasswordAuthentication(){
				
				return new PasswordAuthentication("practices87@gmail.com","selenium.123");
			}
		});
	
		
		
		try {
			Message message=new MimeMessage(session);
			message.setFrom(new InternetAddress("practices87@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("practices87@gmail.com"));
			message.setSubject("Testing Selenium");
			
			BodyPart mssgBodyPart1=new MimeBodyPart();
			mssgBodyPart1.setText("This is Message body");
			
			MimeBodyPart mssgBidyPart2=new MimeBodyPart();
			
			String filename="C:\\Users\\ASHOK\\workspace\\FreeCrmTesting\\MynewBook.xlsx";
			
			DataSource source=new FileDataSource(filename);
			
			mssgBidyPart2.setDataHandler(new DataHandler(source));
			mssgBidyPart2.setFileName(filename);
			Multipart multipart=new MimeMultipart();
			
			multipart.addBodyPart(mssgBidyPart2);
			multipart.addBodyPart(mssgBodyPart1);
			message.setContent(multipart);
			
			Transport.send(message);
			System.out.println("****Email was sent****");
			
			
		} catch (AddressException e) {
			
			e.printStackTrace();
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	

}

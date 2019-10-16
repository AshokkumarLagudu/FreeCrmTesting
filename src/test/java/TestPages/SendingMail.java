package TestPages;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendingMail {
 
	public static void main(String[] args) throws EmailException{
	System.out.println("========== sending mail===========");
		Email email=new SimpleEmail();
	
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("practices87@gmail.com","selenium.123") );
		email.setSSLOnConnect(true);
		email.setFrom("ashokkumarlagudu@gmail.com");
		email.setSubject("Selenium email testing");
		email.setMsg("This is my first mail");
		email.addTo("ashokkumarcse.515@gmail.com");
		email.send();
	
		System.out.println("==========mail sent==========");
	
		
	}
}

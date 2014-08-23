package MedicalPredictionServlets;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	String d_email = "smarthealthcare.sjsu@gmail.com", d_password = "weideryu", d_host = "smtp.gmail.com",
			d_port = "465";
			

	public Mail(String m_to,String m_subject,String m_text) {
		Properties props = new Properties();
		props.put("mail.smtp.user", d_email);
		props.put("mail.smtp.host", d_host);
		props.put("mail.smtp.port", d_port);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		// props.put("mail.smtp.debug", "true");
		props.put("mail.smtp.socketFactory.port", d_port);
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");


		try {
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(props, auth);
			// session.setDebug(true);

			MimeMessage msg = new MimeMessage(session);
			msg.setText(m_text);
			msg.setSubject(m_subject);
			msg.setFrom(new InternetAddress(d_email));
			msg.addRecipient(Message.RecipientType.TO,
					new InternetAddress(m_to));
			Transport.send(msg);
		} catch (Exception mex) {
			mex.printStackTrace();
		}
	}

	private class SMTPAuthenticator extends javax.mail.Authenticator {
		public javax.mail.PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(d_email, d_password);
		}
	}
}
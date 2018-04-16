import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticatior extends Authenticator {

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		// TODO Auto-generated method stub
		return new PasswordAuthentication("gkseorjs123", "drinky12#$");
	}
}

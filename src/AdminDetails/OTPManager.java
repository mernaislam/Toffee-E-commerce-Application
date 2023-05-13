package AdminDetails;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * This is a class that manages sending the otp process.
 */
public class OTPManager
{
    /**
     * Generates a random number as an otp to be sent
     *@param otpLength the length of the radom number
     *@return a random number with length equal to otpLength
     */
    public static int generateOTP(int otpLength)
    {
        Random random=new Random();

        StringBuilder sb=new StringBuilder();

        for(int i=0 ; i< otpLength ; i++)
        {
            sb.append(random.nextInt(10));
        }

        String otp=sb.toString();
        int code = Integer.parseInt(otp);

        return code;
    }
    /**
     * Sends an otp to a specified email
     *@param email the email of the receiver
     *@param code the random number generated to be sent as the otp
     *@return true if the otp is sent, false otherwise
     */
    public boolean sendOTP(String email , int code)
    {
        String host = "smtp.gmail.com";
        String username = "shoptoffee051@gmail.com";
        String password = "ajnczwnqwusztynp";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try
        {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(username));

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

            message.setSubject("TOFFEE SHOP VERIFICATION CODE");
            message.setText("Your OTP is : " + code );

            Transport.send(message);
            System.out.println("Email sent successfully!");
            return true;
        }
        catch (MessagingException e)
        {
            //throw new RuntimeException(e);
            return false;
        }
    }
}
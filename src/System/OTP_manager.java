package System;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class OTP_manager {

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
    public boolean sendOTP(String email , int code)
    {
        String host = "smtp.gmail.com";
        String username = "fcaitoffeeshop@gmail.com";
        String password = "dfpzbhgihyfxtbjp";
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

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(username));

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

            message.setSubject("TOFFEE SHOP VERIFICATION CODE");
            message.setText("Your OTP IS : " + code );

            Transport.send(message);
            System.out.println("Email sent successfully!");
            return true;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
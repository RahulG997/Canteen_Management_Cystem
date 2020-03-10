
package com.hexaware.MLP191.util;

import java.text.DecimalFormat;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *@return
 *
 */
public class SendMail {
/** @param otp otp */
  private static String otp;
  /** */
  protected SendMail() {
  }

  /**
   * @param to to
   * @return too
   */
  public static String otpgen(final String to) {

        // Sender's email ID needs to be mentioned
    final String from = "sggurushakthi@gmail.com";

        // Assuming you are sending email from through gmails smtp
    final String host = "smtp.gmail.com";

        // Get system properties
    final Properties properties = System.getProperties();

        // Setup mail server
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", "465");
    properties.put("mail.smtp.ssl.enable", "true");
    properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
    final Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

      protected PasswordAuthentication getPasswordAuthentication() {

            return new PasswordAuthentication("sggurushakthi@gmail.com", "sai2616shakthi");

          }

        });

        // Used to debug SMTP issues
    session.setDebug(true);

    try {
            // Create a default MimeMessage object.
      final MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
      message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            /*
             * String numbers = "0123456789"; String Capital_chars = "ABCDEF"; String values
             * = Capital_chars + numbers; Random rndm_method = new Random(); int len=2;
             * char[] password = new char[len];
             *
             * for (int i = 0; i < len; i++) { // Use of charAt() method : to get character
             * value // Use of nextInt() as it is scanning the value as int password[i] =
             * values.charAt(rndm_method.nextInt(values.length())); }
             */

      otp = new DecimalFormat("0000").format(new Random().nextInt(9999));

            // Set Subject: header field
      message.setSubject("Hurrayy!! Here the OTP for CMS");

            // Now set the actual message
      message.setText("Welcome to CMS \n\nOTP: " + otp);
            // message.setText("Thank for ur Support!!!");
      System.out.println("sending...");
            // Send message
      Transport.send(message);
      System.out.println("Sent message successfully....");
    } catch (final MessagingException mex) {
      mex.printStackTrace();
    }
    return otp;

  }

}

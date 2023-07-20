/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.Account;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author LENOVO
 */
public class SendEmail {
        public String getRandom(){
         Random rnd = new Random();
         int number = rnd.nextInt(99999);
         return  String.format("%06d", number);
    }
    public  boolean sendEmail( Account user){
        boolean test = false;
        String toEmail= user.getEmail();
//        String fromEmail = "trinhltnde160563@fpt.edu.vn";
//        String password = "lethinguyentrinh154";

        try{
            Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
		props.put("mail.smtp.port", "587"); // TLS 587 SSL 465
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
                    final String from = "trinhlethinguyen154@gmail.com";
                final String password = "mvsojzbfulhwulrv";
                
            Session session = Session.getInstance(props,new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(from, password);
                }
            });

            Message mess = new MimeMessage(session);
            
            
            mess.setText("your verity code is:");
            mess.setFrom(new InternetAddress(from));
            mess.setRecipient(Message.RecipientType.TO,new  InternetAddress(toEmail));
            
            mess.setSubject("User Email Verification");

            mess.setText("Ma cu ban la:"+user.getCode());

            mess.setText("Your verification code is:"+user.getCode());

 
          
//            
            
            Transport.send(mess);
            test = true;
        }catch(Exception e){
            System.out.println("Gặp lỗi trong quá trình gửi email");
			e.printStackTrace();
			return false;
        }
        return test;
    }
    public  boolean sendEventEmail( Account user){
        boolean test = false;
        String toEmail= user.getEmail();
//        String fromEmail = "trinhltnde160563@fpt.edu.vn";
//        String password = "lethinguyentrinh154";

        try{
            Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
		props.put("mail.smtp.port", "587"); // TLS 587 SSL 465
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
                final String from = "trinhlethinguyen154@gmail.com";
                final String password = "mvsojzbfulhwulrv";
                
            Session session = Session.getInstance(props,new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(from, password);
                }
            });

            Message mess = new MimeMessage(session);
            
            
            mess.setText("your verity code is:");
            mess.setFrom(new InternetAddress(from));
            mess.setRecipient(Message.RecipientType.TO,new  InternetAddress(toEmail));
            
            mess.setSubject("Good Pizza, Great PRICE");
             String htmlContent = "<div class=\"modal\" style=\"display:flex; justify-content:center; align-items:center;\">\n" +
                            "        <div class=\"container\" style=\"width: 600px; height: 808px;\">\n" +
                            "            <h1 style=\"text-align:center\">Good Pizza, Great Pizza</h1>\n" +
                            "            <p>What's cooking Ovenists!🧑‍🍳A LIVE Event Q&A is coming this Wednesday (8/12)for\n" +
                            "                 any questions on this great pizza summer event! Join us on Reddit or Discord \n" +
                            "                 every Mon-Fri 4-7PM PST. Have a🍕day!\n" +
                            "            </p>\n" +
                            "            <img class=\"image\" style=\"width: 600px;\" src=\"https://pbs.twimg.com/media/EfGxG26UcAYFT3Z?format=jpg&name=4096x4096\">\n" +
                            "        </div>\n" +
                            "    </div>";
            mess.setContent(htmlContent, "text/html");
 
          
//            
            
            Transport.send(mess);
            test = true;
        }catch(Exception e){
            System.out.println("Gặp lỗi trong quá trình gửi email");
			e.printStackTrace();
			return false;
        }
        return test;
    }
        public  boolean CreateAccount( Account user){
        boolean test = false;
        String toEmail= user.getEmail();
//        String fromEmail = "trinhltnde160563@fpt.edu.vn";
//        String password = "lethinguyentrinh154";
        try{
            Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
		props.put("mail.smtp.port", "587"); // TLS 587 SSL 465
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
                    final String from = "trinhlethinguyen154@gmail.com";
                final String password = "mvsojzbfulhwulrv";
                
            Session session = Session.getInstance(props,new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(from, password);
                }
            });

            Message mess = new MimeMessage(session);
            
            
            mess.setFrom(new InternetAddress(from));
            mess.setRecipient(Message.RecipientType.TO,new  InternetAddress(toEmail));
            
            mess.setSubject("Create Account successfull!!");
            mess.setText("You are created Account in FastBites.Your Username is:"+user.getUsername());
            
          
//            
            
            Transport.send(mess);
            test = true;
        }catch(Exception e){
            System.out.println("Gặp lỗi trong quá trình gửi email");
			e.printStackTrace();
			return false;
        }
        return test;
    }
     public  boolean CheckOut( String idOrder,String email){
        boolean test = false;
        String toEmail= email;
//        String fromEmail = "trinhltnde160563@fpt.edu.vn";
//        String password = "lethinguyentrinh154";

        try{
            Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
		props.put("mail.smtp.port", "587"); // TLS 587 SSL 465
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
                    final String from = "trinhlethinguyen154@gmail.com";
                final String password = "mvsojzbfulhwulrv";
                
            Session session = Session.getInstance(props,new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(from, password);
                }
            });

            Message mess = new MimeMessage(session);
            
            
            mess.setFrom(new InternetAddress(from));
            mess.setRecipient(Message.RecipientType.TO,new  InternetAddress(toEmail));
            
            mess.setSubject("Check Out Successfull");
            mess.setText("You are payment successfull OrderID: :"+idOrder+".Thank You Sâu mợt");                    
//                      
            Transport.send(mess);
            test = true;
        }catch(Exception e){
            System.out.println("Gặp lỗi trong quá trình gửi email");
			e.printStackTrace();
			return false;
        }
        return test;
    }   
     
     public  boolean ApplySuccess( String email){
        boolean test = false;
        String toEmail= email;
//        String fromEmail = "trinhltnde160563@fpt.edu.vn";
//        String password = "lethinguyentrinh154";

        try{
            Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
		props.put("mail.smtp.port", "587"); // TLS 587 SSL 465
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
                    final String from = "trinhlethinguyen154@gmail.com";
                final String password = "mvsojzbfulhwulrv";
                
            Session session = Session.getInstance(props,new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(from, password);
                }
            });

            Message mess = new MimeMessage(session);
            
            
            mess.setFrom(new InternetAddress(from));
            mess.setRecipient(Message.RecipientType.TO,new  InternetAddress(toEmail));
            
            mess.setSubject("Successfully applied for SHIPPER");
            mess.setText("We are happy to inform you that you have been accepted and become the shop's shipper. See you in person at the store to exchange information");                    
//                      
            Transport.send(mess);
            test = true;
        }catch(Exception e){
            System.out.println("Gặp lỗi trong quá trình gửi email");
			e.printStackTrace();
			return false;
        }
        return test;
    }   
     
     
      public  boolean ApplyFailed( String email){
        boolean test = false;
        String toEmail= email;
//        String fromEmail = "trinhltnde160563@fpt.edu.vn";
//        String password = "lethinguyentrinh154";

        try{
            Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
		props.put("mail.smtp.port", "587"); // TLS 587 SSL 465
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
                    final String from = "trinhlethinguyen154@gmail.com";
                final String password = "mvsojzbfulhwulrv";
                
            Session session = Session.getInstance(props,new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(from, password);
                }
            });

            Message mess = new MimeMessage(session);
            
            
            mess.setFrom(new InternetAddress(from));
            mess.setRecipient(Message.RecipientType.TO,new  InternetAddress(toEmail));
            
            mess.setSubject("Apply for SHIPPER OF FASTBITES STORE");
            mess.setText("We regret to inform you that you have not been accepted as a shipper. My shop will recruit shippers in the next recruitment you can apply again. We appreciate your spirit. Looking forward to working with you in the future");                    
//                      
            Transport.send(mess);
            test = true;
        }catch(Exception e){
            System.out.println("Gặp lỗi trong quá trình gửi email");
			e.printStackTrace();
			return false;
        }
        return test;
    }   
      
      
      public  boolean CancelOrder( String email){
        boolean test = false;
        String toEmail= email;
//        String fromEmail = "trinhltnde160563@fpt.edu.vn";
//        String password = "lethinguyentrinh154";

        try{
            Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
		props.put("mail.smtp.port", "587"); // TLS 587 SSL 465
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
                    final String from = "trinhlethinguyen154@gmail.com";
                final String password = "mvsojzbfulhwulrv";
                
            Session session = Session.getInstance(props,new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(from, password);
                }
            });

            Message mess = new MimeMessage(session);
            
            
            mess.setFrom(new InternetAddress(from));
            mess.setRecipient(Message.RecipientType.TO,new  InternetAddress(toEmail));
            
            mess.setSubject("Cancel Successfull Order");
            mess.setText("You have successfully canceled your order. If you have already paid please fill out this form so we can check and refund you.");                    
//                      
            Transport.send(mess);
            test = true;
        }catch(Exception e){
            System.out.println("Gặp lỗi trong quá trình gửi email");
			e.printStackTrace();
			return false;
        }
        return test;
    }   
     
}


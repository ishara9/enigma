/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valkyrie.enigma.enigmaplus.Controller;

/**
 *
 * @author heshanjayasinghe
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailController{
    private  static String FROM;  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD; // GMail password
    private static String SUBJECT;
    private static String MESSAGE;
    private static String HOSTURL;
    private static String PORT;
    
    public EmailController() {
        FROM = "enigmakbplus@gmail.com";
        PASSWORD = "enigmakb+";
    }
        //******
           public static void readMail()throws Exception{
            String hostAddress="173.194.65.109";
            String userValue="enigmakbplus@gmail.com";
            String passwordValue="enigmakb+";
            
            Properties prop=new Properties();
            Session mailSession=Session.getDefaultInstance(prop, null);
            Store mailStore=mailSession.getStore("imaps");
            mailStore.connect(hostAddress, userValue, passwordValue);
            Folder mailFolder=mailStore.getFolder("INBOX");
            mailFolder.open(Folder.READ_ONLY);
            BufferedReader mailReader=new BufferedReader(new InputStreamReader(System.in));
            Message msg[]=mailFolder.getMessages();
            for (int i = 3,j=msg.length; i <j; i++) {
                System.out.println(i+" : "+msg[i].getFrom()+"\t"+msg[i].getSubject());
                System.out.println("Do you want to read message? [YES read/QUIT to end]");
                String msgLine=mailReader.readLine();
                if("YES".equals(msgLine)){
                    System.out.println(msg[i].getContent());
                }else if("QUIT".equals(msgLine)){
                    break;
                }
            }
            mailFolder.close(false);
            mailStore.close();
       
        //******
    }
    
    public static void sendMail(String qid, String title, String sDescription, String description, String askerFname, String expertEmail){
        String[] TO = expertEmail.split(",");
        MESSAGE = "Short description: "+ sDescription +"\nDescription: "+ description +"\nAsker: "+ askerFname;
        SUBJECT = "QID: " +qid+ " - " +title;
        sendFromGMail(FROM, PASSWORD, TO, SUBJECT, MESSAGE,HOSTURL,PORT);
    }
    

    private  static void sendFromGMail(String from, String pass, String[] to, String subject, String body, String hostURL, String port) {
        Properties props = System.getProperties();
        String host;
        //*******mymodification start
       
            host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        
        //end
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        EmailController obj = new EmailController();
        //sendMail("253", "this is the title", "short fucking description", "Des fucking cription", "Asking fucker", "nipunthathsara@gmail.com");
        readMail();            
    }
    
    //**************
          
    


}





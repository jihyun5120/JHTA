package semishit;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
 public static void main(String[] args) {
    String host = "smtp.naver.com";  

    final String username = "sungbae_academy"; //���̹� ���̵� �Է�
    final String password = "dbwls2002"; //���̹� �̸��� ��й�ȣ

    int port=465; //��Ʈ��ȣ  

     

    // ���� ����  

    String recipient = "sungbae_academy@naver.com"; //�޴� ����� �����ּ�

    String subject = "����"; //���� ���� 

    String body = username+"������ ���� ���̾�����Ӥþ����̤��ƤøӤӤӤ���"; //���� ���� �Է�

     

    Properties props = System.getProperties();  

     

    // ������ ��� ���� ��ü ����  

    // SMTP ���� ���� ����  

    props.put("mail.smtp.host", host);  

    props.put("mail.smtp.port", port);  

    props.put("mail.smtp.auth", "true");  

    props.put("mail.smtp.ssl.enable", "true");  

    props.put("mail.smtp.ssl.trust", host);  

    //Session ����  

    Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {  

    String un=username;  

    String pw=password;  

    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {  

    return new javax.mail.PasswordAuthentication(un, pw);  

    }  

    });  

    session.setDebug(true); //for debug  

    Message mimeMessage = new MimeMessage(session); //MimeMessage ���� 

    try {
      mimeMessage.setFrom(new InternetAddress("sungbae_academy@naver.com"));
    //�߽��� ���� , ������ ����� �̸����ּҸ� �ѹ� �� �Է�. �̶��� �̸��� Ǯ �ּҸ� �� �ۼ��ؾ��Ѵ�..  

    
      mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); //�����ڼ���  

     

    
      mimeMessage.setSubject(subject); //�������  

    
      mimeMessage.setText(body); //������� 

   
      Transport.send(mimeMessage); //javax.mail.Transport.send() �̿� 
 }catch(Exception ex) {
    ex.printStackTrace();
    
    
 }

 }
}
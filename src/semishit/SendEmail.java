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

    final String username = "sungbae_academy"; //네이버 아이디를 입력
    final String password = "dbwls2002"; //네이버 이메일 비밀번호

    int port=465; //포트번호  

     

    // 메일 내용  

    String recipient = "sungbae_academy@naver.com"; //받는 사람의 메일주소

    String subject = "하이"; //메일 제목 

    String body = username+"님으로 부터 하이아히어ㅣㅓ아이이ㅏ아ㅓ머ㅣㅣㅏㅓ"; //메일 내용 입력

     

    Properties props = System.getProperties();  

     

    // 정보를 담기 위한 객체 생성  

    // SMTP 서버 정보 설정  

    props.put("mail.smtp.host", host);  

    props.put("mail.smtp.port", port);  

    props.put("mail.smtp.auth", "true");  

    props.put("mail.smtp.ssl.enable", "true");  

    props.put("mail.smtp.ssl.trust", host);  

    //Session 생성  

    Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {  

    String un=username;  

    String pw=password;  

    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {  

    return new javax.mail.PasswordAuthentication(un, pw);  

    }  

    });  

    session.setDebug(true); //for debug  

    Message mimeMessage = new MimeMessage(session); //MimeMessage 생성 

    try {
      mimeMessage.setFrom(new InternetAddress("sungbae_academy@naver.com"));
    //발신자 셋팅 , 보내는 사람의 이메일주소를 한번 더 입력. 이때는 이메일 풀 주소를 다 작성해야한다..  

    
      mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); //수신자셋팅  

     

    
      mimeMessage.setSubject(subject); //제목셋팅  

    
      mimeMessage.setText(body); //내용셋팅 

   
      Transport.send(mimeMessage); //javax.mail.Transport.send() 이용 
 }catch(Exception ex) {
    ex.printStackTrace();
    
    
 }

 }
}
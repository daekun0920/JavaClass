<%@page import="javax.mail.MessagingException"%>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.PasswordAuthentication"%>
<%@page import="javax.mail.Session"%>
<%@page import="java.util.Properties"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%

String name = request.getParameter("name");
String email = request.getParameter("email");
String subject = request.getParameter("subject");
String mensaje = request.getParameter("message");


%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%

	  String host     = "smtp.naver.com";
	  final String user   = "gkseorjs123";
	  final String password  = "drinky12#$";

	  String to     = "gkseorjs123@naver.com";

	  
	  // Get the session object
	  Properties props = new Properties();
	  props.put("mail.smtp.host", host);
	  props.put("mail.smtp.auth", "true");

	  Session session2 = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	   protected PasswordAuthentication getPasswordAuthentication() {
	    return new PasswordAuthentication(user, password);
	   }
	  });

	  // Compose the message
	  try {
	   MimeMessage message = new MimeMessage(session2);
	   message.setFrom(new InternetAddress(user));
	   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	   // Subject
	   message.setSubject(subject);
	   
	   // Text
	   message.setText("name : " + name + "\nemail : " + email + "\nmessage : " +  mensaje);

	   // send the message
	   Transport.send(message);
	   
	   %>
	   <script>
	   	alert("메일을 성공적으로 전송하였습니다.");
	   
	   </script>
	<%
		out.println("메일 보내기 완료!");
		response.sendRedirect("index.html");
	  } catch (MessagingException e) {
	   e.printStackTrace();
	   %>
	   <script>
	   	alert("메일을 전송하지 못하였습니다.");

	   	</script>
	   <%
	   response.sendRedirect("index.html");
	  }
	 
	


%>
</head>
<body>
	
</body>
</html>
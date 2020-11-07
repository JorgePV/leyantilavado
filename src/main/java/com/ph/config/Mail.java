package com.ph.config;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	
	private static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
		String remitente="jperez@sienko.com.mx"; // pruebas de envio
		Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "465");
	    Session session = Session.getDefaultInstance(props,
	      new javax.mail.Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	          return new PasswordAuthentication("correo@gmail.com","passw0rd");
	        }
	      });
	    try {
	      Message message = new MimeMessage(session);
	      message.setFrom(new InternetAddress(remitente));
	      message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(destinatario));
	      message.setSubject(asunto);
	      message.setText(cuerpo);
	      Transport.send(message);
	      System.out.println("Correcto!");
	    } catch (MessagingException e) {
	      throw new RuntimeException(e);
	    }
	  }
	/*
	static final public void main(String[] args) {
		Mail correo = new Mail();
		correo.enviarConGMail("jperezv@ph.com.mx","PruebaX_dos","pruebas de envio");
        System.out.println("Envio CORREO");
    }
	*/
}

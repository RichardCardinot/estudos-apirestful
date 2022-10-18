package br.org.serratec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration // Com essa anotação o Spring passa a gerenciar essa classe
public class MailConfig {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String para, String assunto, String texto) { 
		SimpleMailMessage message = new SimpleMailMessage(); // Classe que monta a estrutura do email.
		
		message.setFrom("richard.figueiredo@aluno.senai.br"); // O e-mail de origem é passado como parâmetro
		message.setTo(para); // O e-mail de destino é passado como parâmetro
		message.setSubject(assunto);
		message.setText("Dados do cadastro do usuário: \n" + texto + "\n\n\n\n Serratec Residência-2022");
		
		javaMailSender.send(message);
	}
}

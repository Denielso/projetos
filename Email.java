package br.com.novo.Controller;

import java.net.MalformedURLException;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.sun.xml.internal.stream.buffer.stax.StreamReaderBufferCreator;

public class Email {
	
	
	/*public static void main(String[] args) throws EmailException, MalformedURLException {
	}*/
	
	public void sendEmail(String nome, String emailCliente) throws EmailException, MalformedURLException{
		
		/*HTML EMAIL*/
		String html = "<head>"
						+ "<meta charset='utf-8'>"
						+ "<meta http-equiv='X-UA-Compatible' content='IE=edge'>"
						+ "<meta name='viewport' content='width=device-width, initial-scale=1'>"
						+ "<meta name='description' content=''>"
						+ "<meta name='author' content='Denielso'>"
						+ "<title>E-mail</title>"
						+ "<link href='bootstrap/css/bootstrap.min.css' rel='stylesheet'>"
						+ "<link rel='stylesheet' type='text/css' href='bootstrap/css/email.css'></link>"
						+ "<script src='bootstrap/js/jquery.js'></script>"
						+ "<script type='text/javascript' src='bootstrap/js/ebook.js'></script>"
						+ "<script src='bootstrap/js/bootstrap.min.js'></script>"
						+ ""
					+ "</head>"
					
					+ "<body>"
						+ "<div class='container'>"
						+ "<div class='row'>"
						+ "<div class='col-lg-12 text-center'>"
						+ "<img style='margin-left:320px;' src='http://i66.tinypic.com/2eb4dgx.png\' />"
						+ "<h3 style='margin-left:305px;'>Obrigado por baixar nosso</h3>"
						+ "<h2 style='margin-left:190px; color:blue'>eBook - Gestão de Representantes Comerciais</h2>"
						+ "<img style='margin-left:280px' src='http://i65.tinypic.com/2ekjfaw.jpg' />"
						
						+ "<form method='get' action='http://simplest-marketing.s3.amazonaws.com/ebooks/livro-gestao-representantes.pdf' target='_blank'>"
						+ "<div class='form-group'>"
						+ "<div class='col-sm-offset-2 col-sm-8'>"
						+ "<button style='margin-left:305px; margin-top:50px;border-style:hidden;min-height:45px; border-radius:5px;font-family:initial;width:240px; background-color:orange; color:white ' type='submit' class='btn btn-default' >ACESSAR EBOOK</button>"
						+ "</div>"
						+ "</div>"
						+ "</form>"
						+ "</div>"
						+ "</div>"
						+ "</div>"
						+ "</body>";
		/*HTML EMAIL*/
		
		HtmlEmail email = new HtmlEmail();
		email.setSSLOnConnect(true);
		email.setHostName( "smtp.gmail.com" );
		email.setSslSmtpPort( "465" );
		email.setAuthenticator( new DefaultAuthenticator( "meuspedidos2016@gmail.com" , "meuspedidos" ) );
		try {
			EmailAttachment anexo = new EmailAttachment();
			anexo.setPath("D:/ebook.pdf"); //caminho do arquivo)
			anexo.setDisposition(EmailAttachment.ATTACHMENT);
			anexo.setDescription("Gestão de Representantes.");
			anexo.setName("ebook - Gestão de Representantes.");	
			
		    email.setFrom( "meuspedidos@gmail.com" , "Meus Pedidos");
		    email.setDebug(true); 
		    email.setSubject( "Meus Pedidos" );
		     
		    StringBuilder builder = new StringBuilder();
		    builder.append(html);
		    
		    email.setHtmlMsg(html);
		    email.addTo( emailCliente );
		    email.attach(anexo);//adiciona o arquivo/anexo.
		    email.send();
		} catch (EmailException e) {
		    e.printStackTrace();
		} 
	}
}

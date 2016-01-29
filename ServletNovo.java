package br.com.novo.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;
public class ServletNovo extends HttpServlet {
	private static final long serialVersionUID = -7327023802426117096L;
	public ServletNovo() {
        super();
    }

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
		PrintWriter out = response.getWriter();
		String context = request.getServletContext().getContextPath();
		
		String nome = request.getParameter("nome");
		String emailCliente = request.getParameter("email");
		
		Email mail = new Email();
		mail.sendEmail(nome,emailCliente);

		//response.sendRedirect(context+"/inicio.html");
		
		out.println("<html><head><title>Servlet Novo</title><head><body style=''><p align='center'><img  src='http://i66.tinypic.com/2eb4dgx.png\'></p><h1 align='center' style='margin-top:20px; color:blue'>E-mail enviado com sucesso!</h1></body></html>");
		out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
}

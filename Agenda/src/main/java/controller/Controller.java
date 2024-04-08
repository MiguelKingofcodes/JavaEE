package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Document;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;


// TODO: Auto-generated Javadoc
//import model.DAO;



/**
 * Servlet implementation class Controller.
 */
@WebServlet(urlPatterns= {"/Controller", "/main", "/Contact_List_Folder", "/Insert", "/Update", "/Delete", "/select", "/report"})
public class Controller extends HttpServlet {
	
	/** The Data access object. */
	// Instânciando DATA ACCESS OBJECT
	DAO Data_Access_Object = new DAO();
	
	/** The contato. */
	JavaBeans contato = new JavaBeans();
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * Instantiates a new controller.
     */
    public Controller() {
        super();

    }


	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		// Teste de Conexão...
		//Data_Access_Object.testeConexão();
		
		String requisicao = request.getServletPath();
		System.out.println(requisicao);
		
		if (requisicao.equals("/main")) {
			
			// request - dispatcher
			
			agenda(request, response);
			
		}else if (requisicao.equals("/Contact_List_Folder")){
			
			// Vai para a lista de contatos...
			verContato(request, response);
		
		}else if(requisicao.equals("/Insert")){
			
			// Cria um novo contato
			novoContato(request, response);
			
		}else if(requisicao.equals("/Update")){
			
			editarContato(request, response);
			
		}else if (requisicao.equals("/Delete")){
			
			deletarContato(request, response);
			
		}else if(requisicao.equals("/select")){
				
				// Cria um novo contato
			selecionarContato(request, response);
				
		}else{
			redirecionar(request, response, "index.html");
		}
		
}

	/**
	 * Redirecionar.
	 *
	 * @param request the request
	 * @param response the response
	 * @param redirect the redirect
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void redirecionar(HttpServletRequest request, HttpServletResponse response, String redirect) throws ServletException, IOException {

		response.sendRedirect(redirect);
			
	}
	
	/**
	 * Ver contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void verContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Acessa a página incial
				ArrayList<JavaBeans> lista_contatos = Data_Access_Object.listarContatos();
				
				//Encaminhamento do objeto Arraylist para o documento agenda_data.jsp
				request.setAttribute("contatos", lista_contatos);
				RequestDispatcher rd = request.getRequestDispatcher("Contact_List_Folder/List_Contact_Page.jsp");
				rd.forward(request, response);
			
	}
	
	/**
	 * Agenda.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void agenda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect("agenda_data.jsp");
	}
	
	/**
	 * Novo contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void novoContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Definir os atributos do objeto "contato"
		contato.setNome(request.getParameter("Nome"));
		contato.setPhone(request.getParameter("Phone"));
		contato.setEmail(request.getParameter("Email"));
		
		// Invocar CRUD Create (Inserir Contato) 
		Data_Access_Object.inserirContato(contato);
		response.sendRedirect("agenda_data.jsp");
	}
	
	/**
	 * Selecionar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	//Editar contato
	protected void selecionarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recebimento do id de contato que será editado...
		String idcon_value = request.getParameter("idcon");
		int idcon = Integer.parseInt(idcon_value);
		JavaBeans contato_editado = Data_Access_Object.selecaoContato(idcon);
		
		request.setAttribute("idcon", contato_editado.getIdcon());
		request.setAttribute("nome", contato_editado.getNome());
		request.setAttribute("telefone", contato_editado.getPhone());
		request.setAttribute("email", contato_editado.getEmail());
		
		RequestDispatcher rd = request.getRequestDispatcher("Editar.jsp");
		rd.forward(request, response);
		
	}
	
	/**
	 * Editar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*System.out.println(request.getParameter("idcon"));
		System.out.println(request.getParameter("Nome"));
		System.out.println(request.getParameter("Phone"));
		System.out.println(request.getParameter("Email"));*/
		
		JavaBeans contato_editado = new JavaBeans();
		
		contato_editado.setIdcon(Integer.parseInt(request.getParameter("idcon")));
		contato_editado.setNome(request.getParameter("Nome"));
		contato_editado.setPhone(request.getParameter("Phone"));
		contato_editado.setEmail(request.getParameter("Email"));
		
		Data_Access_Object.atualizarContato(contato_editado);
		
	}
	
	/**
	 * Deletar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void deletarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Data_Access_Object.deletarContato(Integer.parseInt(request.getParameter("idcon")));
		verContato(request, response);
	}
	
	// Á resolver...
	/*
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Gerando Relatório em PDF
		Document documento = new Document();
		try {
			// Tipo do conteúdo
			response.setContentType("aplication/pdf");
			// Nome do documento
			response.addHeader("Content-Disposition", "inline; filename="+"contatos.pdf");
			
			// Criar o documento
			PdfWriter.getInstance(documento, response.getOutputStream());
			// Abrir o documento => conteúdo
			documento.open();
			documento.add(new Paragraph("Lista de contatos: "));
			// Listagem de contatos
			documento.add(new Paragraph(""));
			// Criar uma tabela mo pdf...
			PdfPTable tabela = new PdfPTable(3);
			
		}catch (Exception e){
			System.out.println(e);
			documento.close();
			
		}
	}*/
}
	




package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UsuarioDTO;
import service.UsuarioService;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	
	UsuarioService serviceUsuario = new UsuarioService();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	String tipo = request.getParameter("tipo");
    	if (tipo.equals("autenticar"))
    		autenticar(request, response);
    }
    
	private void autenticar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		
		if(serviceUsuario.loginUsuario(username, password)){
			HttpSession session = request.getSession();
			UsuarioDTO usuario = serviceUsuario.buscaroUsuario(username, password);
			session.setAttribute("user", usuario);
			
			RequestDispatcher rd = request.getRequestDispatcher("app/dashboard.jsp");
	        rd.forward(request, response);
	        
			System.out.println("Logeado con exito");
		}else{
			System.out.println("Error en el inicio de sesion");
		}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

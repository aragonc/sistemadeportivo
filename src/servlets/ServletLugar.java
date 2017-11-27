package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.LugarDTO;
import service.LugarService;

/**
 * Servlet implementation class ServletLugar
 */
@WebServlet("/ServletLugar")
public class ServletLugar extends HttpServlet {
	
	LugarService lugarService = new LugarService();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLugar() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
		String tipo = request.getParameter("tipo");
		if (tipo.equals("listar"))
			listar(request, response);
		else if (tipo.equals("registrar"))
			registrar(request, response);
		else if (tipo.equals("buscar"))
			buscar(request, response);
		else if (tipo.equals("actualizar"))
			actualizar(request, response);
		else if (tipo.equals("eliminar"))
			eliminar(request, response);
		
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] dato = request.getParameterValues("cod[]");
		for(String item : dato) {
			int codigo = Integer.parseInt(item);
			lugarService.eliminarLugar(codigo);
		}
		request.getRequestDispatcher("ServletLugar?tipo=listar").forward(request, response);
		
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dato = request.getParameter("cod");
		int codigo = Integer.parseInt(dato);
		LugarDTO obj = lugarService.buscarLugar(codigo);
		request.setAttribute("registro", obj);
		request.getRequestDispatcher("app/lugar/actualizar_lugar.jsp").forward(request,
				response);
		
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		LugarDTO obj = new LugarDTO();
		
		String nombre = request.getParameter("nombre");
		String direccion = request.getParameter("direccion");
		String latitud = request.getParameter("latitud");
		String longitud = request.getParameter("longitud");
		
		obj.setNombre(nombre);
		obj.setDireccion(direccion);
		obj.setLatitud(latitud);
		obj.setLongitud(longitud);
		obj.setEstado(1);
		
		int estado = lugarService.registrarLugar(obj);
		if (estado != -1)
			listar(request, response);
		else
			response.sendRedirect("error.html");
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<LugarDTO> info = lugarService.listarLugar();
		request.setAttribute("data", info);
		request.getRequestDispatcher("app/lugar/listar_lugar.jsp").forward(request,
				response);
		
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

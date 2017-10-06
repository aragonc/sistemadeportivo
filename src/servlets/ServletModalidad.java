package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ModalidadDTO;
import service.ModalidadService;

/**
 * Servlet implementation class ServletModalidad
 */
@WebServlet("/ServletModalidad")
public class ServletModalidad extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	ModalidadService modalidadService = new ModalidadService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModalidad() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			
	    	String tipo = request.getParameter("tipo");
	    	
			if (tipo.equals("registrar"))
				registrar(request, response);
			else if (tipo.equals("buscarlista"))
				buscarLista(request, response);
			else if (tipo.equals("actualizar"))
				actualizar(request, response);
			else if (tipo.equals("buscar"))
				buscarModalidad(request, response);
			else if (tipo.equals("listar"))
				listar(request, response);
			else if (tipo.equals("eliminar"))
				eliminar(request, response);
		}
	
	private void buscarLista(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void eliminar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String dato = request.getParameter("cod");
		int codigo = Integer.parseInt(dato);
		modalidadService.eliminarModalidad(codigo);
		request.getRequestDispatcher("ServletModalidad?tipo=listar").forward(request,
				response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ModalidadDTO> info = modalidadService.listarModalidad();
		request.setAttribute("data", info);
		request.getRequestDispatcher("app/listar_modalidad.jsp").forward(request,
				response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ModalidadDTO obj = new ModalidadDTO();
		String descripcion = request.getParameter("descripcion");
		String idcategoria = request.getParameter("cbocategoria");
		String iddisciplina = request.getParameter("cbodisciplina");
		String cod = request.getParameter("codigo");
		
		obj.setCodigo(Integer.parseInt(cod));
		obj.setCodCategoria(Integer.parseInt(idcategoria));
		obj.setCodDisciplina(Integer.parseInt(iddisciplina));
		obj.setDescripcion(descripcion);
		
		int resultado = modalidadService.actualizarModalidad(obj);
		if (resultado != -1){
			listar(request, response);
		}else{
			response.sendRedirect("error.html");
		}
	}

	private void buscarModalidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dato = request.getParameter("cod");
		int codigo = Integer.parseInt(dato);
		ModalidadDTO obj = modalidadService.buscarModalidad(codigo);
		request.setAttribute("registro", obj);
		request.getRequestDispatcher("app/actualizar_modalidad.jsp").forward(request,
				response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		ModalidadDTO obj = new ModalidadDTO();
		String descripcion = request.getParameter("descripcion");
		String idcategoria = request.getParameter("cbocategoria");
		String iddisciplina = request.getParameter("cbodisciplina");
		
		obj.setCodCategoria(Integer.parseInt(idcategoria));
		obj.setCodDisciplina(Integer.parseInt(iddisciplina));
		obj.setDescripcion(descripcion);
		
		int resultado = modalidadService.registrarModalidad(obj);
		if (resultado != -1){
			listar(request, response);
		}else{
			response.sendRedirect("error.html");
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

package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CategoriaDTO;
import service.CategoriaService;


@WebServlet("/ServletCategoria")

public class ServletCategoria extends HttpServlet{
	
	CategoriaService categoriaService = new CategoriaService();
	private static final long serialVersionUID = 1L;

	public ServletCategoria() {
		super();
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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

	
	
	private void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<CategoriaDTO> info = categoriaService.listarCategoria();
		request.setAttribute("data", info);
		request.getRequestDispatcher("app/lista_categoria.jsp").forward(request,
				response);
	}

	

	private void registrar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CategoriaDTO obj = new CategoriaDTO();
		String nombre = request.getParameter("txtnombre");
		String est = request.getParameter("cboestado");
		
		obj.setNombre(nombre);
		obj.setEstado(Integer.parseInt(est));
		
		
		int estado = categoriaService.registrarCategoria(obj);
		if (estado != -1)
			listar(request, response);
		else
			response.sendRedirect("error.html");
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dato = request.getParameter("cod");
		int codigo = Integer.parseInt(dato);
		CategoriaDTO x = categoriaService.buscarCategoria(codigo);
		request.setAttribute("registro", x);
		request.getRequestDispatcher("app/actualizar_categoria.jsp").forward(request,
				response);
		//System.out.println(baseURL);
	}
	
	private void actualizar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CategoriaDTO obj = new CategoriaDTO();
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("txtnombre");
		String est = request.getParameter("cboestado");
		
		obj.setNombre(nombre);
		obj.setCodigo(Integer.parseInt(codigo));
		obj.setEstado(Integer.parseInt(est));
		
		int estado = categoriaService.actualizarCategoria(obj);
		System.out.println(estado);
		if (estado != -1)
			listar(request, response);
		else
			response.sendRedirect("error.html");
	}

	private void eliminar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String[] dato = request.getParameterValues("cod[]");
		for(String item : dato) {
			int codigo = Integer.parseInt(item);
			categoriaService.eliminarCategoria(codigo);
		}
		request.getRequestDispatcher("ServletCategoria?tipo=listar").forward(request,
				response);
	}

}

package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import beans.EquipoDTO;

import service.EquipoService;

@WebServlet("/ServletEquipo")

public class ServletEquipo extends HttpServlet{
	
	EquipoService equipoService = new EquipoService();
	private static final long serialVersionUID = 1L;

	public ServletEquipo() {
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
		List<EquipoDTO> info = equipoService.listarEquipo();
		request.setAttribute("data", info);
		request.getRequestDispatcher("app/equipo/listar_equipo.jsp").forward(request,
				response);
	}

	private void registrar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		EquipoDTO obj = new EquipoDTO();
		String nombre = request.getParameter("nombre");
		String logo = request.getParameter("logotipo");
		String email = request.getParameter("email");
		String fono = request.getParameter("fono");
		String disciplina = request.getParameter("disciplina");
		String categoria = request.getParameter("categoria");
		String color = request.getParameter("color");
		String est = request.getParameter("estado");
		
				
		obj.setNombre(nombre);
		obj.setLogo(logo);
		obj.setEmail(email);
		obj.setFono(fono);
		obj.setColor(color);
		obj.setIddisciplina(Integer.parseInt(disciplina));
		obj.setIdcategoria(Integer.parseInt(categoria));
		obj.setEstado(Integer.parseInt(est));
				
		int estado = equipoService.registrarEquipo(obj);
		if (estado != -1)
			listar(request, response);
		else
			response.sendRedirect("error.html");
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dato = request.getParameter("cod");
		int codigo = Integer.parseInt(dato);
		EquipoDTO x = equipoService.buscarEquipo(codigo);
		request.setAttribute("registro", x);
		request.getRequestDispatcher("actualizarEquipo.jsp").forward(request,
				response);
	}
	
	private void actualizar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		EquipoDTO obj = new EquipoDTO();
		String codigo = request.getParameter("txt_codigo");
		String nombre = request.getParameter("nombre");
		String logo = request.getParameter("logotipo");
		String email = request.getParameter("email");
		String fono = request.getParameter("fono");
		String disciplina = request.getParameter("disciplina");
		String categoria = request.getParameter("categoria");
		String color = request.getParameter("color");
		String est = request.getParameter("estado");
		
		obj.setCodigo(Integer.parseInt(codigo));
		obj.setNombre(nombre);
		obj.setLogo(logo);
		obj.setColor(color);
		obj.setIddisciplina(Integer.parseInt(disciplina));
		obj.setIdcategoria(Integer.parseInt(categoria));
		obj.setEmail(email);
		obj.setFono(fono);
		obj.setEstado(Integer.parseInt(est));
		int estado = equipoService.actualizarEquipo(obj);
		if (estado != -1)
			listar(request, response);
		else
			response.sendRedirect("error.html");
	}

	private void eliminar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String dato = request.getParameter("cod");
		int codigo = Integer.parseInt(dato);
		equipoService.eliminarEquipo(codigo);
		request.getRequestDispatcher("ServletEquipo?tipo=listar").forward(request,
				response);
	}

}

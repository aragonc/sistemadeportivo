package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import beans.DisciplinaDTO;

import service.DisciplinaService;

@WebServlet("/ServletDisciplina")

public class ServletDisciplina extends HttpServlet{
	
	DisciplinaService disciplinaService = new DisciplinaService();
	private static final long serialVersionUID = 1L;

	public ServletDisciplina() {
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
		List<DisciplinaDTO> info = disciplinaService.listarDisciplina();
		request.setAttribute("data", info);
		request.getRequestDispatcher("listarDisciplina.jsp").forward(request,
				response);
	}

	

	private void registrar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DisciplinaDTO obj = new DisciplinaDTO();
		request.getRequestDispatcher("app/registrar_disciplina.jsp").forward(request,
				response);
		String nombre = request.getParameter("txt_nombre");
		String est = request.getParameter("cbo_estado");
		
				
		obj.setNombre(nombre);		
		obj.setEstado(Integer.parseInt(est));
		
		
		int estado = disciplinaService.registrarDisciplina(obj);
		if (estado != -1)
			listar(request, response);
		else
			response.sendRedirect("error.html");
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dato = request.getParameter("cod");
		int codigo = Integer.parseInt(dato);
		DisciplinaDTO x = disciplinaService.buscarDisciplina(codigo);
		request.setAttribute("registro", x);
		request.getRequestDispatcher("actualizarDisciplina.jsp").forward(request,
				response);
	}
	
	private void actualizar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DisciplinaDTO obj = new DisciplinaDTO();
		String cod = request.getParameter("txt_codigo");
		String nombre = request.getParameter("txt_nombre");		
		String est = request.getParameter("cbo_estado");
		
		obj.setCodigo(Integer.parseInt(cod));		
		obj.setNombre(nombre);
		obj.setEstado(Integer.parseInt(est));
		
		int estado = disciplinaService.actualizarDisciplina(obj);
		if (estado != -1)
			listar(request, response);
		else
			response.sendRedirect("error.html");
	}

	private void eliminar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String dato = request.getParameter("cod");
		int codigo = Integer.parseInt(dato);
		disciplinaService.eliminarDisciplina(codigo);
		request.getRequestDispatcher("ServletDisciplina?tipo=listar").forward(request,
				response);
	}

}

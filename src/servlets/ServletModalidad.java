package servlets;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.ModalidadDTO;
import service.AjaxService;
import service.ModalidadService;

/**
 * Servlet implementation class ServletModalidad
 */
@WebServlet("/ServletModalidad")
public class ServletModalidad extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	AjaxService ajaxService = new AjaxService();
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
		
		String[] dato = request.getParameterValues("cod[]");
		
		for(String item : dato) {
			int codigo = Integer.parseInt(item);
			modalidadService.eliminarModalidad(codigo);
		}
		request.getRequestDispatcher("ServletModalidad?tipo=listar").forward(request,
				response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ModalidadDTO> info = modalidadService.listarModalidad();
		request.setAttribute("data", info);
		request.getRequestDispatcher("app/modalidad/listar_modalidad.jsp").forward(request,
				response);
	}
	
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ModalidadDTO obj = new ModalidadDTO();
		String codigo = request.getParameter("codigo");
		String descripcion = request.getParameter("descripcion");
		String idcategoria = request.getParameter("cbocategoria");		
		String iddisciplina = request.getParameter("cbodisciplina");
		String cantidad = request.getParameter("cantidad");
		String nvarones = request.getParameter("varones");
		String nmujeres = request.getParameter("mujeres");
		String genero = request.getParameter("genero");
		String validaciones = "";
		
		ModalidadDTO x = modalidadService.buscarModalidad(Integer.parseInt(codigo));
		
		if(idcategoria.equals("") && iddisciplina.equals("")) {
			request.setAttribute("registro", x);
            validaciones = "Debe seleccionar obligatoriamente una categoría y una disciplina";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/modalidad/actualizar_modalidad.jsp").forward(request, response);
        }
		
		else if(idcategoria.equals("")) {
			request.setAttribute("registro", x);
            validaciones = "Debe seleccionar una categoría";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/modalidad/actualizar_modalidad.jsp").forward(request, response);
        }
		
		else if(iddisciplina.equals("")) {
			request.setAttribute("registro", x);
            validaciones = "Debe seleccionar una disciplina";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/modalidad/actualizar_modalidad.jsp").forward(request, response);
        }
		
		else if(cantidad.replaceAll(" ", "").equals("")) {
			request.setAttribute("registro", x);
            validaciones = "El campo N° Jugadores no puede estar vacío";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/modalidad/actualizar_modalidad.jsp").forward(request, response);
        }
		
		else if(!(cantidad.matches("[0-9]*"))) {
			request.setAttribute("registro", x);
            validaciones = "Solo debe ingresar carácteres numéricos en el campo N° Jugadores";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/modalidad/actualizar_modalidad.jsp").forward(request, response);
        }
		
		else if(!(nvarones.matches("[0-9]*"))) {
			request.setAttribute("registro", x);
            validaciones = "Solo debe ingresar carácteres numéricos en el campo N° Varones";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/modalidad/actualizar_modalidad.jsp").forward(request, response);
        }
		
		else if(!(nmujeres.matches("[0-9]*"))) {
			request.setAttribute("registro", x);
            validaciones = "Solo debe ingresar carácteres numéricos en el campo N° Mujeres";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/modalidad/actualizar_modalidad.jsp").forward(request, response);
        }
		
		else if(request.getParameter("cantidad") != null){
			cantidad = request.getParameter("cantidad");
			obj.setNumJugadores(Integer.parseInt(cantidad));
			
		}
		

		if(request.getParameter("varones") != null && request.getParameter("mujeres") != null){
			nvarones = request.getParameter("varones");
			nmujeres = request.getParameter("mujeres");
			
			if(genero.trim().equals("V")){
				obj.setNumVarones(Integer.parseInt(cantidad));
			} else if(nvarones!=null && !(nvarones.trim().equals(""))){
				obj.setNumVarones(Integer.parseInt(nvarones));
			} else {
				obj.setNumVarones(0);
			}
			if(genero.trim().equals("M")){
				obj.setNumMujeres(Integer.parseInt(cantidad));
			} else if(nmujeres!=null && !(nmujeres.trim().equals(""))){
				obj.setNumMujeres(Integer.parseInt(nmujeres));
			} else {
				obj.setNumMujeres(0);
			}
			
		}
		int total = obj.getNumMujeres() + obj.getNumVarones();
		
		
		if(!(obj.getNumJugadores() == total)){
			request.setAttribute("registro", x);
			validaciones = "La cantidad de varones y mujeres no coincide con la cantidad total de jugadores";
			request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/modalidad/actualizar_modalidad.jsp").forward(request, response);
		}
		
		if(obj.getNumJugadores() == total){
			obj.setCodCategoria(Integer.parseInt(idcategoria));
			obj.setCodDisciplina(Integer.parseInt(iddisciplina));
			obj.setGenero(genero);
			obj.setDescripcion(descripcion);
			obj.setCodigo(Integer.parseInt(codigo));
			int resultado = modalidadService.actualizarModalidad(obj);
			if (resultado != -1){
				listar(request, response);
			}
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
		request.getRequestDispatcher("app/modalidad/actualizar_modalidad.jsp").forward(request,
				response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub		
		ModalidadDTO obj = new ModalidadDTO();
		String descripcion = request.getParameter("descripcion");
		String idcategoria = request.getParameter("cbocategoria");		
		String iddisciplina = request.getParameter("cbodisciplina");
		String cantidad = request.getParameter("cantidad");
		String nvarones = request.getParameter("varones");
		String nmujeres = request.getParameter("mujeres");
		String genero = request.getParameter("genero");
		String validaciones = "";
		
		if(idcategoria.equals("") && iddisciplina.equals("")) {
            validaciones = "Debe seleccionar obligatoriamente una categoría y una disciplina";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/modalidad/registrar_modalidad.jsp").forward(request, response);
        }
		
		else if(idcategoria.equals("")) {
            validaciones = "Debe seleccionar una categoría";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/modalidad/registrar_modalidad.jsp").forward(request, response);
        }
		
		else if(iddisciplina.equals("")) {
            validaciones = "Debe seleccionar una disciplina";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/modalidad/registrar_modalidad.jsp").forward(request, response);
        }
		
		else if(cantidad.replaceAll(" ", "").equals("")) {
            validaciones = "El campo N° Jugadores no puede estar vacío";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/modalidad/registrar_modalidad.jsp").forward(request, response);
        }
		
		int categoria = Integer.parseInt(idcategoria);
		int disciplina = Integer.parseInt(iddisciplina);
		
		boolean count = ajaxService.mismaModalidad("modalidad", categoria, disciplina,genero);
		
		if(count==true) {
    		validaciones = "La modalidad que ha seleccionado ya existe"; 
    		request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/modalidad/registrar_modalidad.jsp").forward(request, response);
        }
		
		
		
		
		else if(!(cantidad.matches("[0-9]*"))) {
            validaciones = "Solo debe ingresar carácteres numéricos en el campo N° Jugadores";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/modalidad/registrar_modalidad.jsp").forward(request, response);
        }
		
		else if(!(nvarones.matches("[0-9]*"))) {
            validaciones = "Solo debe ingresar carácteres numéricos en el campo N° Varones";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/modalidad/registrar_modalidad.jsp").forward(request, response);
        }
		
		else if(!(nmujeres.matches("[0-9]*"))) {
            validaciones = "Solo debe ingresar carácteres numéricos en el campo N° Mujeres";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/modalidad/registrar_modalidad.jsp").forward(request, response);
        }
		
		else if(request.getParameter("cantidad") != null){
			cantidad = request.getParameter("cantidad");
			obj.setNumJugadores(Integer.parseInt(cantidad));
			
		}
		

		if(request.getParameter("varones") != null && request.getParameter("mujeres") != null){
			nvarones = request.getParameter("varones");
			nmujeres = request.getParameter("mujeres");
			
			if(genero.trim().equals("V")){
				obj.setNumVarones(Integer.parseInt(cantidad));
			} else if(nvarones!=null && !(nvarones.trim().equals(""))){
				obj.setNumVarones(Integer.parseInt(nvarones));
			} else {
				obj.setNumVarones(0);
			}
			if(genero.trim().equals("M")){
				obj.setNumMujeres(Integer.parseInt(cantidad));
			} else if(nmujeres!=null && !(nmujeres.trim().equals(""))){
				obj.setNumMujeres(Integer.parseInt(nmujeres));
			} else {
				obj.setNumMujeres(0);
			}
			
		}
		int total = obj.getNumMujeres() + obj.getNumVarones();
		
		
		if(!(obj.getNumJugadores() == total)){
			validaciones = "La cantidad de varones y mujeres no coincide con la cantidad total de jugadores";
			request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/modalidad/registrar_modalidad.jsp").forward(request, response);
		}
		
		if(obj.getNumJugadores() == total){
			obj.setCodCategoria(Integer.parseInt(idcategoria));
			obj.setCodDisciplina(Integer.parseInt(iddisciplina));
			obj.setGenero(genero);
			obj.setDescripcion(descripcion);
			int resultado = modalidadService.registrarModalidad(obj);
			if (resultado != -1){
				listar(request, response);
			}
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

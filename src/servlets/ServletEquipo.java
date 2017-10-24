package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.EquipoDTO;

import beans.PersonaDTO;
import service.AjaxService;
import service.EquipoService;
import service.PersonaService;

@WebServlet("/ServletEquipo")

public class ServletEquipo extends HttpServlet{
	
	AjaxService ajaxService = new AjaxService();
	EquipoService equipoService = new EquipoService();
	PersonaService personaService = new PersonaService();
	
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
		else if (tipo.equals("listaPersona"))
			listaPersona(request, response);
		else if (tipo.equals("suscribirPersona"))
			suscribirPersona(request, response);
		else if (tipo.equals("detalle"))
			detalle(request, response);
		else if (tipo.equals("agregar"))
			agregar(request, response);
		
	}
	private void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("app/equipo/registrar_equipo.jsp").forward(request,
				response);
		
	}

	private void detalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dato = request.getParameter("cod");
		int codigo = Integer.parseInt(dato);
		EquipoDTO obj = equipoService.buscarEquipo(codigo);
		request.setAttribute("registro", obj);
		request.getRequestDispatcher("app/equipo/detalle_equipo.jsp").forward(request,
				response);
		
	}

	private void suscribirPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String codequipo = request.getParameter("evento");
		 String[] codjugador = request.getParameterValues("jugador[]");
		 
		 for(String item : codjugador){
			 System.out.println(item);
			 equipoService.agregarPersona(Integer.parseInt(codequipo), Integer.parseInt(item));
		 }
		 listar(request, response);
	}

	private void listaPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PersonaDTO> info = personaService.listarPersona();
		request.setAttribute("data", info);
		request.getRequestDispatcher("app/equipo/suscribir_persona.jsp").forward(request,response);
		
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
		String evento = request.getParameter("cboEvento");
		String modalidad = request.getParameter("cboMod");
		String color = request.getParameter("color");
		String descripcion = request.getParameter("descripcion");
		String estado = request.getParameter("estado");
		String validaciones = "";
		
		int ev = Integer.parseInt(evento);
		boolean count = ajaxService.mismoEquipoEvento("equipo",nombre,ev);
		
		int mod = Integer.parseInt(modalidad);
		
		boolean count1 = ajaxService.mismoEquipoModalidad("equipo",nombre,mod);
		
		if(nombre.replaceAll(" ", "").equals("")) {
            validaciones = "Es necesario ingresar un nombre al equipo";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/registrar_equipo.jsp").forward(request, response);
        }
		else if(email.replaceAll(" ", "").equals("")) {
            validaciones = "El campo Email está vacío";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/registrar_equipo.jsp").forward(request, response);
        }
		else if(evento.equals("")) {
            validaciones = "Debe seleccionar un evento";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/registrar_equipo.jsp").forward(request, response);
        }
		else if(modalidad.equals("")) {
            validaciones = "Debe seleccionar una modalidad";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/registrar_equipo.jsp").forward(request, response);
        }
		else if(fono.replaceAll(" ", "").equals("")) {
            validaciones = "El campo Teléfono esta vacío";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/registrar_equipo.jsp").forward(request, response);
        }
		else if(color.replaceAll(" ", "").equals("")) {
            validaciones = "El campo Color esta vacío";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/registrar_equipo.jsp").forward(request, response);
        }
		else if(!(nombre.matches("[a-zA-Z 0-9]*"))) {
            validaciones = "Ingrese un nombre válido";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/registrar_equipo.jsp").forward(request, response);
        }
		else if(!(fono.matches("[0-9]*"))) {
            validaciones = "Ingrese un teléfono válido";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/registrar_equipo.jsp").forward(request, response);
        }
		else if(!(fono.length() == 7) && !(fono.length() == 9)) {
            validaciones = "El teléfono solo debe tener 7 o 9 dígitos";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/registrar_equipo.jsp").forward(request, response);
        }
				
		else if(!(email.matches("[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})"))) {
            validaciones = "Ingrese un email válido";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/registrar_equipo.jsp").forward(request, response);
        }
		
		else if(!(color.matches("[a-zA-Z]*"))) {
            validaciones = "Ingrese un color válido";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/registrar_equipo.jsp").forward(request, response);
        }
		
		else if(count==true) {
    		validaciones = "Ya existe un equipo con el mismo nombre en el evento seleccionado"; 
    		request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/registrar_equipo.jsp").forward(request, response);
        }
		
		else if(count1==true) {
	    		validaciones = "El equipo que está registrando ya existe en la modalidad seleccionada"; 
	    		request.setAttribute("validaciones", validaciones);
	            request.getRequestDispatcher("app/equipo/registrar_equipo.jsp").forward(request, response);
	    }
		else{	
			
		obj.setNombre(nombre);
		obj.setLogo(logo);
		obj.setEmail(email);
		obj.setFono(fono);
		obj.setColor(color);
		obj.setCodEvento(Integer.parseInt(evento));
		obj.setCodModalidad(Integer.parseInt(modalidad));
		obj.setEstado(Integer.parseInt(estado));
		obj.setDescripcion(descripcion);
				
		int codequipo = equipoService.registrarEquipo(obj);
		System.out.println("Equipo: " + codequipo);
		if (codequipo != -1){
			//Para agregar al equipo al evento a participar
			equipoService.agregarEquipoEvento(codequipo, obj.getCodEvento());
			//Enviamos los datos para registrar jugadores.
			request.setAttribute("nomequipo", obj.getNombre());
			request.setAttribute("codequipo", codequipo+"");
			listaPersona(request, response);
		} else {
			response.sendRedirect("error.html");
		}
		}
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dato = request.getParameter("cod");
		int codigo = Integer.parseInt(dato);
		EquipoDTO obj = equipoService.buscarEquipo(codigo);
		request.setAttribute("registro", obj);
		request.getRequestDispatcher("app/equipo/actualizar_equipo.jsp").forward(request,
				response);
	}
	
	private void actualizar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		EquipoDTO obj = new EquipoDTO();
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		String logo = request.getParameter("logotipo");
		String email = request.getParameter("email");
		String fono = request.getParameter("fono");
		String evento = request.getParameter("evento");
		String modalidad = request.getParameter("modalidad");
		String color = request.getParameter("color");
		String descripcion = request.getParameter("descripcion");
		String estado = request.getParameter("estado");
		
		obj.setCodigo(Integer.parseInt(codigo));
		obj.setNombre(nombre);
		obj.setLogo(logo);
		obj.setEmail(email);
		obj.setFono(fono);
		obj.setColor(color);
		obj.setCodEvento(Integer.parseInt(evento));
		obj.setCodModalidad(Integer.parseInt(modalidad));
		obj.setEstado(Integer.parseInt(estado));
		obj.setDescripcion(descripcion);
		
		int resultado = equipoService.actualizarEquipo(obj);
		if (resultado != -1)
			listar(request, response);
		else
			response.sendRedirect("error.html");
	}

	private void eliminar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String[] dato = request.getParameterValues("cod[]");
		for(String item : dato){
			int codigo = Integer.parseInt(item);
			equipoService.eliminarEquipo(codigo);
		}
		
		request.getRequestDispatcher("ServletEquipo?tipo=listar").forward(request,
				response);
	}

}

package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ComboDTO;
import beans.EquipoDTO;
import beans.EventoDTO;
import beans.ModalidadDTO;
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
		System.out.println(dato);
		EquipoDTO obj = equipoService.buscarEquipo(Integer.parseInt(dato));
		request.setAttribute("equipo", obj);
		request.getRequestDispatcher("app/equipo/detalle_equipo.jsp").forward(request,
				response);
		
	}

	private void suscribirPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String codequipo = request.getParameter("evento");
		 String[] codjugador = request.getParameterValues("jugador[]");
		 
		 for(String item : codjugador){
			 //System.out.println(item);
			 equipoService.agregarPersona(Integer.parseInt(codequipo), Integer.parseInt(item));
		 }
		 listar(request, response);
	}

	private void listaPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idequipo = request.getParameter("codequipo");
		String genero = request.getParameter("genero");
			
		List<PersonaDTO> info = null;
		if(Integer.parseInt(genero)!=3) {
			info = personaService.listarPersonaSexo(Integer.parseInt(genero));
		}else {
			info = personaService.listarPersona();
		}
		EquipoDTO equipo = equipoService.buscarEquipo(Integer.parseInt(idequipo));
		request.setAttribute("data", info);
		request.setAttribute("equipo", equipo);
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
		//String logo = request.getParameter("logotipo");
		String idevento = request.getParameter("evento");
		String idmodalidad = request.getParameter("modalidad");
		String color = request.getParameter("color");
		String descripcion = request.getParameter("descripcion");
		String estado = request.getParameter("estado");
		String iddelegado = request.getParameter("delegado");
		
		
		String validaciones = "";
		
		obj.setNombre(nombre);
		obj.setDescripcion(descripcion);
		obj.setColor(color);
		obj.setLogo(null);
		EventoDTO evento = new EventoDTO();
			evento.setCodigo(Integer.parseInt(idevento));
			obj.setEvento(evento);
		ModalidadDTO modalidad = new ModalidadDTO();
			modalidad.setCodigo(Integer.parseInt(idmodalidad));
			obj.setModalidad(modalidad);
		PersonaDTO delegado = new PersonaDTO();
			delegado.setCodigo(Integer.parseInt(iddelegado));
		obj.setDelegado(delegado);
		obj.setEstado(Integer.parseInt(estado));
		
		boolean count = ajaxService.mismoEquipoEvento("equipo",nombre,obj.getEvento().getCodigo());
		
		
		if(nombre.replaceAll(" ", "").equals("")) {
            validaciones = "Es necesario ingresar un nombre al equipo";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/registrar_equipo.jsp").forward(request, response);
        }
		else if(obj.getEvento().getCodigo() == 0) {
            validaciones = "Debe seleccionar un evento";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/registrar_equipo.jsp").forward(request, response);
        }
		else if(obj.getModalidad().getCodigo() == 0) {
            validaciones = "Debe seleccionar una modalidad";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/registrar_equipo.jsp").forward(request, response);
        }

		else if(color.replaceAll(" ", "").equals("")) {
            validaciones = "El campo Color esta vacio";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/registrar_equipo.jsp").forward(request, response);
        }
		else if(!(nombre.matches("[A-Za-z—Ò·ÈÌÛ˙¡…Õ”⁄ 0-9]*"))) {
            validaciones = "Ingrese un nombre valido";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/registrar_equipo.jsp").forward(request, response);
        }
				
		else if(!(color.matches("[A-Za-z—Ò·ÈÌÛ˙¡…Õ”⁄ ]*"))) {
            validaciones = "Ingrese un color valido";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/registrar_equipo.jsp").forward(request, response);
        }
		
		else if(count==true) {
    		validaciones = "Ya existe un equipo con el mismo nombre en el evento seleccionado"; 
    		request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/registrar_equipo.jsp").forward(request, response);
        }
		else{	
			
			int codequipo = equipoService.registrarEquipo(obj);
			
			if (codequipo != -1){
				
				equipoService.agregarEquipoEvento(codequipo, obj.getEvento().getCodigo());
				int genero = equipoService.buscarGenero(codequipo);
				
				response.sendRedirect("ServletEquipo?tipo=listaPersona&genero="+genero+"&codequipo="+codequipo);

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
		List<ModalidadDTO> lista = ajaxService.listarModalidadEvento(obj.getEvento().getCodigo());
		List<ComboDTO> data = new ArrayList<ComboDTO>();
		String genero = null;
		ComboDTO a = null;
		for(ModalidadDTO item : lista) {
			a = new ComboDTO();
			if(item.getGenero() == 1) {
				genero = "Varones";
			} else if (item.getGenero() == 2) {
				genero = "Mujeres";
			} else {
				genero = "Mixto";
			}
			a.setValor(item.getDisciplina().getNombre() + " " + item.getCategoria().getNombre() + " - " + genero + " (" + item.getNumJugadores() + ")" );
			a.setField(item.getCodigo()+"");
			data.add(a);
		}
		request.setAttribute("registro", obj);
		request.setAttribute("modalidad", data);
		request.getRequestDispatcher("app/equipo/actualizar_equipo.jsp").forward(request,
				response);
	}
	
	
	
	
	private void actualizar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		EquipoDTO obj = new EquipoDTO();
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		//String logo = request.getParameter("logotipo");
		String idevento = request.getParameter("evento");
		String idmodalidad = request.getParameter("modalidad");
		String color = request.getParameter("color");
		String descripcion = request.getParameter("descripcion");
		String estado = request.getParameter("estado");
		String iddelegado = request.getParameter("delegado");
		
		String validaciones = "";
		
		obj.setCodigo(Integer.parseInt(codigo));
		obj.setNombre(nombre);
		obj.setDescripcion(descripcion);
		obj.setColor(color);
		obj.setLogo(null);
		EventoDTO evento = new EventoDTO();
			evento.setCodigo(Integer.parseInt(idevento));
			obj.setEvento(evento);
		ModalidadDTO modalidad = new ModalidadDTO();
			modalidad.setCodigo(Integer.parseInt(idmodalidad));
			obj.setModalidad(modalidad);
		PersonaDTO delegado = new PersonaDTO();
			delegado.setCodigo(Integer.parseInt(iddelegado));
		obj.setDelegado(delegado);
		obj.setEstado(Integer.parseInt(estado));
			
		EquipoDTO x = equipoService.buscarEquipo(obj.getCodigo());
	
		if(nombre.replaceAll(" ", "").equals("")) {
			request.setAttribute("registro", x);
            validaciones = "Es necesario ingresar un nombre al equipo";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/actualizar_equipo.jsp").forward(request, response);
        }
		else if(obj.getEvento().getCodigo() == 0) {
			request.setAttribute("registro", x);
            validaciones = "Debe seleccionar un evento";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/actualizar_equipo.jsp").forward(request, response);
        }
		else if(obj.getModalidad().getCodigo() == 0) {
			request.setAttribute("registro", x);
            validaciones = "Debe seleccionar una modalidad";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/actualizar_equipo.jsp").forward(request, response);
        }
		else if(color.replaceAll(" ", "").equals("")) {
			request.setAttribute("registro", x);
            validaciones = "El campo no debe estar vacio";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/actualizar_equipo.jsp").forward(request, response);
        }
		else if(!(nombre.matches("[A-Za-z—Ò·ÈÌÛ˙¡…Õ”⁄ 0-9]*"))) {
			request.setAttribute("registro", x);
            validaciones = "Ingrese un nombre valido";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/actualizar_equipo.jsp").forward(request, response);
        }
				
		else if(!(color.matches("[ A-Za-z—Ò·ÈÌÛ˙¡…Õ”⁄]*"))) {
			request.setAttribute("registro", x);
            validaciones = "Ingrese un color v·lido";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/equipo/actualizar_equipo.jsp").forward(request, response);
        }
		else{	

			int codequipo = equipoService.actualizarEquipo(obj);
			if (codequipo != -1){
				listar(request, response);
			} else {
				response.sendRedirect("error.html");
			}
		}
	}

	private void eliminar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String[] dato = request.getParameterValues("cod[]");
		
		for(String item : dato){
			equipoService.eliminarEquipoEvento(Integer.parseInt(item));
			equipoService.eliminarEquipoPersona(Integer.parseInt(item));
			equipoService.eliminarEquipo(Integer.parseInt(item));
		}
		
		request.getRequestDispatcher("ServletEquipo?tipo=listar").forward(request,
				response);
	}

}

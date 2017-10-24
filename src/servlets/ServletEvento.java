package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.EventoDTO;
import beans.ModalidadDTO;
import service.AjaxService;
import service.EventoService;
import service.ModalidadService;

@WebServlet("/ServletEvento")
public class ServletEvento extends HttpServlet {
	
	EventoService eventoService = new EventoService();
	AjaxService ajaxService = new AjaxService();
	ModalidadService modalidadService = new ModalidadService();
	
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
    	String tipo = request.getParameter("tipo");

		if (tipo.equals("registrar"))
			registrar(request, response);
		else if (tipo.equals("buscarEventos"))
			buscarEventos(request, response);
		else if (tipo.equals("actualizar"))
			actualizar(request, response);
		else if (tipo.equals("buscar"))
			buscar(request, response);
		else if (tipo.equals("detalle"))
			detalle(request, response);
		else if (tipo.equals("listar"))
			listar(request, response);
		else if (tipo.equals("eliminar"))
			eliminar(request, response);
		else if (tipo.equals("agregar"))
			formRegistro(request, response);
		else if (tipo.equals("listaModalidad"))
			listaModalidad(request, response);
		else if (tipo.equals("suscribirModalidad"))
			suscribirModalidad(request, response);
		
		
	}
	
	private void detalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dato = request.getParameter("cod");
		int codigo = Integer.parseInt(dato);
		EventoDTO obj = eventoService.buscarEvento(codigo);
		request.setAttribute("registro", obj);
		request.getRequestDispatcher("app/evento/detalle_evento.jsp").forward(request,
				response);
		
	}

	private void suscribirModalidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String codevento = request.getParameter("codevento");
		 String[] codmodalidad = request.getParameterValues("modalidad[]");
		 
		 for(String item : codmodalidad){
			 eventoService.agregarModalidad(Integer.parseInt(codevento), Integer.parseInt(item));
		 }

		 listar(request, response);
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dato = request.getParameter("cod");
		int codigo = Integer.parseInt(dato);
		EventoDTO obj = eventoService.buscarEvento(codigo);
		request.setAttribute("registro", obj);
		request.getRequestDispatcher("app/evento/actualizar_evento.jsp").forward(request,
				response);
		
	}

	private void listaModalidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<ModalidadDTO> info = modalidadService.listarModalidad();
		request.setAttribute("data", info);
		request.getRequestDispatcher("app/modalidad/suscribir_modalidad.jsp").forward(request,response);
	}

	private void eliminar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			String[] dato = request.getParameterValues("cod[]");
			
			for(String item : dato){
				
				eventoService.eliminarEventoModalidad(Integer.parseInt(item));
				eventoService.eliminarEvento(Integer.parseInt(item));
			}
			
			request.getRequestDispatcher("ServletEvento?tipo=listar").forward(request,
					response);
		}

    private void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<EventoDTO> info = eventoService.listarEvento();
		
		request.setAttribute("data", info);
		request.getRequestDispatcher("app/evento/listar_evento.jsp").forward(request,
				response);
	}
    
    private void formRegistro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request,
				response);
	}
    
    
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EventoDTO obj = new EventoDTO();
		String cod = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String fechainicio = request.getParameter("fechainicio");
		String fechafin = request.getParameter("fechafin");
		String costo = request.getParameter("costo");
		String lugar = request.getParameter("cbougar");
		String gratuito = request.getParameter("gratuito");
		String estado = request.getParameter("estado");
		String validaciones = "";
		
		EventoDTO x = eventoService.buscarEvento(Integer.parseInt(cod));
		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date hoy = new Date();
		
		Date dateinicio = null;
		
		Date datefin = null;
		
					
		if(fechainicio!=null && !fechainicio.trim().equals("")){
		
			try {
				dateinicio = sdf.parse(fechainicio);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			obj.setFechaInicio(dateinicio);
		}
		
		if(fechafin!=null && !fechafin.trim().equals("")){
		
			try {
				datefin = sdf.parse(fechafin);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			obj.setFechaFin(datefin);
		}
		int codlugar = Integer.parseInt(lugar);
		boolean count = ajaxService.mismoNombre("evento",nombre);
		boolean count1 = ajaxService.mismoEvento("evento", dateinicio,codlugar);
				
		if(nombre.replaceAll(" ", "").equals("")) {
			request.setAttribute("registro", x);
            validaciones = "El campo Titulo de Evento no puede estar vacío";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/actualizar_evento.jsp").forward(request, response);
        }
		
		else if(!(nombre.matches("[a-zA-Z 0-9]*"))) {
			request.setAttribute("registro", x);
            validaciones = "Ingrese un título de evento válido";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/actualizar_evento.jsp").forward(request, response);
        }
		
		
		
		else if(count==true) {
    		validaciones = "Ya existe un evento con el mismo nombre"; 
    		request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/actualizar_evento.jsp").forward(request, response);
        }
		
		else if(lugar.equals("")) {
			request.setAttribute("registro", x);
            validaciones = "Debe seleccionar un lugar";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/actualizar_evento.jsp").forward(request, response);
        }
		
		else if(fechainicio.replaceAll(" ", "").equals("")) {
			request.setAttribute("registro", x);
            validaciones = "No ha seleccionado una fecha de inicio";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/actualizar_evento.jsp").forward(request, response);
        }
		
		else if(dateinicio.before(hoy)) {
			request.setAttribute("registro", x);
            validaciones = "La fecha de inicio no puede ser menor a la de hoy";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/actualizar_evento.jsp").forward(request, response);
        }
		
		else if(dateinicio.equals(hoy)) {
			request.setAttribute("registro", x);
            validaciones = "No puede crear un evento con la fecha de hoy";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/actualizar_evento.jsp").forward(request, response);
        }
				
		else if(fechafin.replaceAll(" ", "").equals("")) {
			request.setAttribute("registro", x);
            validaciones = "No ha seleccionado una fecha de finalización";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/actualizar_evento.jsp").forward(request, response);
        }
		
		else if(datefin.before(dateinicio)) {
			request.setAttribute("registro", x);
            validaciones = "La fecha de finalización no puede ser antes que la fecha de inicio";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/actualizar_evento.jsp").forward(request, response);
        }
		
		else if(datefin.compareTo(dateinicio) < 1) {
			request.setAttribute("registro", x);
            validaciones = "La hora de finalización no puede empezar antes que la hora de inicio";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/actualizar_evento.jsp").forward(request, response);
        }
		
		else if(dateinicio.equals(datefin)) {
			request.setAttribute("registro", x);
            validaciones = "La hora de inicio no puede ser igual a la hora de finalizacion";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/actualizar_evento.jsp").forward(request, response);
        }
		
		
		else if(count1==true) {
			request.setAttribute("registro", x);
    		validaciones = "Ya existe un evento con el mismo lugar y fecha ingresada"; 
    		request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/actualizar_evento.jsp").forward(request, response);
        }
				
		else if(!(costo.matches("[0-9]*[.][0.9]*"))) {
			request.setAttribute("registro", x);
            validaciones = "Ingrese un monto válido";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/actualizar_evento.jsp").forward(request, response);
        }
		
		else{
		obj.setNombre(nombre);
		obj.setDescripcion(descripcion);
		obj.setGratuito(Integer.parseInt(gratuito));
		obj.setPrecio(Double.parseDouble(costo));
		obj.setEstado(Integer.parseInt(estado));
		obj.setCodlugar(Integer.parseInt(lugar));
		obj.setCodigo(Integer.parseInt(cod));
		
		int resultado = eventoService.actualizarEvento(obj);
		if (resultado != -1){
			request.setAttribute("nomevento", obj.getNombre());
			request.setAttribute("codevento", resultado+"");
			listaModalidad(request, response);
		}else{
			response.sendRedirect("error.html");
		}
	}
		
	}

	private void buscarEventos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		EventoDTO obj = new EventoDTO();
		
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String fechainicio = request.getParameter("fechainicio");
		String fechafin = request.getParameter("fechafin");
		String costo = request.getParameter("costo");
		String lugar = request.getParameter("cbougar");
		String gratuito = request.getParameter("gratuito");
		String estado = request.getParameter("estado");
		String validaciones = "";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		Date hoy = new Date();
		
		Date dateinicio = null;
		
		Date datefin = null;
		
					
		if(fechainicio!=null && !fechainicio.trim().equals("")){
		
			try {
				dateinicio = sdf.parse(fechainicio);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			obj.setFechaInicio(dateinicio);
		}
		
		if(fechafin!=null && !fechafin.trim().equals("")){
		
			try {
				datefin = sdf.parse(fechafin);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			obj.setFechaFin(datefin);
		}
		
		boolean count = ajaxService.mismoNombre("evento",nombre);
		int codlugar = Integer.parseInt(lugar);
		
		boolean count1 = ajaxService.mismoEvento("evento", dateinicio,codlugar);
		
		if(nombre.replaceAll(" ", "").equals("")) {
            validaciones = "El campo Titulo de Evento no puede estar vacío";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
		
		else if(!(nombre.matches("[a-zA-Z´0-9]*"))) {
            validaciones = "Ingrese un título de evento válido";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
		
		else if(count==true) {
    		validaciones = "Ya existe un evento con el mismo nombre"; 
    		request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
		
		else if(lugar.equals("")) {
            validaciones = "Debe seleccionar un lugar";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
		
		else if(fechainicio.replaceAll(" ", "").equals("")) {
            validaciones = "No ha seleccionado una fecha de inicio";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
		
		else if(dateinicio.before(hoy)) {
            validaciones = "La fecha de inicio no puede ser menor a la de hoy";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
		
		else if(dateinicio.equals(hoy)) {
            validaciones = "No puede crear un evento con la fecha de hoy";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
				
		else if(fechafin.replaceAll(" ", "").equals("")) {
            validaciones = "No ha seleccionado una fecha de finalización";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
		
		else if(datefin.before(dateinicio)) {
            validaciones = "La fecha de finalización no puede ser antes que la fecha de inicio";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
		
		else if(datefin.compareTo(dateinicio) < 1) {
            validaciones = "La hora de finalización no puede empezar antes que la hora de inicio";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
		
		else if(dateinicio.equals(datefin)) {
            validaciones = "La hora de inicio no puede ser igual a la hora de finalizacion";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
		
		else if(count1==true) {
    		validaciones = "Ya existe un evento con el mismo lugar y fecha ingresada"; 
    		request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
				
		else if(!(costo.matches("[0-9]*[.][0.9]*"))) {
            validaciones = "Ingrese un monto válido";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
		
		else{
		obj.setNombre(nombre);
		obj.setDescripcion(descripcion);
		obj.setGratuito(Integer.parseInt(gratuito));
		obj.setPrecio(Double.parseDouble(costo));
		obj.setEstado(Integer.parseInt(estado));
		obj.setCodlugar(Integer.parseInt(lugar));
		
		int resultado = eventoService.registrarEvento(obj);
		if (resultado != -1){
			request.setAttribute("nomevento", obj.getNombre());
			request.setAttribute("codevento", resultado+"");
			listaModalidad(request, response);
		}else{
			response.sendRedirect("error.html");
		}
	}
	}
	public ServletEvento() {
        super();
        // TODO Auto-generated constructor stub
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

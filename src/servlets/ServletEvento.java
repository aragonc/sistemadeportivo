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
		request.setCharacterEncoding("utf-8");
    	String tipo = request.getParameter("tipo");

		if (tipo.equals("registrar"))
			registrar(request, response);
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
		 String accion = request.getParameter("accion");
		 String codevento = request.getParameter("codevento");
		 String[] codmodalidad = request.getParameterValues("modalidad[]");
		 //Determinamos el tipo de acci√≥n que vamos a recibir 
		 if(accion.equals("agregar")) {
			 //Cuando vamos  a agregar un registro nuevo de un evento nuevo
			 for(String item : codmodalidad){
				 ModalidadDTO mod = modalidadService.buscarModalidad(Integer.parseInt(item));
				 eventoService.agregarEventoModalidad(Integer.parseInt(codevento), mod);
			 }
			 listar(request, response);
			 //System.out.println("Agrego");
		 } else {
			 //Cuando vamos a modificar las modalidades de un evento existente.
			 eventoService.eliminarEventoModalidad(Integer.parseInt(codevento));
			 if(codmodalidad!=null) {
				 for(String item : codmodalidad){
					 ModalidadDTO mod = modalidadService.buscarModalidad(Integer.parseInt(item));
					 eventoService.agregarEventoModalidad(Integer.parseInt(codevento), mod);
				 }
			 }
			 response.sendRedirect("ServletEvento?tipo=detalle&cod="+codevento);
			 //System.out.println("Actualizo"); 
		 } 
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
		String dato = request.getParameter("cod");
		String action = request.getParameter("action");
		
		int codigo = Integer.parseInt(dato);
		
		EventoDTO obj = eventoService.buscarEvento(codigo);
		request.setAttribute("evento", obj);
		
		List<ModalidadDTO> info = modalidadService.listarModalidad();
		request.setAttribute("data", info);
		
		if(action.equals("add")) {
			request.setAttribute("accion", "agregar");
		} else {
			request.setAttribute("accion", "actualizar");
		}	
		request.getRequestDispatcher("app/modalidad/suscribir_modalidad.jsp").forward(request,response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
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
		
		EventoDTO x = eventoService.buscarEvento(Integer.parseInt(cod));
		
		if(nombre.replaceAll(" ", "").equals("")) {
			request.setAttribute("registro", x);
            validaciones = "El campo Titulo de Evento no puede estar vacio";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/actualizar_evento.jsp").forward(request, response);
        }
		
		else if(!(nombre.matches("[A-Za-z—Ò·ÈÌÛ˙¡…Õ”⁄ 0-9]*"))) {
			request.setAttribute("registro", x);
            validaciones = "Ingrese un titulo de evento valido";
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
            validaciones = "No ha seleccionado una fecha de finalizaci√≥n";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/actualizar_evento.jsp").forward(request, response);
        }
		
		else if(datefin.before(dateinicio)) {
			request.setAttribute("registro", x);
            validaciones = "La fecha de finalizaci√≥n no puede ser antes que la fecha de inicio";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/actualizar_evento.jsp").forward(request, response);
        }
		
		else if(datefin.compareTo(dateinicio) < 1) {
			request.setAttribute("registro", x);
            validaciones = "La hora de finalizaci√≥n no puede ser antes que la hora de inicio";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/actualizar_evento.jsp").forward(request, response);
        }
		
		else if(dateinicio.equals(datefin)) {
			request.setAttribute("registro", x);
            validaciones = "La hora de inicio no puede ser igual a la hora de finalizacion";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/actualizar_evento.jsp").forward(request, response);
        }
			
		else if(!(costo.matches("[0-9.]*"))) {
			request.setAttribute("registro", x);
            validaciones = "Ingrese un monto v√°lido";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/actualizar_evento.jsp").forward(request, response);
        }
		
		
		else{
			
		obj.setNombre(nombre);
		obj.setDescripcion(descripcion);
		obj.setModo(Integer.parseInt(gratuito));
		obj.setPrecio(Double.parseDouble(costo));
		obj.setEstado(Integer.parseInt(estado));
		obj.setCodlugar(Integer.parseInt(lugar));
		obj.setCodigo(Integer.parseInt(cod));
		
		int resultado = eventoService.actualizarEvento(obj);
		if (resultado != -1){
			listar(request, response);
		}else{
			response.sendRedirect("error.html");
		}
	}
		
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

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
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
		boolean count1 = ajaxService.mismoEvento("evento", dateinicio,datefin,codlugar);
		boolean count2 = ajaxService.mismoEvento1("evento", dateinicio, datefin, codlugar);
		boolean count3 = ajaxService.mismoEventoInicio("evento", dateinicio, datefin, codlugar);
		boolean count4 = ajaxService.mismoEventoFin("evento", dateinicio, datefin, codlugar);
		
		if(nombre.replaceAll(" ", "").equals("")) {
            validaciones = "El campo Titulo de Evento no puede estar vacÌo";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
		
		else if(!(nombre.matches("[A-Za-z—Ò·ÈÌÛ˙¡…Õ”⁄ 0-9]*"))) {
            validaciones = "Ingrese un t√≠tulo de evento v·lido";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
		
		else if(count==true) {
    		validaciones = "Ya existe un evento con el mismo nombre"; 
    		request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
		
		else if(codlugar==0) {
            validaciones = "Debe seleccionar un lugar";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
		
		else if(fechainicio.replaceAll(" ", "").equals("")) {
            validaciones = "No ha seleccionado una fecha de inicio";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
		
		else if(fechafin.replaceAll(" ", "").equals("")) {
            validaciones = "No ha seleccionado una fecha de finalizaciÛn";
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
		
		else if(datefin.before(dateinicio)) {
            validaciones = "La fecha de finalizaciÛn no puede ser antes que la fecha de inicio";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
		
		else if(count1==true) {
    		validaciones = "Ya se est· llevando a cabo un evento en el mismo lugar y las fechas ingresadas estan dentro del rango de otras fechas de otro evento"; 
    		request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
		else if(count2==true) {
    		validaciones = "Ya se est· llevando a cabo un evento en el mismo lugar y en el rango de fechas ingresadas"; 
    		request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
		else if(count3==true) {
    		validaciones = "Ya se est· llevando a cabo un evento en el mismo lugar y la fecha inicial de dicho evento est· dentro del intervalo de las fechas seleccionadas"; 
    		request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
		else if(count4==true) {
    		validaciones = "Ya se est· llevando a cabo un evento en el mismo lugar y la fecha final de dicho evento est· dentro del intervalo de las fechas seleccionadas"; 
    		request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
				
		else if(!(costo.matches("[0-9.]*"))) {
            validaciones = "Ingrese un monto v·lido";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/evento/registrar_evento.jsp").forward(request, response);
        }
       
		
		
		else{  
			
					
			
		obj.setNombre(nombre);
		obj.setDescripcion(descripcion);
		obj.setModo(Integer.parseInt(gratuito));
		obj.setPrecio(Double.parseDouble(costo));
		obj.setEstado(Integer.parseInt(estado));
		obj.setCodlugar(Integer.parseInt(lugar));
		
		int resultado = eventoService.registrarEvento(obj);
		if (resultado != -1){
			response.sendRedirect("ServletEvento?tipo=listaModalidad&action=add&cod="+resultado);
		}else{
			response.sendRedirect("error.html");
		}
	}
	}
	//}
		
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
	
	public boolean isEmptyStringArray(String [] array){
	 for(int i=0; i<array.length; i++){ 
		 if(array[i]!=null){
			 return false;
		 }
	  }
	 return true;
	}
}

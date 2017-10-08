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

import beans.EquipoDTO;
import beans.EventoDTO;
import beans.ModalidadDTO;
import beans.PersonaDTO;
import interfaces.EventoDAO;
import service.EventoService;
import service.ModalidadService;

@WebServlet("/ServletEvento")
public class ServletEvento extends HttpServlet {
	
	EventoService eventoService = new EventoService();
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
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String fechainicio = request.getParameter("fechainicio");
		String fechafin = request.getParameter("fechafin");
		String costo = request.getParameter("costo");
		String lugar = request.getParameter("lugar");
		String gratuito = request.getParameter("gratuito");
		String estado = request.getParameter("estado");
		String cod = request.getParameter("codigo");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		if(fechainicio!=null && !fechainicio.trim().equals("")){
			Date dateinicio = null;
			try {
				dateinicio = sdf.parse(fechainicio);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			obj.setFechaInicio(dateinicio);
		}
		
		if(fechafin!=null && !fechafin.trim().equals("")){
			Date datefin = null;
			try {
				datefin = sdf.parse(fechafin);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			obj.setFechaFin(datefin);
		}
		obj.setCodigo(Integer.parseInt(cod));
		obj.setNombre(nombre);
		obj.setDescripcion(descripcion);
		obj.setGratuito(Boolean.parseBoolean(gratuito));
		obj.setPrecio(Double.parseDouble(costo));
		obj.setEstado(Integer.parseInt(estado));
		obj.setLugar(lugar);
		
		int resultado = eventoService.actualizarEvento(obj);
		if (resultado != -1){
			request.setAttribute("nomevento", obj.getNombre());
			request.setAttribute("codevento", resultado+"");
			listaModalidad(request, response);
		}else{
			response.sendRedirect("error.html");
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
		String lugar = request.getParameter("lugar");
		String gratuito = request.getParameter("gratuito");
		String estado = request.getParameter("estado");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		if(fechainicio!=null && !fechainicio.trim().equals("")){
			
			Date dateinicio = null;
			
			try {
				dateinicio = sdf.parse(fechainicio);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			obj.setFechaInicio(dateinicio);
		}
		
		if(fechafin!=null && !fechafin.trim().equals("")){
			
			Date datefin = null;
			
			try {
				datefin = sdf.parse(fechafin);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			obj.setFechaFin(datefin);
		}
		
		obj.setNombre(nombre);
		obj.setDescripcion(descripcion);
		obj.setGratuito(Boolean.parseBoolean(gratuito));
		obj.setPrecio(Double.parseDouble(costo));
		obj.setEstado(Integer.parseInt(estado));
		obj.setLugar(lugar);
		
		int resultado = eventoService.registrarEvento(obj);
		if (resultado != -1){
			request.setAttribute("nomevento", obj.getNombre());
			request.setAttribute("codevento", resultado+"");
			listaModalidad(request, response);
		}else{
			response.sendRedirect("error.html");
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

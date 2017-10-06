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
import interfaces.EventoDAO;
import service.EventoService;

@WebServlet("/ServletEvento")
public class ServletEvento extends HttpServlet {
	
	EventoService eventoService = new EventoService();
	
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
    	String tipo = request.getParameter("tipo");
    	//String tipopersona = request.getParameter("tipo");
		if (tipo.equals("registrar"))
			registrar(request, response);
		else if (tipo.equals("buscarpersona"))
			buscarPersona(request, response);
		else if (tipo.equals("actualizar"))
			actualizar(request, response);
		else if (tipo.equals("buscar"))
			buscarPersona(request, response);
		else if (tipo.equals("listar"))
			listar(request, response);
		else if (tipo.equals("eliminar"))
			eliminar(request, response);
	}
	
    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

    private void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<EventoDTO> info = eventoService.listarEvento();
		request.setAttribute("data", info);
		request.getRequestDispatcher("app/listar_evento.jsp").forward(request,
				response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void buscarPersona(HttpServletRequest request, HttpServletResponse response) {
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
		
		int resultado = eventoService.registrarEvento(obj);
		System.out.println(resultado);
		if (resultado != -1){
			request.setAttribute("codevento", resultado);
			listar(request, response);
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

package servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CategoriaDTO;
import beans.PersonaDTO;
import service.PersonaService;

@WebServlet("/ServletPersona")
public class ServletPersona extends HttpServlet {
	PersonaService personaService = new PersonaService();
	private static final long serialVersionUID = 1L;
	public ServletPersona(){
		super();
	}
	
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
	//metodos para registar una persona pero según su tipo;
	 
	 private void eliminar(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			String dato = request.getParameter("cod");
			int codigo = Integer.parseInt(dato);
			personaService.eliminarPersona(codigo);
			request.getRequestDispatcher("ServletPersona?tipo=listar").forward(request,
					response);
		}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PersonaDTO> info = personaService.listarPersona();
		request.setAttribute("data", info);
		request.getRequestDispatcher("app/listar_persona.jsp").forward(request, response);
	}

	private void actualizar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PersonaDTO obj = new PersonaDTO();
		
		String nombre = request.getParameter("txtnombre");		
		String paterno = request.getParameter("txtapaterno");
		String materno = request.getParameter("txtamaterno");
		String sexo = request.getParameter("cmbsexo");
		String dni = request.getParameter("cbotipodocumento");
		String fechanac = request.getParameter("txtfechanacimiento");
		String email = request.getParameter("txtemail");
		String telefono = request.getParameter("txtfono");
		String est = request.getParameter("cmbestado");
		String cod = request.getParameter("codigo");
		
		if(fechanac!=null && !fechanac.trim().equals("")){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			Date date = null;
			try {
				date = sdf.parse(fechanac);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			obj.setFnacimiento(date);
		}
		
			
		obj.setNombre(nombre);
		obj.setApaterno(paterno);
		obj.setAmaterno(materno);
		obj.setSexo(Integer.parseInt(sexo));
		obj.setTipodocumento(Integer.parseInt(dni));;
		obj.setEmail(email);
		obj.setFono(telefono);
		obj.setEstado(Integer.parseInt(est));
		obj.setCodigo(Integer.parseInt(cod));	
		
		int estado = personaService.actualizarPersona(obj);
		if (estado != -1)
			listar(request, response);
		else
			response.sendRedirect("error.html");
	}

	private void buscarPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dato = request.getParameter("cod");
		int codigo = Integer.parseInt(dato);
		PersonaDTO x = personaService.buscarPersona(codigo);
		request.setAttribute("registro", x);
		request.getRequestDispatcher("app/actualizar_persona.jsp").forward(request,
				response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PersonaDTO obj = new PersonaDTO();
		request.getRequestDispatcher("app/registar_persona.jsp").forward(request, response);

		String nombre = request.getParameter("txtnombre");
		String apaterno = request.getParameter("txtapaterno");
		String amaterno = request.getParameter("txtamaterno");
		String sexo = request.getParameter("cmbsexo");
		String tipodocumento = request.getParameter("cbotipodocumento");
		String numdocumento = request.getParameter("txtnumdocumento");
		String fnacimiento = request.getParameter("txtfechanacimiento");
		String email = request.getParameter("txtemail");
		String fono = request.getParameter("txtfono");
		String estado = request.getParameter("cmbestado");
		
		if(fnacimiento!=null && !fnacimiento.trim().equals("")){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			Date date = null;
			try {
				date = sdf.parse(fnacimiento);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			obj.setFnacimiento(date);
		}
		obj.setNombre(nombre);
		obj.setApaterno(apaterno);
		obj.setAmaterno(amaterno);
		obj.setSexo(Integer.parseInt(sexo));
		obj.setTipodocumento(Integer.parseInt(tipodocumento));
		obj.setNumdocumento(numdocumento);
		obj.setEmail(email);
		obj.setFono(fono);
		obj.setEstado(Integer.parseInt(estado));
		
		int proceso = personaService.registrarPersona(obj);
		
		if(proceso != -1){
			listar(request, response);
		} else {
			response.sendRedirect("error.html");
		}
	}
}

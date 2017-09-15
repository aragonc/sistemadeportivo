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
	 
	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PersonaDTO> info = personaService.listarPersona();
		request.setAttribute("data", info);
		request.getRequestDispatcher("listar_persona.jsp").forward(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void buscarPersona(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
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
		String movil = request.getParameter("txtmovil");
		String estado = request.getParameter("cmbestado");
		
		if(fnacimiento!=null && !fnacimiento.trim().equals("")){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
			Date date = null;
			try {
				date = sdf.parse(fnacimiento);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			obj.setFnacimiento(date.toString());
		}
		obj.setNombre(nombre);
		obj.setApaterno(apaterno);
		obj.setAmaterno(amaterno);
		obj.setSexo(Integer.parseInt(sexo));
		obj.setTipodocumento(Integer.parseInt(tipodocumento));
		obj.setNumdocumento(numdocumento);
		obj.setEmail(email);
		obj.setFono(fono);
		obj.setMovil(movil);
		obj.setEstado(Integer.parseInt(estado));
		
		int proceso = personaService.registrarPersona(obj);
		
		if(proceso != -1){
			System.out.println("Registro exitoso...");
		} else {
			System.out.println("Error...");
		}
		
		
	}
}

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
import service.AjaxService;
import service.PersonaService;

@WebServlet("/ServletPersona")
public class ServletPersona extends HttpServlet {
	PersonaService personaService = new PersonaService();
	AjaxService ajaxService = new AjaxService();
	private static final long serialVersionUID = 1L;
	public ServletPersona(){
		super();
	}
	
	 protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			
	    	String tipo = request.getParameter("tipo");
	    	
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
			else if (tipo.equals("buscarPersonaXNombre"))
				buscarPersonaXNombre(request, response);
		}
	//metodos para registar una persona pero seg�n su tipo;
	 
	 private void eliminar(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			String[] dato = request.getParameterValues("cod[]");
			for(String item: dato){
				int codigo = Integer.parseInt(item);
				personaService.eliminarPersona(codigo);
			}
			request.getRequestDispatcher("ServletPersona?tipo=listar").forward(request,
					response);
		}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PersonaDTO> info = personaService.listarPersona();
		request.setAttribute("data", info);
		request.getRequestDispatcher("app/persona/listar_persona.jsp").forward(request, response);
	}
	
	

	private void actualizar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PersonaDTO obj = new PersonaDTO();
		String cod = request.getParameter("codigo");
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
		String validaciones = "";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date hoy = new Date();
		
		Date date = null;
		
		if(fnacimiento!=null && !fnacimiento.trim().equals("")){
			
			
			try {
				
				date = sdf.parse(fnacimiento);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			obj.setFnacimiento(date);
		}
		
		int sex = Integer.parseInt(sexo);
		int doc = Integer.parseInt(tipodocumento);	
		
		PersonaDTO x = personaService.buscarPersona(Integer.parseInt(cod));
		
		if(nombre.replaceAll(" ", "").equals("")) {
			request.setAttribute("registro", x);
            validaciones = "El campo Nombres est� no puede vac�o";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/actualizar_persona.jsp").forward(request, response);
        }
		else if(apaterno.replaceAll(" ", "").equals("")) {
			request.setAttribute("registro", x);
            validaciones = "El campo Apellido Paterno no puede estar vac�o";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/actualizar_persona.jsp").forward(request, response);
        }
		else if(amaterno.replaceAll(" ", "").equals("")) {
			request.setAttribute("registro", x);
            validaciones = "El campo Apellido Materno no puede estar vac�o";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/actualizar_persona.jsp").forward(request, response);
        }
		else if(sex == 0) {
			request.setAttribute("registro", x);
            validaciones = "Debe seleccionar su sexo";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/actualizar_persona.jsp").forward(request, response);
        }
		else if(doc== 0) {
			request.setAttribute("registro", x);
            validaciones = "Debe seleccionar un tipo de documento";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/actualizar_persona.jsp").forward(request, response);
        }
		else if(numdocumento.replaceAll(" ", "").equals("")) {
			request.setAttribute("registro", x);
            validaciones = "No ha ingresado un n�mero de documento";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/actualizar_persona.jsp").forward(request, response);
        }
		else if(fnacimiento.replaceAll(" ", "").equals("")) {
			request.setAttribute("registro", x);
            validaciones = "No ha ingresado su fecha de nacimiento";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/actualizar_persona.jsp").forward(request, response);
        }
		else if(email.replaceAll(" ", "").equals("")) {
			request.setAttribute("registro", x);
            validaciones = "El campo email no puede estar vac�o";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/actualizar_persona.jsp").forward(request, response);
        }
		else if(email.replaceAll(" ", "").equals("")) {
			request.setAttribute("registro", x);
            validaciones = "Tiene que ingresar un n�mero de tel�fono";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/actualizar_persona.jsp").forward(request, response);
        }
		else if(!(nombre.matches("[A-Za-z������������ ]*"))) {
			request.setAttribute("registro", x);
            validaciones = "Ingrese nombres v�lidos";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/actualizar_persona.jsp").forward(request, response);
        }
		else if(!(apaterno.matches("[A-Za-z������������ ]*"))) {
			request.setAttribute("registro", x);
            validaciones = "Debe ingresar un apellido paterno v�lido";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/actualizar_persona.jsp").forward(request, response);
        }
		else if(!(apaterno.matches("[A-Za-z������������ ]*"))) {
			request.setAttribute("registro", x);
            validaciones = "Debe ingresar un apellido materno v�lido";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/actualizar_persona.jsp").forward(request, response);
        }
		else if(!(numdocumento.matches("[0-9]*"))) {
			request.setAttribute("registro", x);
            validaciones = "Solo debe ingresar caracteres num�ricos en el campo de documento de identidad";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/actualizar_persona.jsp").forward(request, response);
        }
		
		else if((doc == 1) && !(numdocumento.length() == 8 )) {
			request.setAttribute("registro", x);
            validaciones = "El Documento nacional de identidad debe tener 8 caracteres";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/actualizar_persona.jsp").forward(request, response);
        }
			
		else if((doc == 2) && !(numdocumento.length() == 12 )) {
			request.setAttribute("registro", x);
            validaciones = "El Carnet de Extranjer�a debe tener 12 caracteres";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/actualizar_persona.jsp").forward(request, response);
        }
		else if((doc == 3) && !(numdocumento.length() == 11 )) {
			request.setAttribute("registro", x);
            validaciones = "El Registro Unico de Contribuyentes debe tener 8 caracteres";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/actualizar_persona.jsp").forward(request, response);
        }
		else if((doc == 4) && !(numdocumento.length() == 12 )) {
			request.setAttribute("registro", x);
            validaciones = "El Pasaporte debe tener 12 caracteres";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/actualizar_persona.jsp").forward(request, response);
        }
		else if((doc == 5) && !(numdocumento.length() == 15 )) {
			request.setAttribute("registro", x);
            validaciones = "El Partida de Nacimiento debe tener 15 caracteres";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/actualizar_persona.jsp").forward(request, response);
        }
		else if((date.after(hoy))) {
			request.setAttribute("registro", x);
            validaciones = "La fecha de nacimiento no puede ser mayor a hoy";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/actualizar_persona.jsp").forward(request, response);
        }	
		else if(!(email.matches("[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})"))) {
			request.setAttribute("registro", x);
            validaciones = "Ingrese un email v�lido";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/actualizar_persona.jsp").forward(request, response);
        }
		else if(!(fono.matches("[0-9]*"))) {
			request.setAttribute("registro", x);
            validaciones = "Solo debe ingresar caracteres num�ricos en su tel�fono";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/actualizar_persona.jsp").forward(request, response);
        }
		else if(!(fono.length() == 7) && !(fono.length() == 9)) {
			request.setAttribute("registro", x);
            validaciones = "El tel�fono solo debe tener 7 o 9 d�gitos";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/actualizar_persona.jsp").forward(request, response);
        }
		
		
		else{
		obj.setNombre(nombre);
		obj.setApaterno(apaterno);
		obj.setAmaterno(amaterno);
		obj.setSexo(sexo);
		obj.setTipodocumento(Integer.parseInt(tipodocumento));
		obj.setNumdocumento(numdocumento);
		obj.setEmail(email);
		obj.setFono(fono);
		obj.setEstado(Integer.parseInt(estado));
		obj.setCodigo(Integer.parseInt(cod));
		int proceso = personaService.actualizarPersona(obj);
		
		if(proceso != -1){
			listar(request, response);
		} else {
			response.sendRedirect("error.html");
		}
		}
	}

	private void buscarPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dato = request.getParameter("cod");
		int codigo = Integer.parseInt(dato);
		PersonaDTO x = personaService.buscarPersona(codigo);
		request.setAttribute("registro", x);
		request.getRequestDispatcher("app/persona/actualizar_persona.jsp").forward(request,
				response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PersonaDTO obj = new PersonaDTO();
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
		String validaciones = "";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date hoy = new Date();
		
		Date date = null;
		
		if(fnacimiento!=null && !fnacimiento.trim().equals("")){
			
			
			try {
				
				date = sdf.parse(fnacimiento);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			obj.setFnacimiento(date);
		}
		
		int sex = Integer.parseInt(sexo);
		int doc = Integer.parseInt(tipodocumento);	
		
		boolean count = ajaxService.mismoDoc("persona",numdocumento);
		
		
		if(nombre.replaceAll(" ", "").equals("")) {
            validaciones = "El campo Nombres est� no puede vac�o";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/registrar_persona.jsp").forward(request, response);
        }
		else if(!(nombre.matches("[A-Za-z������������ ]*"))) {
            validaciones = "Ingrese nombres v�lidos";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/registrar_persona.jsp").forward(request, response);
        }
		
		else if(apaterno.replaceAll(" ", "").equals("")) {
            validaciones = "El campo Apellido Paterno no puede estar vac�o";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/registrar_persona.jsp").forward(request, response);
        }
		else if(amaterno.replaceAll(" ", "").equals("")) {
            validaciones = "El campo Apellido Materno no puede estar vac�o";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/registrar_persona.jsp").forward(request, response);
        }
		else if(sex == 0) {
            validaciones = "Debe seleccionar su sexo";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/registrar_persona.jsp").forward(request, response);
        }
		else if(doc== 0) {
            validaciones = "Debe seleccionar un tipo de documento";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/registrar_persona.jsp").forward(request, response);
        }
		else if(numdocumento.replaceAll(" ", "").equals("")) {
            validaciones = "No ha ingresado un n�mero de documento";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/registrar_persona.jsp").forward(request, response);
        }
		else if(fnacimiento.replaceAll(" ", "").equals("")) {
            validaciones = "No ha ingresado su fecha de nacimiento";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/registrar_persona.jsp").forward(request, response);
        }
		else if(email.replaceAll(" ", "").equals("")) {
            validaciones = "El campo email no puede estar vac�o";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/registrar_persona.jsp").forward(request, response);
        }
		else if(email.replaceAll(" ", "").equals("")) {
            validaciones = "Tiene que ingresar un n�mero de tel�fono";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/registrar_persona.jsp").forward(request, response);
        }
		
		else if(!(apaterno.matches("[A-Za-z������������ ]*"))) {
            validaciones = "Debe ingresar un apellido paterno v�lido";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/registrar_persona.jsp").forward(request, response);
        }
		else if(!(apaterno.matches("[A-Za-z������������ ]*"))) {
            validaciones = "Debe ingresar un apellido materno v�lido";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/registrar_persona.jsp").forward(request, response);
        }
		else if(!(numdocumento.matches("[0-9]*"))) {
            validaciones = "Solo debe ingresar caracteres num�ricos en el campo de documento de identidad";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/registrar_persona.jsp").forward(request, response);
        }
		
		else if((doc == 1) && !(numdocumento.length() == 8 )) {
            validaciones = "El Documento nacional de identidad debe tener 8 caracteres";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/registrar_persona.jsp").forward(request, response);
        }
			
		else if((doc == 2) && !(numdocumento.length() == 12 )) {
            validaciones = "El Carnet de Extranjer�a debe tener 12 caracteres";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/registrar_persona.jsp").forward(request, response);
        }
		else if((doc == 3) && !(numdocumento.length() == 11 )) {
            validaciones = "El Registro Unico de Contribuyentes debe tener 8 caracteres";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/registrar_persona.jsp").forward(request, response);
        }
		else if((doc == 4) && !(numdocumento.length() == 12 )) {
            validaciones = "El Pasaporte debe tener 12 caracteres";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/registrar_persona.jsp").forward(request, response);
        }
		else if((doc == 5) && !(numdocumento.length() == 15 )) {
            validaciones = "El Partida de Nacimiento debe tener 15 caracteres";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/registrar_persona.jsp").forward(request, response);
        }
		else if((date.after(hoy))) {
            validaciones = "La fecha de nacimiento no puede ser mayor a hoy";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/registrar_persona.jsp").forward(request, response);
        }	
		else if(!(email.matches("[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})"))) {
            validaciones = "Ingrese un email v�lido";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/registrar_persona.jsp").forward(request, response);
        }
		else if(!(fono.matches("[0-9]*"))) {
            validaciones = "Solo debe ingresar caracteres num�ricos en su tel�fono";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/registrar_persona.jsp").forward(request, response);
        }
		else if(!(fono.length() == 7) && !(fono.length() == 9)) {
            validaciones = "El tel�fono solo debe tener 7 o 9 d�gitos";
            request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/registrar_persona.jsp").forward(request, response);
        }
		
		else if(count==true) {
    		validaciones = "Ya hay una persona  registrada con el mismo n�mero de documento"; 
    		request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("app/persona/registrar_persona.jsp").forward(request, response);
        }
		else{
		obj.setNombre(nombre);
		obj.setApaterno(apaterno);
		obj.setAmaterno(amaterno);
		obj.setSexo(sexo);
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
	
	private void buscarPersonaXNombre(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersonaDTO obj = new PersonaDTO();		
		String nombre = request.getParameter("txtNombre");
		String apaterno = request.getParameter("txtApellido");
		
		
		if(nombre!=null && nombre.trim().equals("")){
			nombre = null;	
		}
		
		if(apaterno!=null && apaterno.trim().equals("")){
			apaterno = null;	
		}
		
		obj.setNombre(nombre);				
		obj.setApaterno(apaterno);
		
		
		List<PersonaDTO> info = personaService.listarPersona(obj);
		request.setAttribute("data", info);
		request.getRequestDispatcher("app/persona/listar_persona.jsp").forward(request,
				response);
	}
}

package servlets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.ComboDTO;
import beans.ModalidadDTO;
import service.AjaxService;

/**
 * Servlet implementation class ServletAjax
 */
@WebServlet("/ServletAjax")
public class ServletAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	AjaxService serviceAjax = new AjaxService();

	
	
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	String tipo = request.getParameter("tipo");
    	
		if (tipo.equals("listarModalidad"))
			listarModalidad(request, response);
		else if (tipo.equals("eliminarModalidad"))
			listarModalidad(request, response);
		else if (tipo.equals("crop"))
			cortarImagen(request, response);
	}

    
    private void cortarImagen(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
    	
        
        

	}


	private void listarModalidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
    	response.setContentType("application/json;charset=UTF-8");
    	String dato =  request.getParameter("codevento");
    	int codigo = Integer.parseInt(dato);
    	List<ComboDTO> combo  = new ArrayList<ComboDTO>();
    	List<ModalidadDTO> lista = serviceAjax.listarModalidadEvento(codigo);
    	ComboDTO modalidad = null;
    	String dataJson = null;
    	Gson gson = new Gson();
    	String genero = null;
    	for(ModalidadDTO item : lista){

    		if(item.getGenero() == 1) {
    			genero = "Varones";
    		} else if(item.getGenero()==2) {
    			genero = "Mujeres";
    		} else {
    			genero = "Mixto";
    		}
    		modalidad = new ComboDTO();
    		modalidad.setCodigo(item.getCodigo());
    		modalidad.setValor(item.getDisciplina().getNombre() + " " + item.getCategoria().getNombre() + " - " + genero + " (" + item.getNumJugadores() + ")" );
    		combo.add(modalidad);
    	}
    	try (PrintWriter out = response.getWriter()) {
    		dataJson = gson.toJson(combo);
    		out.println(dataJson);
    	}
    	
	}


	public ServletAjax() {
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

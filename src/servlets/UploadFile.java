package servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.google.gson.Gson;


import beans.ImagenDTO;
import utils.CropImagen;
 
@WebServlet("/ServletImagen")
public class UploadFile extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    
    protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
    	String tipo = request.getParameter("tipo");
    	
		if (tipo.equals("upload"))
			cargarImage(request, response);
		else if (tipo.equals("crop"))
			recortarImage(request, response);
		else if (tipo.equals("delete"))
			deleteImage(request, response);
		
	}
    private void deleteImage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// MEDOTO PARA ELIMINAR LA IMAGEN.
    	
    	BufferedReader reader = request.getReader(); //OBTENEMOS LOS DATOS DEL AJAX
        Gson gson = new Gson();
        String message = null;
        try {
        	
        	imgValue data = gson.fromJson(reader, imgValue.class);
     	   	String rutaFile = getServletContext().getRealPath("") + "uploads/" + data.nombre;
     	   	CropImagen crop = new CropImagen();
     	   	//System.out.println(rutaFile);
     	   	crop.eliminarImagen(rutaFile);
     	   	
		} catch (Exception e) {
			message = "Error : " + e.getMessage();
		}
        try(PrintWriter out = response.getWriter()){
        	String dataJson = gson.toJson(message);
    		out.println(dataJson);
        }
    	   
    	   
       
		
	}
    class imgValue{
    	protected String nombre;
    }
	class imgBean{
    	
    	protected int ancho;
    	protected int alto;
    	protected int ladox;
    	protected int ladoy;
    	protected String nombre;
    }
 
    private void recortarImage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
    	 response.setContentType("application/json;charset=UTF-8");
    	 
    	 StringBuffer url = request.getRequestURL();
    	 String uri = request.getRequestURI();
    	 String ctx = request.getContextPath();
    	 String base = url.substring(0, url.length() - uri.length() + ctx.length()) + "/";
    	 
    	 //System.out.println(base);
    	 
    	 String message = null;
    	 String dataJson = null;
    	 BufferedReader reader = request.getReader(); //OBTENEMOS LOS DATOS DEL AJAX
         Gson gson = new Gson();
         
         try {
        	 
        	 imgBean data = gson.fromJson(reader, imgBean.class); //SE INSTANCIA LA CLASE IMAGEN
             
             //CREAMOS EL OBJETO IMAGEN
             ImagenDTO imgRecorte = new ImagenDTO();
             imgRecorte.setNombre(data.nombre);
             imgRecorte.setAncho(data.ancho);
             imgRecorte.setAlto(data.alto);
             imgRecorte.setLadox(data.ladox);
             imgRecorte.setLadoy(data.ladoy);
             
             String uploadPath = getServletContext().getRealPath("") + "uploads/";
             
             CropImagen crop = new CropImagen();
             //System.out.println(uploadPath + imgRecorte.getNombre());
             crop.recotarImagen(imgRecorte, uploadPath);
             message = base + "uploads/" + imgRecorte.getNombre();
             
		} catch (Exception ex) {
			
			message = "Error : " + ex.getMessage();
			
		}
         
        try(PrintWriter out = response.getWriter()){
        	dataJson = gson.toJson(message);
    		out.println(dataJson);
        }
         
    	
	}

	/**
     * Metodo para cargar imagen
     */
    protected void cargarImage(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
    	response.setContentType("application/json;charset=UTF-8");
    	
    	String message = null;
    	String dataJson = null;
    	Gson gson = new Gson();
    	
    	if (!ServletFileUpload.isMultipartContent(request)) {
    		message = "Error en el enctype=multipart/form-data";
            return;
        }
 
        // CONFIGURAMOS LA SUBIDA DE ARCHIVOS
        DiskFileItemFactory factory = new DiskFileItemFactory();
        
        // sets memory threshold - beyond which files are stored in disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
        // MAXIMO PESO DE ARCHIVO A SUBIR
        upload.setSizeMax(MAX_FILE_SIZE); 
        // MAXIMA CANTIDAD DE INFO EN EL FORMULARIO (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        
        // RUTA DONDE SE GUARDARAN LAS IMAGENES y CREAMOS EL DIRECTORIO SI NO EXISTE.
        String uploadPath = getServletContext().getRealPath("") + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        
        try {
            // SOLO EXTRAE LOS DATOS DE SOLOS ARCHIVOS
            List<FileItem> formItems = upload.parseRequest(request);
            if (formItems != null && formItems.size() > 0) {
                // INTERACTUAMOS CON TODOS LOS CAMPOS Y ESCOGEMOS EL UNICO DE TIPO ARCHIVO
                for (FileItem item : formItems) {
                    // PROCESA TODOS LOS CAMPOS DEL FORMULARIO ENVIADO
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
 
                        // GUARDAMOS EL ARCHIVO EN EL DISCO
                        item.write(storeFile);
                        message = fileName;
                    }
                }
            }
        } catch (Exception ex) {
        	message = "Error : " + ex.getMessage();
            
        }
        
        try (PrintWriter out = response.getWriter()) {
    		dataJson = gson.toJson(message);
    		out.println(dataJson);
    	}
        
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
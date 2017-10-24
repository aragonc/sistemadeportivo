package servlets;

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
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
 
@WebServlet("/ServletImagen")
public class UploadFile extends HttpServlet {
    private static final long serialVersionUID = 1L;
     
    // location to store file uploaded
    
    private static final String UPLOAD_DIRECTORY = "/home/aragonc/upload";
 
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    
    protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
    	String tipo = request.getParameter("tipo");
    	
		if (tipo.equals("cargar"))
			cargarImage(request, response);
		
	}
 
    /**
     * Upon receiving file upload submission, parses the request to read
     * upload data and saves the file on disk.
     */
    protected void cargarImage(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
    	response.setContentType("application/json;charset=UTF-8");
    	System.out.println("ok");
    	String message = null;
        //RESPONDEREMOS EN JSON
    	
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
        
        // RUTA DONDE SE GUARDARAN LAS IMAGENES
        String uploadPath = getServletContext().getRealPath("") + "uploads";
        
        // CREAMOS EL DIRECTORIO SI NO EXISTE.
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        
        try {
            // SOLO EXTRAE LOS DATOS DE SOLOS ARCHIVOS
            @SuppressWarnings("unchecked")
         
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
                        message = "Success";
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
package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import beans.Imagen;

public class CropImagen {
	public boolean recotarImagen(Imagen file) throws IOException{
		
		boolean resultado = false;
		
		String serverPath="/test/";
        String sourceFile=serverPath+file.getNombre();
        
        System.out.println(sourceFile);
        
        //Obtenemos el Formato de la imagen y lo colocamos con su extension Ejemplo si se llama avatar.jpg ahora se llamara avatar_user.jpg
        
        int img = sourceFile.lastIndexOf(".");
        String destFile = serverPath+(file.getNombre().substring(0, img)+"_user"+file.getNombre().substring(img, file.getNombre().length()));
        
        //Obtengo la referencia de la imagen almacenada
        BufferedImage image=ImageIO.read(new File(sourceFile));
        
        //Creamos una imagen secundaria temporal
        BufferedImage out=image.getSubimage(file.getLadox(),file.getLadoy(),file.getAncho(),file.getAlto());
        
        //Almacenamos la imagen en un nuevo archivo
        ImageIO.write(out,"jpg",new File(destFile));
		
		return resultado;
	}
}

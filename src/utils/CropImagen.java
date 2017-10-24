package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import beans.Imagen;

public class CropImagen {
	public boolean recotarImagen(Imagen file, String serverPath, String sourcePath) throws IOException{
		
		boolean resultado = false;
		
		BufferedImage entrada = ImageIO.read(new File(serverPath));
        BufferedImage salida = entrada.getSubimage(file.getLadox(), file.getLadoy(), file.getAncho(), file.getAlto());
        resultado  = ImageIO.write(salida,"jpg",new File(sourcePath + file.getNombre()));
		System.out.println(resultado);
		return resultado;
	}
}

package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import beans.ImagenDTO;

public class CropImagen {
	public boolean recotarImagen(ImagenDTO file, String imagePath) throws IOException{
		
		boolean resultado = false;
		//String formato = CropImagen.getFormate(file.getNombre());
		BufferedImage outImage=ImageIO.read(new File(imagePath + file.getNombre()));
        BufferedImage cropped = outImage.getSubimage(file.getLadox(), file.getLadoy(), file.getAncho(), file.getAlto());
        resultado  = ImageIO.write(cropped, "jpg", new File(imagePath + file.getNombre()));
        
		//System.out.println(this.getFormate(file.getNombre()));
		
		return resultado;
	}
	public static String getFormate(String ImageName) {
		return (ImageName.substring(ImageName.indexOf('.'),ImageName.length()));
	}
}

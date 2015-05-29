/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.andxbes.filters;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import ua.andxbes.Filter;

/**
 *
 * @author Andr
 */
public class Invert implements Filter{
    	
	

    @Override
    public Image getModifiedByteArrayImage(Image image) {
	
	PixelReader pixelReader = image.getPixelReader();
	//create WritableImage
	WritableImage wi = new WritableImage(
		(int) image.getWidth(),
		(int) image.getHeight());
	PixelWriter pixelWriter = wi.getPixelWriter();
	//determinate the color of each pixel  in specified row 	//determinate the color of each pixel  in specified row 

	for (int readY = 0; readY < image.getHeight(); readY++) {
	    for (int readX = 0; readX < image.getWidth(); readX++) {
		int argb = pixelReader.getArgb(readX, readY);

		int r = 0xFF - (argb >> 16) & 0xFF;
		int g = 0xFF - (argb >> 8) & 0xFF;
		int b = 0xFF - (argb) & 0xFF;
	
		int argbmod = (0xff000000) | r << 16 | g << 8 | b;

		pixelWriter.setArgb(readX, readY, argbmod);
	    }

	}

	return wi;
    }
    
}

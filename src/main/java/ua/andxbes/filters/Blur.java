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
public class Blur implements Filter{

    @Override
    public Image getModifiedByteArrayImage(Image image) {
	
	PixelReader pixelReader = image.getPixelReader();
	//create WritableImage
	WritableImage wi = new WritableImage(
		(int) image.getWidth(),
		(int) image.getHeight());
	PixelWriter pixelWriter = wi.getPixelWriter();
	//determinate the color of each pixel  in specified row 

	for (int readY = 0; readY < image.getHeight(); readY++) {
	    for (int readX = 0; readX < image.getWidth(); readX++) {
		int argb = pixelReader.getArgb(readX, readY);

		int r = (argb >> 16) & 0xFF;
		int g = (argb >> 8) & 0xFF;
		int b = (argb) & 0xFF;
		
                      //TODO
		
		//int argbmod = (0xff000000) | k << 16 | k << 8 | k;

		//pixelWriter.setArgb(readX, readY, argbmod);
	    }

	}

	return wi;
    }
    
}

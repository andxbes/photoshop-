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
public class Turn implements Filter{

    @Override
    public Image getModifiedImage(Image image) {
	
	PixelReader pixelReader = image.getPixelReader();
	//create WritableImage
	WritableImage wi = new WritableImage(
		(int) image.getWidth(),
		(int) image.getHeight());
	PixelWriter pixelWriter = wi.getPixelWriter();
	//determinate the color of each pixel  in specified row 

	for ( int  readYRevers = (int)image.getHeight()-1 ,  readY = 0; readY < image.getHeight(); readY++ , readYRevers--) {
	    for (int readXrevers = (int) image.getWidth()-1, readX = 0; readX < image.getWidth(); readX++ , readXrevers--) {
		int argb = pixelReader.getArgb(readX, readY);
		
		pixelWriter.setArgb(readXrevers, readYRevers, argb);
	    }
	}

	return wi;
    }
    
}

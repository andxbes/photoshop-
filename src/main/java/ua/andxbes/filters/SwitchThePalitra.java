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
public class SwitchThePalitra implements Filter {
private static  int num = 0 ;
    @Override
    public Image getModifiedImage(Image image) {
               
	WritableImage wi = null;
                 switch((num++)%3){
		       case 0:{
			   wi = change1(image);
			
			   break;
		       }
		       case 1:{
			   wi = change2(image);
		
			   break;
		       }
		       case 2:{
			   wi = change3(image);
			
			   break;
		       }
		 }
	  
	 
	return wi;

    }

    private WritableImage change1(Image image) {
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
		

		int argbmod = (0xff000000) | g << 16 | r << 8 | b;

		pixelWriter.setArgb(readX, readY, argbmod);
	    }

	}
	return wi;
    }
    private WritableImage change2(Image image) {
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
		

		int argbmod = (0xff000000) | b << 16 | r << 8 | g;

		pixelWriter.setArgb(readX, readY, argbmod);
	    }

	}
	return wi;
    }
    private WritableImage change3(Image image) {
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

		int argbmod = (0xff000000) | r << 16 | b << 8 | g;

		pixelWriter.setArgb(readX, readY, argbmod);
	    }

	}
	return wi;
    }

}

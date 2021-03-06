/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.andxbes.filters;

import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import ua.andxbes.Filter;

/**
 *
 * @author Andrey
 */
public class Gray implements Filter {

    Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public Image getModifiedImage(Image image) {

	PixelReader pixelReader = image.getPixelReader();
	//create WritableImage
	WritableImage wi = new WritableImage(
		(int) image.getWidth(),
		(int) image.getHeight());
	PixelWriter pixelWriter = wi.getPixelWriter();
	//determinate the color of each pixel  in specified row 

	for (int readY = 0; readY < image.getHeight(); readY++) {
	    for (int readX = 0; readX < image.getWidth(); readX++) {

		//Color color = pixelReader.getColor(readX, readY);
		// Now write a brighter color to the PixelWriter.
		//color = color.invert();
		//pixelWriter.setColor(readX, readY, color);
		int argb = pixelReader.getArgb(readX, readY);

		int r = (argb >> 16) & 0xFF;
		int g = (argb >> 8) & 0xFF;
		int b = (argb) & 0xFF;
		

		int k = (int) (.56 * g + .33 * r + .11 * b);
		int argbmod = (0xff000000) | k << 16 | k << 8 | k;

		pixelWriter.setArgb(readX, readY, argbmod);
	    }

	}

	return wi;
    }

}

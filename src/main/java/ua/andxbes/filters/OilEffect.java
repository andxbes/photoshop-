/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.andxbes.filters;

import java.util.Arrays;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import ua.andxbes.Filter;

/**
 *
 * @author Andr
 */
public class OilEffect implements Filter {

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
		if (readX <= 1 || readY <= 1
			|| (readX >= (int) image.getWidth() - 2) || (readY >= (int) image.getHeight() - 2)) {
		    pixelWriter.setArgb(readX, readY, pixelReader.getArgb(readX, readY));
		} else {

		    int rs = 0;
		    int gs = 0;
		    int bs = 0;
		    int cur = 0;
		    int[] temp = new int[25];
		    for (int k = -2; k <= 2; k++) {
			for (int j = -2; j <= 2; j++) {
			    temp[cur++] = pixelReader.getArgb(readX + j, readY + k);
			}
		    }

		    pixelWriter.setArgb(readX, readY, getMidleValue(temp));

		}
	    }

	}

	return wi;

    }

    protected int getMidleValue(int[] array) {
	Arrays.sort(array);
	return array[13];
    }

}

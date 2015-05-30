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
public class PencilEffect implements Filter {

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
		if (readX == 0 || readY == 0
			|| (readX == (int) image.getWidth() - 1) || (readY == (int) image.getHeight() - 1)) {
		    pixelWriter.setArgb(readX, readY, getConGoin(pixelReader.getArgb(readX, readY)));
		} else {
		    int rs = 0;
		    int gs = 0;
		    int bs = 0;

		    for (int k = -1; k <= 1; k++) {
			for (int j = -1; j <= 1; j++) {
			    int argb = pixelReader.getArgb(readX + j, readY + k);
			    int r = (argb >> 16) & 0xFF;
			    int g = (argb >> 8) & 0xFF;
			    int b = (argb) & 0xFF;

			    if (k == -1) {
				rs += r;
				gs += g;
				bs += b;
			    } else if (k == 1) {
				rs += r * -1;
				gs += g * -1;
				bs += b * -1;
			    }
			}
		    }

		    int k = getConGoin(rs, gs, bs) + 128 & 0xff;

		    int newimgpixels = (0xff000000) | k << 16 | k << 8 | k;

		    pixelWriter.setArgb(readX, readY, newimgpixels);
		}
	    }
	}
	return new Blur().getModifiedImage(wi);
    }

    private int getConGoin(int i) {
	int r = (i >> 16) & 0xFF;
	int g = (i >> 8) & 0xFF;
	int b = (i) & 0xFF;
	return getConGoin(r, g, b);
    }

    //gray

    private int getConGoin(int r, int g, int b) {
	return ((int) (.56 * g + .33 * r + .11 * b));
    }

}

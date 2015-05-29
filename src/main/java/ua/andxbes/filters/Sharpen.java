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
public class Sharpen implements Filter {

    @Override
    public Image getModifiedImage(Image image) {

	PixelReader pixelReader = image.getPixelReader();
	//create WritableImage
	WritableImage wi = new WritableImage(
		(int) image.getWidth(),
		(int) image.getHeight());
	PixelWriter pixelWriter = wi.getPixelWriter();
	//determinate the color of each pixel  in specified row 

	int r0 = 0, g0 = 0, b0 = 0;
	for (int readY = 0; readY < image.getHeight(); readY++) {
	    for (int readX = 0; readX < image.getWidth(); readX++) {
		if (readX == 0 || readY == 0
			|| (readX == (int) image.getWidth() - 1) || (readY == (int) image.getHeight() - 1)) {
		    pixelWriter.setArgb(readX, readY, pixelReader.getArgb(readX, readY));
		} else {
		    int rs = 0;
		    int gs = 0;
		    int bs = 0;

		    for (int k = -1; k <= 1; k++) {
			for (int j = -1; j <= 1; j++) {
			    int rgb = pixelReader.getArgb(readX + j, readY + k);
			    int r = (rgb >> 16) & 0xFF;
			    int g = (rgb >> 8) & 0xFF;
			    int b = (rgb) & 0xFF;
			    if (j == 0 && k == 0) {
				r0 = r;
				g0 = g;
				b0 = b;
			    } else {
				rs += r;
				gs += g;
				bs += b;
			    }
			}
		    }
		    rs >>= 3;
		    gs >>= 3;
		    bs >>= 3;

		    int newimgpixels = (0xff000000) |
			    clamp(r0 + r0 - rs) << 16 |
			    clamp(g0 + g0 - gs) << 8 |
			    clamp(b0 + b0 - bs);
		    pixelWriter.setArgb(readX, readY, newimgpixels);
		}
	    }

	}

	return wi;
    }

    private final int clamp(int i) {
	return (i > 255 ? 255 : (i < 0 ? 0 : i));
    }

}

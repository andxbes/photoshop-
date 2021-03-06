/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.andxbes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

/**
 *
 * @author Andr
 */
public class ImageProcess {

    private Image image;

    private Filter filter;

    public ImageProcess() {
	initPicFiles();
    }

    public ImageProcess(Filter f) {
	this();
	this.filter = f;
    }

    private void initPicFiles() {

	File[] files = new File(".").listFiles(new FilenameFilter() {
	    @Override
	    public boolean accept(File dir, String name) {
		return name.endsWith(".jpg");
	    }
	});
	int numRandom = new Random().nextInt(files.length);
	System.out.println("numrand = " + numRandom + "file  = " + files[numRandom]);

	File file = files[numRandom];
	try {
	    image = new Image(new FileInputStream(file));
	} catch (FileNotFoundException ex) {
	    Logger.getLogger(ImageProcess.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    ///===========================================================================
    public Image getImageOriginal() {
	return image;
    }

    public Image getImageModified() {
	if (filter == null) {
	    filter = (Image image) -> image;
	}
	Image im = filter.getModifiedImage(image);
	System.out.println("successful");
	return im;
    }

    /**
     * @param filter the filter to set
     */
    public ImageProcess setFilter(Filter filter) {
	this.filter = filter;
	return this;
    }

    public ImageProcess setImage(Image im) {
	this.image = im;
	return this;
    }

}

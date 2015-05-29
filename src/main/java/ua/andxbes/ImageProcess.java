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
    private Image imageOriginal ; 
    
    

    ImageProcess() {
	initPicFiles();
    }
    private Filter filter;

    public ImageProcess(Filter f) {
	this.filter = f;
	getRandomFile();
    }
    
     private  void initPicFiles() {
	
	File [] files = new File(".").listFiles(new FilenameFilter() {
	    @Override
	    public boolean accept(File dir, String name) {
		return name.endsWith(".jpg");
	    }
	});
	int numRandom = new Random().nextInt(files.length);
	 System.out.println("numrand = "+ numRandom + "file  = " + files[numRandom]);
	
	File file = files[numRandom];
	try {
	    imageOriginal = new Image(new FileInputStream(file));
	} catch (FileNotFoundException ex) {
	    Logger.getLogger(ImageProcess.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    private void getRandomFile() {
	
    }

  ///===========================================================================

    public Image getImageOriginal() {
	return imageOriginal;
    }
    
    public Image getImageModified(){
	if(filter==null)filter = (Image image) -> image;
	return filter.getModifiedByteArrayImage(imageOriginal);
    }

    /**
     * @param filter the filter to set
     */
    public void setFilter(Filter filter) {
	this.filter = filter;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.andxbes;

/**
 *
 * @author Andr
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import ua.andxbes.filters.Blur;
import ua.andxbes.filters.Gray;
import ua.andxbes.filters.Invert;
import ua.andxbes.filters.OilEffect;
import ua.andxbes.filters.PencilEffect;
import ua.andxbes.filters.Sharpen;
import ua.andxbes.filters.SwitchThePalitra;
import ua.andxbes.filters.Turn;

public class Controller {

    


    @FXML
    private GridPane rootPanel;

 

    @FXML
    private HBox panelControl;
    @FXML
    private ImageView imageViewer;

   
    
    @FXML
    void imageMouseClick(){
        imageViewer.setFitHeight(rootPanel.getHeight() - panelControl.getHeight());
    }

    @FXML
    void oneClick(Event event) {
	
       
	ImageProcess im = new ImageProcess(new Gray());
	imageViewer.setImage(im.getImageOriginal());

	new Thread(() -> {
	    try {
		Thread.sleep(1000);
		Image immod = im.getImageModified();
		Platform.runLater(() -> imageViewer.setImage(immod));
	    } catch (InterruptedException ex) {
		Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
	    }

	}).start();
    }

    @FXML
    void twoClick(Event event) {

	ImageProcess im = new ImageProcess(new Turn());
	imageViewer.setImage(im.getImageOriginal());

	new Thread(() -> {
	    try {
		Thread.sleep(1000);
		Image immod = im.getImageModified();
		Platform.runLater(() -> imageViewer.setImage(immod));
	    } catch (InterruptedException ex) {
		Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
	    }

	}).start();

    }

    @FXML
    void threeClick(Event event) {

	ImageProcess im = new ImageProcess(new SwitchThePalitra());
	imageViewer.setImage(im.getImageOriginal());

	new Thread(() -> {
	    try {
		Thread.sleep(1000);
		Image immod = im.getImageModified();
		Platform.runLater(() -> imageViewer.setImage(immod));
		Thread.sleep(1000);
		Image immod2 = im.getImageModified();
		Platform.runLater(() -> imageViewer.setImage(immod2));
		Thread.sleep(1000);
		Image immod3 = im.getImageModified();
		Platform.runLater(() -> imageViewer.setImage(immod3));
	    } catch (InterruptedException ex) {
		Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}).start();

    }

    @FXML
    void fourClick(Event event) {
	ImageProcess im = new ImageProcess(new Invert());
	imageViewer.setImage(im.getImageOriginal());

	new Thread(() -> {
	    try {
		Thread.sleep(1000);
		Image immod = im.getImageModified();
		Platform.runLater(() -> imageViewer.setImage(immod));
	    } catch (InterruptedException ex) {
		Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}).start();
    }

    @FXML
    void fiveClick(Event event) {
	ImageProcess im = new ImageProcess(new Blur());
	imageViewer.setImage(im.getImageOriginal());

	new Thread(() -> {
	    try {
		Thread.sleep(1000);
		Image immod = im.getImageModified();
		Platform.runLater(() -> imageViewer.setImage(immod));
	    } catch (InterruptedException ex) {
		Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}).start();

    }

    @FXML
    void sixClick(Event event) {
	ImageProcess im = new ImageProcess(new Sharpen());
	imageViewer.setImage(im.getImageOriginal());

	new Thread(() -> {
	    try {
		Thread.sleep(1000);
		Image immod = im.getImageModified();

		Platform.runLater(() -> imageViewer.setImage(immod));
	    } catch (InterruptedException ex) {
		Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}).start();

    }
    
    @FXML
    void sevenClick(Event event) {
	ImageProcess im = new ImageProcess(new OilEffect());
	imageViewer.setImage(im.getImageOriginal());

	new Thread(() -> {
	    try{
		Thread.sleep(1000);
		Image immod = im.getImageModified();
		Platform.runLater(() -> imageViewer.setImage(immod));
	    } catch (InterruptedException ex) {
		Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}).start();

    }

    @FXML
    void eightClick(Event event) {

	ImageProcess im = new ImageProcess(new PencilEffect());
	imageViewer.setImage(im.getImageOriginal());

	new Thread(() -> {
	    try {
		Thread.sleep(1000);
		Image immod = im.getImageModified();
		Platform.runLater(() -> imageViewer.setImage(immod));
	    } catch (InterruptedException ex) {
		Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}).start();

    }


//==========================================================================================

}

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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import ua.andxbes.filters.Blur;
import ua.andxbes.filters.Gray;
import ua.andxbes.filters.Invert;
import ua.andxbes.filters.OilEffect;
import ua.andxbes.filters.PencilEffect;
import ua.andxbes.filters.Sharpen;
import ua.andxbes.filters.SwitchThePalitra;
import ua.andxbes.filters.Turn;

public class Controller {

    public Controller() {

    }

    @FXML
    private RadioButton r2;

    @FXML
    private RadioButton r3;

    @FXML
    private RadioButton r4;

    @FXML
    private RadioButton r5;

    @FXML
    private GridPane rootPanel;

    @FXML
    private RadioButton r6;

    @FXML
    private RadioButton r7;

    @FXML
    private RadioButton r8;

    @FXML
    private ToggleGroup one;

    @FXML
    private ImageView imageViewer;

    @FXML
    private RadioButton r1;

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

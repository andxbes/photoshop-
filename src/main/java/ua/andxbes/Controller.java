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
import ua.andxbes.filters.Gray;
import ua.andxbes.filters.SwitchThePalitra;
import ua.andxbes.filters.Turn;

public class Controller {

    public Controller() {

    }

    @FXML
    private ImageView imageViewer;

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
    private ToggleGroup one;

    @FXML
    private RadioButton r1;

    @FXML
    void oneClick(Event event) {
	ImageProcess im = new ImageProcess();
	imageViewer.setImage(im.getImageOriginal());

	new Thread(() -> {
	    try {
		im.setFilter(new Gray());
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

	ImageProcess im = new ImageProcess();
	imageViewer.setImage(im.getImageOriginal());

	new Thread(() -> {
	    try {
		im.setFilter(new Turn());
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

	ImageProcess im = new ImageProcess();
	imageViewer.setImage(im.getImageOriginal());

	new Thread(() -> {
	    try {
		im.setFilter(new SwitchThePalitra());
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
	//imageViewer.setImage(new Image(new ImageProcess().getImageStreamOriginal()));

    }

    @FXML
    void fiveClick(Event event) {
	//imageViewer.setImage(new Image(new ImageProcess().getImageStreamOriginal()));

    }

    @FXML
    void sixClick(Event event) {
	//imageViewer.setImage(new Image(new ImageProcess().getImageStreamOriginal()));

    }

    @FXML
    void sevenClick(Event event) {
	//imageViewer.setImage(new Image(new ImageProcess().getImageStreamOriginal()));

    }
//==========================================================================================

}

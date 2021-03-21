/*
 * AnimalApplicationFX.java
 * @author Jadwiga Downarowicz
 * Created on Dec 11, 2019
 * A JavaFX application for storing animals in a queue
 */
package comp_139_lab_4;

import animals.*;
import comp_139_lab_4.*;
import exceptions.*;
import java.util.Iterator;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class AnimalOrderedListApplicationFX1 extends Application {

    private TextField nameTF = new TextField();
    private TextField weightTF = new TextField();
    private TextField ageTF = new TextField();
    private TextField lengthTF = new TextField();
    private TextField colorTF = new TextField();

    private Button reptileBt = new Button("Add Reptile");
    private Button mammalBT = new Button("Add Mammal");
    private Button removeFBT = new Button("Remove First");
    private Button removeLBT = new Button("Remove Last");
    private Button displayBT = new Button("Display");

    private TextArea textArea = new TextArea();
    /**
     * Creating an ordered list for storing animals
     */
    private final LinkedOrderedList<Animals> myZoo = new <Animals>LinkedOrderedList();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create the user interface
        GridPane infoPane = new GridPane();
        infoPane.setHgap(5);
        infoPane.setVgap(5);
        infoPane.add(new Label("Name"), 0, 0);
        infoPane.add(nameTF, 1, 0);
        infoPane.add(new Label("Weight (lb)"), 0, 1);
        infoPane.add(weightTF, 1, 1);
        infoPane.add(new Label("Age"), 0, 2);
        infoPane.add(ageTF, 1, 2);
        infoPane.add(new Label("Reptiles Length"), 0, 3);
        infoPane.add(lengthTF, 1, 3);
        infoPane.add(new Label("Mammals Color"), 0, 4);
        infoPane.add(colorTF, 1, 4);

        GridPane buttonPane = new GridPane();
        buttonPane.setHgap(15);
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.add(reptileBt, 0, 0);
        buttonPane.add(mammalBT, 1, 0);
        buttonPane.add(removeFBT, 2, 0);
        buttonPane.add(removeLBT, 3, 0);
        buttonPane.add(displayBT, 4, 0);
        infoPane.setAlignment(Pos.CENTER);
        nameTF.setAlignment(Pos.BOTTOM_RIGHT);
        weightTF.setAlignment(Pos.BOTTOM_RIGHT);
        ageTF.setAlignment(Pos.BOTTOM_RIGHT);
        lengthTF.setAlignment(Pos.BOTTOM_RIGHT);
        colorTF.setAlignment(Pos.BOTTOM_RIGHT);

        // Process events
        reptileBt.setOnAction(e -> addReptile());
        mammalBT.setOnAction(e -> addMammal());
        displayBT.setOnAction(e -> display());
        removeFBT.setOnAction(e -> removeFirstAnimal());
        removeLBT.setOnAction(e -> removeLastAnimal());

        BorderPane pane = new BorderPane();

        // Place nodes in the pane
        pane.setTop(infoPane);
        textArea.prefHeight(400);
        ScrollPane scrollPane = new ScrollPane(textArea);
        scrollPane.setFitToWidth(true);
        pane.setBottom(scrollPane);
        pane.setCenter(buttonPane);
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setTitle("Animals Info"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * Method addReptile creates a Reptile object and adds it to the list
     */
    private void addReptile() {
        try {
            Reptiles r = new Reptiles(nameTF.getText(),
                    Double.parseDouble(weightTF.getText()),
                    Integer.parseInt(ageTF.getText()),
                    Integer.parseInt(lengthTF.getText()));
            myZoo.add(r);
        } catch (InvalidNameException | InvalidWeightException
                | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Method assMammal creates a Mammal object and adds it to the list
     */
    private void addMammal() {
        try {
            Mammals m = new Mammals(nameTF.getText(),
                    Double.parseDouble(weightTF.getText()),
                    Integer.parseInt(ageTF.getText()),
                    colorTF.getText());
            myZoo.add(m);
        } catch (InvalidNameException | InvalidWeightException
                | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * displays the animals in the list
     */
    private void display() {
        textArea.setText("Animals:\n" + myZoo.Display());
        /*display text "Animals:" then call Display method from LinkedList
        class to display all elements in queue*/
    }

    /**
     * Method removeFrstAnimal removes the first animal from the list
     */
    private void removeFirstAnimal() {
        try {
            myZoo.removeFirst();  //returns the first object in the queue
        } catch (EmptyCollectionException ex) {
//catch an error if the queue is empty
            System.out.println(ex.getMessage()); //then send an error message
        }
    }

    /**
     * Method removeLastAnimal removes the last animal from the list
     */
    private void removeLastAnimal() {
        try {
            myZoo.removeLast();  //returns the first object in the queue
        } catch (EmptyCollectionException ex) {
//catch an error if the queue is empty
            System.out.println(ex.getMessage()); //then send an error message
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

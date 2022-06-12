package hust.soict.hedspi.gui.javafx.button;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.MotionBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
 
public class ButtonEffectDemo extends Application {
 
    @Override
    public void start(Stage primaryStage) throws Exception {
 
        FlowPane root = new FlowPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
 
        // --- Button 1 ------------
        Button button1 = new Button("Drop Shadow effect");
 
        DropShadow shadow = new DropShadow();
 
        // Adding the shadow when the mouse cursor is on
        button1.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                button1.setEffect(shadow);
            }
        });
 
        // Removing the shadow when the mouse cursor is off
        button1.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                button1.setEffect(null);
            }
        });
 
        // --- Button 2 ------------
        Button button2 = new Button("Motion Blur effect");
 
        MotionBlur motionBlur = new MotionBlur();
 
        // Adding the Motion Blur effect when the mouse cursor is on
        button2.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                button2.setEffect(motionBlur);
            }
        });
 
        // Removing the Motion Blur effect when the mouse cursor is off
        button2.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                button2.setEffect(null);
            }
        });
 
        root.getChildren().addAll(  button1, button2);
 
        primaryStage.setTitle("Java Button (o7planning.org)");
 
        Scene scene = new Scene(root, 350, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
 
    }
 
    public static void main(String[] args) {
        Application.launch(args);
    }
 
}
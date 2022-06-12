package hust.soict.hedspi.gui.javafx.label;

import java.io.InputStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
 
public class LabelIconDemo extends Application {
 
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        // Image Source
        InputStream input= getClass().getResourceAsStream("/hust/soict/hedspi/gui/javafx/menu/build-16.jpg");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
 
        Label label = new Label("JavaFX");
        
        // Set Image
        label.setGraphic(imageView);
 
        FlowPane root = new FlowPane();
        root.setPadding(new Insets(10));
        root.getChildren().add(label);
 
        Scene scene = new Scene(root, 200, 100);
 
        primaryStage.setTitle("JavaFX Label (o7planning.org)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        Application.launch(args);
    }
 
}
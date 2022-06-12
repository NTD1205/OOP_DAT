package hust.soict.hedspi.gui.javafx.button;

import java.io.InputStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
 
public class ButtonDemo extends Application {
 
    @Override
    public void start(Stage primaryStage) throws Exception {
 
        FlowPane root = new FlowPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
 
        // Button 1
        Button button1 = new Button("Button with Text");
 
        InputStream input = //
                getClass().getResourceAsStream("/hust/soict/hedspi/gui/javafx/menu/build-16.jpg");
 
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(15);
        imageView.setFitWidth(15);
 
        Button button2 = new Button("Button with Text & Image");
        button2.setGraphic(imageView);
 
        root.getChildren().addAll(button1, button2);
 
        primaryStage.setTitle("Java Button (o7planning.org)");
 
        Scene scene = new Scene(root, 350, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
 
    }
 
    public static void main(String[] args) {
        Application.launch(args);
    }
 
}
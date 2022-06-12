package hust.soict.hedspi.gui.javafx.label;

import java.io.InputStream;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class LabelFullDemo extends Application {
 
   @Override
   public void start(Stage primaryStage) throws Exception {
 
       // Image Source
       InputStream input = getClass().getResourceAsStream("/hust/soict/hedspi/gui/javafx/menu/build-16.jpg");
       Image image = new Image(input);
       ImageView imageView = new ImageView(image);
 
       // ------ Label 1 -----
       Label label1 = new Label("Label with Text & Icon");
 
       // Set Image
       label1.setGraphic(imageView);
 
       // ------ Label 2 -----
       Label label2 = new Label("Label With Font & Color");
 
       label2.setFont(Font.font("Cambria", 32));
       label2.setTextFill(Color.web("#0076a3"));
 
       // ------ Label 3 -----
       Label label3 = new Label("Long text label, wrap it!, using setWrapText(true)");
       label3.setMaxWidth(100);
 
       label3.setWrapText(true);
 
       // ------ Label 4 -----
       Label label4 = new Label("Rotate 45 degrees");
 
       // Rotate 45 degrees
       label4.setRotate(45);
 
       // Translate Y axis 30 pixel
       label4.setTranslateY(30);
 
       // ------ Label 5 -----
       Label label5 = new Label("Scale me!!");
 
       label5.setOnMouseEntered(new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent e) {
               label5.setScaleX(1.5);
               label5.setScaleY(1.5);
           }
       });
 
       label5.setOnMouseExited(new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent e) {
               label5.setScaleX(1);
               label5.setScaleY(1);
           }
       });
 
       FlowPane root = new FlowPane();
       root.setPadding(new Insets(10));
       root.setHgap(10);
       root.setVgap(10);
       root.getChildren().addAll(label1, label2, label3, label4, label5);
 
       Scene scene = new Scene(root, 400, 250);
 
       primaryStage.setTitle("JavaFX Label (o7planning.org)");
       primaryStage.setScene(scene);
       primaryStage.show();
   }
 
   public static void main(String[] args) {
       Application.launch(args);
   }
 
}
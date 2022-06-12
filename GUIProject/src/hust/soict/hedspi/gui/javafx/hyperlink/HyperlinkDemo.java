package hust.soict.hedspi.gui.javafx.hyperlink;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
 
public class HyperlinkDemo extends Application {
 
    @Override
    public void start(Stage stage) {
 
        Hyperlink hyperlink = new Hyperlink("Go to Eclipse home page");
 
        hyperlink.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                getHostServices().showDocument("https://eclipse.org");
            }
        });
 
        FlowPane root = new FlowPane();
        root.setPadding(new Insets(10));
        root.getChildren().addAll(hyperlink);
        Scene scene = new Scene(root);
 
        stage.setTitle("JavaFX Hiperlink (o7planning.org)");
 
        stage.setWidth(400);
        stage.setHeight(200);
 
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
 
}
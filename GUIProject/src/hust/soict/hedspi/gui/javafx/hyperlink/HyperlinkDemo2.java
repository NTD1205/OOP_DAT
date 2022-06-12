package hust.soict.hedspi.gui.javafx.hyperlink;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class HyperlinkDemo2 extends Application {
 
    private final String TEXT = "Go to Eclipse home page";
    
    @Override
    public void start(Stage stage) {
 
        Hyperlink hyperlink = new Hyperlink(TEXT);
 
        hyperlink.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                getHostServices().showDocument("https://eclipse.org");
            }
        });
 
        Button button1 = new Button("On/Off Visited");
 
        button1.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                boolean visited = hyperlink.isVisited();
                hyperlink.setVisited(!visited);
                hyperlink.setText(TEXT+" (visited:"+ hyperlink.isVisible()+")");
            }
        });
        
        Button button2 = new Button("On/Off Underline");
 
        button2.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                boolean underline = hyperlink.isUnderline();
                hyperlink.setUnderline(!underline);
                hyperlink.setText(TEXT+" (underline:"+ hyperlink.isUnderline()+")");
            }
        });
          
 
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);
        root.getChildren().addAll(hyperlink,button1,button2);
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
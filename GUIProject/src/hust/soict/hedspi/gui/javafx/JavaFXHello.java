package hust.soict.hedspi.gui.javafx;
	
import java.awt.ScrollPane;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
public class JavaFXHello extends Application {
	private Button btnHello;  // Declare a "Button" control
	private Button btnHello1;
	private Button btnHello2;
	private Button btnHello3;
	private Button btnHello4;
	private TextField tfCount;
	 private int count=0;
    @Override
    public void start(Stage primaryStage) {
        // Construct the "Button" and attach an "EventHandler"
        btnHello = new Button();
        btnHello.setText("Say Hello");
        // Using JDK 8 Lambda Expression to construct an EventHandler<ActionEvent>
        btnHello.setOnAction(evt->Print4());
        btnHello1 = new Button();
        btnHello1.setText("Say He");
        // Using JDK 8 Lambda Expression to construct an EventHandler<ActionEvent>
        btnHello1.setOnAction(evt->Print2());
        btnHello2 = new Button();
        btnHello2.setText("Say H");
        // Using JDK 8 Lambda Expression to construct an EventHandler<ActionEvent>
        btnHello2.setOnAction(evt->start1(primaryStage));
        RadioButton radioButton = new RadioButton("Radio Button");
        // Construct a scene graph of nodes
        FlowPane flow = new FlowPane();

	      flow.setPadding(new Insets(10, 12, 15, 12));  // top, right, bottom, left
	      flow.setVgap(10);  // Vertical gap between nodes in pixels
	      flow.setHgap(10);  // Horizontal gap between nodes in pixels
	      flow.setAlignment(Pos.BASELINE_CENTER);  // Alignment
	      flow.getChildren().addAll(btnHello, btnHello1, btnHello2,radioButton);
	   // Setup scene and stage
	      primaryStage.setScene(new Scene(flow, 300, 120));
	      primaryStage.setTitle("JavaFX Counter");
	      primaryStage.show();        // Set visible (show it)
    }
    public void start1(Stage stage) {

        Book book1 = new Book(1L, "J01", "Java IO Tutorial");
        Book book2 = new Book(2L, "J02", "Java Enums Tutorial");
        Book book3 = new Book(2L, "C01", "C# Tutorial for Beginners");

        Label label = new Label();
        btnHello3 = new Button();
        btnHello3.setText("Back to the menu");
        btnHello3.setOnAction(evt->start(stage));
        btnHello4 = new Button();
        btnHello4.setText("Insert ");
        btnHello4.setOnAction(evt->start(stage));
        // Using JDK 8 Lambda Expression to construct an EventHandler<ActionEvent>
        // To Creating a Observable List
        ObservableList<Book> books = FXCollections.observableArrayList(book1, book2, book3);

        // Create a ListView
        ListView<Book> listView = new ListView<Book>(books);

        // Only allowed to select single row in the ListView.
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

      
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Book>() {

            @Override
            public void changed(ObservableValue<? extends Book> observable, Book oldValue, Book newValue) {
                label.setText("OLD: " + oldValue + ",  NEW: " + newValue);
            }
        });
        VBox root = new VBox();
        root.getChildren().addAll(listView, label,btnHello4,btnHello3);

        stage.setTitle("ListView & ChangeListener (o7planning.org)");

        
       // root.getChildren().addAll(listView, label,btnHello3);
        
        //stage.setTitle("ListView & ChangeListener (o7planning.org)");
        
        Scene scene = new Scene(root, 300, 550);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
     public void Print() {
    	 System.out.println("afsa");
     }
     public void Print2() {
    	 System.out.println("adc");
     }
     public void Print3() {
    	 System.out.println("ade");
     }
     public void Print4() {
    	 ++count;
    	 System.out.println(count);
     }
}

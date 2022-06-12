package hust.soict.hedspi.gui.javafx.treeview;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TreeViewDemo extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		BookCategory catJava = new BookCategory("JAVA-00", "Java");
        BookCategory catJSP = new BookCategory("JAVA-01", "Jsp");
        BookCategory catSpring = new BookCategory("JAVA-02", "Spring");
     
        // Root Item
        TreeItem<BookCategory> rootItem = new TreeItem<BookCategory>(catJava);
        rootItem.setExpanded(true);
        
        // JSP Item
        TreeItem<BookCategory> itemJSP = new TreeItem<BookCategory>(catJSP);
        
        // Spring Item
        TreeItem<BookCategory> itemSpring = new TreeItem<>(catSpring);
        
        // Add to Root
        rootItem.getChildren().addAll(itemJSP, itemSpring);
        
        TreeView<BookCategory> tree = new TreeView<BookCategory>(rootItem);
        
        StackPane root = new StackPane();
        root.setPadding(new Insets(5));
        root.getChildren().add(tree);
        
        primaryStage.setTitle("JavaFX TreeView (o7planning.org)");
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
	}
	public static void main(String[] args) {
        launch(args);
    }

}

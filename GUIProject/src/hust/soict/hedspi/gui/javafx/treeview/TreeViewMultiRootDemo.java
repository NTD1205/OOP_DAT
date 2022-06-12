package hust.soict.hedspi.gui.javafx.treeview;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TreeViewMultiRootDemo extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		BookCategory catRoot = new BookCategory("ROOT", "Root");
		// Java
		BookCategory catJava = new BookCategory("JAVA-00", "Java");
		BookCategory catJSP = new BookCategory("JAVA-01", "Jsp");
		BookCategory catSpring = new BookCategory("JAVA-02", "Spring");
		// C#
		BookCategory catCSharp = new BookCategory("C#-00", "CSharp");
		BookCategory catWinForm = new BookCategory("C#-01", "Win Form");
		
		// Root Item
	    TreeItem<BookCategory> rootItem = new TreeItem<BookCategory>(catRoot);
	    rootItem.setExpanded(false);
	    // Java
       TreeItem<BookCategory> itemJava = new TreeItem<BookCategory>(catJava);
       TreeItem<BookCategory> itemJSP = new TreeItem<BookCategory>(catJSP);
       TreeItem<BookCategory> itemSpring = new TreeItem<BookCategory>(catSpring);
       itemJava.getChildren().addAll(itemJSP, itemSpring);
       
       // CSharp
       TreeItem<BookCategory> itemCSharp = new TreeItem<BookCategory>(catCSharp);
       TreeItem<BookCategory> itemWinForm = new TreeItem<BookCategory>(catWinForm);
       itemCSharp.getChildren().addAll(itemWinForm);
       
       // Add to Root
       rootItem.getChildren().addAll(itemJava,itemCSharp);
       
       TreeView<BookCategory> tree = new TreeView<BookCategory>(rootItem);
       
    // Hide the root Item.
       tree.setShowRoot(false);
      
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

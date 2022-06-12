package hust.soict.hedspi.gui.javafx.treeview;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.ChoiceBoxTreeCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TreeViewChoiceBoxDemo extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		 XmlTag tag0 = new XmlTag("div");
	      XmlTag tag1 = new XmlTag("span");
	      XmlTag tag2 = new XmlTag("font");
	      XmlTag tag21 = new XmlTag("font");
	      XmlTag tag3 = new XmlTag("color");
	      
	   // Root Item
	      TreeItem<XmlTag> rootItem = new TreeItem<XmlTag>(tag0);
	      rootItem.setExpanded(true);
	 
	      // Item 1
	      TreeItem<XmlTag> item1 = new TreeItem<XmlTag>(tag1);
	 
	      // Item 2
	      TreeItem<XmlTag> item2 = new TreeItem<XmlTag>(tag2);
	 
	      // Item 2.1
	      TreeItem<XmlTag> item21 = new TreeItem<XmlTag>(tag21);
	      item2.getChildren().add(item21);
	      item2.setExpanded(true);
	 
	      // Add to Root
	      rootItem.getChildren().addAll(item1, item2);
	      
	      TextArea textArea = new TextArea();
	      
	      TreeView<XmlTag> treeView = new TreeView<XmlTag>(rootItem);
	      treeView.setMaxHeight(180);
	      treeView.setEditable(true);
	      
	      treeView.setCellFactory(new Callback<TreeView<XmlTag>, TreeCell<XmlTag>>() {
	    	  
	          @Override
	          public TreeCell<XmlTag> call(TreeView<XmlTag> param) {
	              // ChoiceBox with 3 option.
	              return new ChoiceBoxTreeCell<XmlTag>(tag1, tag2, tag3);
	          }
	      });
	      
	      item2.addEventHandler(TreeItem.<XmlTag> valueChangedEvent(),
	              new EventHandler<TreeItem.TreeModificationEvent<XmlTag>>() {
	 
	                  @Override
	                  public void handle(TreeItem.TreeModificationEvent<XmlTag> event) {
	 
	                      textArea.appendText("Change to: " + event.getTreeItem().getValue().getTagName() + "\n");
	                  }
	 
	              });
	      
	   // Button
	      Button button = new Button("Print Info");
	    
	      button.setOnAction(new EventHandler<ActionEvent>() {
	 
	          @Override
	          public void handle(ActionEvent event) {
	              textArea.setText(null);
	                textArea.appendText("Item0: "+ rootItem.getValue().getTagName());
	                textArea.appendText("\nItem1: "+ item1.getValue().getTagName());
	              textArea.appendText("\nItem2: "+ item2.getValue().getTagName());
	              textArea.appendText("\nItem21: "+ item21.getValue().getTagName());
	          }
	      }); 
	      
	      VBox root = new VBox();
	      root.setPadding(new Insets(5));
	      root.setSpacing(5);
	      root.getChildren().addAll(treeView, textArea,button);
	 
	      primaryStage.setTitle("JavaFX TreeView (o7planning.org)");
	      primaryStage.setScene(new Scene(root, 450, 300));
	      primaryStage.show();  
	}
	
	 public static void main(String[] args) {
	      launch(args);
	  }
}

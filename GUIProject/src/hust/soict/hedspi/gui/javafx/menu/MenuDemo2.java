package hust.soict.hedspi.gui.javafx.menu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
 
public class MenuDemo2 extends Application {
 
    @Override
    public void start(Stage stage) {
        // Create MenuBar
        MenuBar menuBar = new MenuBar();
 
        // Create menus
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu projectMenu = new Menu("Project");
        Menu helpMenu = new Menu("Help");
 
        // Create MenuItems
        MenuItem newItem = new MenuItem("New");
        Image newImage = MyImageUtils.getImage("/hust/soict/hedspi/gui/javafx/menu/build-16.jpg");
        ImageView newImageView = new ImageView(newImage);
        newImageView.setFitHeight(15);
        newImageView.setFitWidth(15);
        newItem.setGraphic(newImageView);
 
        MenuItem openFileItem = new MenuItem("Open File");
        // SeparatorMenuItem.
        SeparatorMenuItem separator= new SeparatorMenuItem();
        MenuItem exitItem = new MenuItem("Exit");
 
        MenuItem copyItem = new MenuItem("Copy");
        MenuItem pasteItem = new MenuItem("Paste");
        
        // CheckMenuItem
        CheckMenuItem buildItem = new CheckMenuItem("Build Automatically");
        Image buildImage = MyImageUtils.getImage("/hust/soict/hedspi/gui/javafx/menu/new-16.jpg");
        ImageView buildImageView = new ImageView(buildImage);
        buildImageView.setFitHeight(15);
        buildImageView.setFitWidth(15);
        buildItem.setGraphic(buildImageView);
        buildItem.setSelected(true);
 
        // RadioMenuItem
        RadioMenuItem updateItem1 = new RadioMenuItem("Auto Update");
        RadioMenuItem updateItem2 = new RadioMenuItem("Ask for Update");
        
        ToggleGroup group = new ToggleGroup();
        updateItem1.setToggleGroup(group);
        updateItem2.setToggleGroup(group);
        updateItem1.setSelected(true);
        
        // Add menuItems to the Menus
        fileMenu.getItems().addAll(newItem, openFileItem,separator, exitItem);
        editMenu.getItems().addAll(copyItem, pasteItem);
        projectMenu.getItems().add(buildItem);
        helpMenu.getItems().addAll(updateItem1,updateItem2);
 
        // Add Menus to the MenuBar
        menuBar.getMenus().addAll(fileMenu, editMenu, projectMenu, helpMenu);
 
        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        Scene scene = new Scene(root, 350, 200);
 
        stage.setTitle("JavaFX Menu (o7planning.org)");
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        Application.launch(args);
    }
 
}
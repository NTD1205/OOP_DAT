package hust.soict.hedspi.gui.javafx.webview;
	
import java.io.File;
import java.net.MalformedURLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class WebViewDemo extends Application {
	
	@Override 
	public void start(final Stage stage) {
		//Button buttonURL = new Button("Load Page https://eclipse.org");
		Button buttonHtmlString = new Button("Load HTML String");
		//Button buttonHtmlFile = new Button("Load File C:/test/a.html");
		
		final WebView browser = new WebView();
		final WebEngine webEngine = browser.getEngine();
		
		/*buttonURL.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				String url = "https://eclipse.org";
				webEngine.load(url);
			}
		});*/
		
		buttonHtmlString.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String html = "<html><h1>Hello</h1><h2>Hello</h2></html>";
				webEngine.loadContent(html);
			}
		});
		
		/*buttonHtmlFile.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					File file = new File("E:/Hoang/JavaTest/a.html");
					java.net.URL url = file.toURI().toURL();
					System.out.println("Local URL:" +url.toString());
					webEngine.load(url.toString());
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});*/
		
		VBox root = new VBox();
		root.setPadding(new Insets(5));
		root.setSpacing(5);
		root.getChildren().addAll( buttonHtmlString, browser);
		
		Scene scene = new Scene(root);
		
		stage.setTitle("JavaFX WebView (o7planning.org)");
		stage.setScene(scene);
		stage.setWidth(450);
		stage.setHeight(300);
		
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

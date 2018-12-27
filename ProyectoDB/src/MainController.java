import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MainController extends Application {

	public static void main(String[] args){
		//launch() will call start() for the JavaFX application
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml")); 
		Scene scene = new Scene(root);
		primaryStage.setTitle("My Title");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}

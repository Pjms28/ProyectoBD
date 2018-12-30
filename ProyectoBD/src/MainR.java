import java.io.IOException;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainR {
	@FXML private RadioButton rb1;
	@FXML private RadioButton rb2;
	@FXML private Label lb1;
	@FXML private TextField tf1;
	
	
	public void radioSelect (ActionEvent event) {
		if(rb1.isSelected()) {
			lb1.setDisable(true);
			tf1.setDisable(true);
		}
		if(rb2.isSelected()) {
			lb1.setDisable(false);
			tf1.setDisable(false);
		}

	}
	
public void CambiarEscenaL(ActionEvent event) throws IOException{
	Parent LicenciaView= FXMLLoader.load(getClass().getClassLoader().getResource("Licencia.fxml"));
	Scene LicenciaEscena = new Scene (LicenciaView);
	Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow();
	
	window.setScene(LicenciaEscena);
	window.show();
	
		
	}

	

}

import java.io.IOException;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainR {
	@FXML private RadioButton rb1;
	@FXML private RadioButton rb2;
	@FXML private Label lb1;
	@FXML private Label lb2;
	@FXML private Label lb3;
	@FXML private Label lb4;
	@FXML private Label lb5;
	@FXML private Label lb6;
	@FXML private Label lb7;
	@FXML private Label lb8;
	@FXML private Label lb9;
	@FXML private TextField tf1;
	@FXML private TextField tf2;
	@FXML private TextField tf3;
	@FXML private TextField tf4;
	@FXML private TextField tf5;
	@FXML private TextField tf9;
	@FXML private TableView<Visita> tableview;
	@FXML private TableColumn<Visita, String> tc1;
	@FXML private TableColumn<Visita, String> tc2;
	@FXML private TableColumn<Visita, String> tc3;
	@FXML private TableColumn<Visita, String> tc4;	
	
	
	@FXML
	public void initialize(){
		
	}
	
	
	
	
	
	
	
	public void radioSelect (ActionEvent event) {
		
		
		
		if(rb1.isSelected()) {
			lb8.setDisable(true);
			tf1.setDisable(true);
			lb4.setDisable(false);
			tf2.setDisable(false);
			lb6.setDisable(false);
			tf4.setDisable(false);
		}
		if(rb2.isSelected()) {
			lb8.setDisable(false);
			tf1.setDisable(false);
			lb4.setDisable(true);
			tf2.setDisable(true);
			lb6.setDisable(true);
			tf4.setDisable(true);
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

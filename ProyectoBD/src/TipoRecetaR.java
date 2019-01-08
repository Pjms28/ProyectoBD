import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TipoRecetaR {
	String mensaje = "";
	Receta rec=new Receta();
	RecetaMedicina recm=new RecetaMedicina();
	RecetaAnalisis reca=new RecetaAnalisis();
	RecetaBO Rbo = new RecetaBO();
	@FXML private ComboBox<Integer> cbe2;
	@FXML private ComboBox<Integer> cbe3;
	@FXML private ComboBox<Integer> cbe4;
	@FXML private RadioButton rbr1;
	@FXML private RadioButton rbr2;
	@FXML private TextField tfr1;
	@FXML private Label lbr1;
	@FXML private Label lbr2;
	@FXML private Label lbr3;
	@FXML private Label lbr4;
	@FXML private Label lbr5;
	@FXML private Label titulo;
	
	public void CambiarEscenaR(ActionEvent event) throws IOException{
		Parent LicenciaView= FXMLLoader.load(getClass().getClassLoader().getResource("Receta.fxml"));
		Scene LicenciaEscena = new Scene (LicenciaView);
		Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(LicenciaEscena);
		window.show();
		
			
		}

}

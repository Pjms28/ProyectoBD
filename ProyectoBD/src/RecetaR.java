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

public class RecetaR {
	
	
	@FXML private Label lbr1;
	@FXML private Label lbr2;
	@FXML private Label lbr3;
	@FXML private Label lbr4;
	@FXML private Label lbr5;
	@FXML private TextField tfr1;
	@FXML private RadioButton rbr1;
	@FXML private RadioButton rbr2;
	
	public void CambiarEscenaVi(ActionEvent event) throws IOException{
		Parent VisitaView= FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml"));
		Scene VisitaEscena = new Scene (VisitaView);
		Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(VisitaEscena);
		window.show();
		
			
		}
	
	public void radioSelect (ActionEvent event) {
		if(rbr1.isSelected()) {
			lbr5.setDisable(true);
			tfr1.setDisable(true);
			

		}
		else if(rbr2.isSelected()) {
			lbr5.setDisable(false);
			tfr1.setDisable(false);
		}
		

	}
	
	

}
